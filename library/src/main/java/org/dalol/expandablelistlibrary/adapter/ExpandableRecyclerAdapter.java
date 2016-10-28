package org.dalol.expandablelistlibrary.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.dalol.expandablelistlibrary.holder.ExpandableItemHolder;
import org.dalol.expandablelistlibrary.model.ExpandableMenu;
import org.dalol.expandablelistlibrary.model.ExpandableType;
import org.dalol.expandablelistlibrary.model.ExpandedState;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 10/28/2016
 */
public abstract class ExpandableRecyclerAdapter extends RecyclerView.Adapter<ExpandableItemHolder> {

    private final List<ExpandableMenu> mAllList = new ArrayList<>();
    private static final int ARROW_ROTATION_DURATION = 150;
    private LayoutInflater mInflater;

    public ExpandableRecyclerAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return mAllList.get(position).getExpandableType().getType();
    }

    @Override
    public ExpandableItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == ExpandableType.TYPE_MENU.getType()) {
            view = mInflater.inflate(getParentContentView(), parent, false);
        } else {
            view = mInflater.inflate(getChildContentView(), parent, false);
        }
        return new ExpandableItemHolder(view);
    }

    protected abstract int getChildContentView();

    protected abstract int getParentContentView();

    @Override
    public void onBindViewHolder(ExpandableItemHolder holder, int position) {
            bindExpandableHolder(holder);
            onBindExpandableHolder(holder, mAllList.get(position));

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private void onBindExpandableHolder(ExpandableItemHolder holder, ExpandableMenu expandableMenu) {
        //holder.setItemActionListener();
    }

    private void bindExpandableHolder(ExpandableItemHolder holder) {
        holder.setItemActionListener(new ExpandableItemHolder.ExpandableItemActionListener() {
            @Override
            public void setActionListener(View parentView, final int position) {
                ExpandableType expandableType = mAllList.get(position).getExpandableType();
                parentView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int viewType = getItemViewType(position);
                        if (viewType == ExpandableType.TYPE_MENU.getType()) {

                            final ImageView handle = (ImageView) v.findViewById(getArrowId());
                            v.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if(isExpanded(position)) {
                                        collapseSubMenus(position, handle, false);
                                    } else {
                                        expandSubMenus(position, handle, false);

                                    }
                                }
                            });
                            handle.setRotation(isExpanded(position) ? 90 : 0);
                        }
                    }
                });
            }
        });
    }

    @IdRes protected abstract int getArrowId();

    @Override
    public int getItemCount() {
        return mAllList.size();
    }

    private boolean isExpanded(int position) {
        ExpandableMenu expandableMenu = mAllList.get(position);
        return expandableMenu.getState() == ExpandedState.EXPANDED;
    }

    private void expandSubMenus(int position, ImageView handle, boolean b) {
        ExpandableMenu expandableMenu = mAllList.get(position);
        List<ExpandableMenu> menuItems = expandableMenu.getMenuItems();
        for (int i = 0; i < menuItems.size(); i++) {
            mAllList.add(position + i + 1, menuItems.get(i));
            notifyItemInserted(position + 1);
        }
        expandableMenu.setExpandedState(ExpandedState.EXPANDED);
        if (handle != null) {
            openArrow(handle);
        }

        if (b) {
            notifyItemChanged(position);
        }
        collapseAllExcept(position);
    }

    private void collapseSubMenus(int position, ImageView handle, boolean b) {
        ExpandableMenu expandableMenu = mAllList.get(position);
        List<ExpandableMenu> menuItems = expandableMenu.getMenuItems();
        for (int i = 0; i < menuItems.size(); i++) {
            mAllList.remove(menuItems.get(i));
//            mSubMenuList.add(menuItems)
            //addMenu(menuItems.get(i));
        }
        //notifyDataSetChanged();
        expandableMenu.setExpandedState(ExpandedState.COLLAPSED);
        if (handle != null) {
            closeArrow(handle);
        }
        notifyItemRangeRemoved(position + 1, menuItems.size());
        if (b) {
            notifyItemChanged(position);
        }
    }

    public void collapseAllExcept(int position) {
        for (int i = mAllList.size() - 1; i >= 0; i--) {
            if (i != position && getItemViewType(i) == ExpandableType.TYPE_MENU.getType()) {
                if (isExpanded(i)) {
                    collapseSubMenus(i, null, true);
                }
            }
        }
    }

    public void openArrow(View view) {
        view.animate().setDuration(ARROW_ROTATION_DURATION).rotation(-90);
    }

    public void closeArrow(View view) {
        view.animate().setDuration(ARROW_ROTATION_DURATION).rotation(0);
    }

    public void setExpandableMenuList(List<ExpandableMenu> expandableMenuList) {
        mAllList.addAll(expandableMenuList);
    }
}
