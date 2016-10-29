package org.dalol.expandablerecyclerlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dalol.expandablelistlibrary.adapter.ExpandableRecyclerAdapter;
import org.dalol.expandablelistlibrary.holder.ChildViewHolder;
import org.dalol.expandablelistlibrary.holder.ParentViewHolder;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 10/29/2016
 */
public class MyExpandableReyclerAdapter extends ExpandableRecyclerAdapter<MyExpandableReyclerAdapter.MyParentViewHolder, ChildViewHolder> {

    public MyExpandableReyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected ChildViewHolder onCreateChildViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new ChildViewHolder(inflater.inflate(R.layout.item_child_layout, parent, false));
    }

    @Override
    protected MyParentViewHolder onCreateParentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new MyParentViewHolder(inflater.inflate(R.layout.item_parent_layout, parent, false));
    }

    @Override
    protected void onBindChildViewHolder(ChildViewHolder holder) {

    }

    @Override
    protected void onBindParentViewHolder(MyParentViewHolder holder) {

    }

    public class MyParentViewHolder extends ParentViewHolder {

        public MyParentViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected int getArrowId() {
            return R.id.handle;
        }
    }
}
