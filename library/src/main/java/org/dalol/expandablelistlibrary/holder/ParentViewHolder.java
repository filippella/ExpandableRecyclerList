package org.dalol.expandablelistlibrary.holder;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import org.dalol.expandablelistlibrary.callback.ExpandableItemActionListener;
import org.dalol.expandablelistlibrary.model.ExpandableMenu;
import org.dalol.expandablelistlibrary.model.ExpandedState;

import java.util.List;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 10/29/2016
 */
public abstract class ParentViewHolder extends RecyclerView.ViewHolder {

    private static final int ARROW_ROTATION_DURATION = 250;

    private final ImageView handle;
    private ExpandableMenu mExpandableMenu;
    private ExpandableItemActionListener mActionListener;

    public ParentViewHolder(View itemView) {
        super(itemView);
        handle = (ImageView) itemView.findViewById(getArrowId());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ExpandableMenu> menuItems = mExpandableMenu.getMenuItems();
                int count = menuItems.size();
                int position = getAdapterPosition();

                if (isExpanded()) {
                    if (mActionListener != null) {
                        mActionListener.onAction(ExpandedState.COLLAPSED, position, count);
                    }
                    closeArrow();
                } else {
                    if (mActionListener != null) {
                        mActionListener.onAction(ExpandedState.EXPANDED, position, count);
                    }
                    openArrow();
                }
            }
        });
    }

    public void setActionListener(ExpandableItemActionListener actionListener) {
        mActionListener = actionListener;
    }

    public void bind(ExpandableMenu expandableMenu) {
        mExpandableMenu = expandableMenu;
        handle.setRotation(isExpanded() ? -90 : 90);
    }

    protected boolean isExpanded() {
        return mExpandableMenu.getState() == ExpandedState.EXPANDED;
    }

    public void openArrow() {
        if (handle != null) {
            handle.animate().setDuration(ARROW_ROTATION_DURATION).rotation(-90);
        }
    }

    public void closeArrow() {
        if (handle != null) {
            handle.animate().setDuration(ARROW_ROTATION_DURATION).rotation(90);
        }
    }

    @IdRes protected abstract int getArrowId();
}
