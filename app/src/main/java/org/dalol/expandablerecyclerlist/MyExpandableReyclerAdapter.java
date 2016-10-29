package org.dalol.expandablerecyclerlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.dalol.expandablelistlibrary.adapter.ExpandableRecyclerAdapter;
import org.dalol.expandablelistlibrary.holder.ChildViewHolder;
import org.dalol.expandablelistlibrary.holder.ParentViewHolder;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 10/29/2016
 */
public class MyExpandableReyclerAdapter extends ExpandableRecyclerAdapter<MyExpandableReyclerAdapter.MyParentViewHolder,
        MyExpandableReyclerAdapter.MyChildViewHolder> {

    public MyExpandableReyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected MyChildViewHolder onCreateChildViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new MyChildViewHolder(inflater.inflate(R.layout.item_child_layout, parent, false));
    }

    @Override
    protected MyParentViewHolder onCreateParentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new MyParentViewHolder(inflater.inflate(R.layout.item_parent_layout, parent, false));
    }

    @Override
    protected void onBindChildViewHolder(MyChildViewHolder holder) {
    }

    @Override
    protected void onBindParentViewHolder(MyParentViewHolder holder) {

    }

    public class MyParentViewHolder extends ParentViewHolder {

        public MyParentViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onParentHolderClick(View view, int position) {

        }

        @Override
        protected int getArrowId() {
            return R.id.handle;
        }
    }

    public class MyChildViewHolder extends ChildViewHolder implements View.OnClickListener {

        public MyChildViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String info = mExpandableMenu.getMenuInfo().toString();
            Toast.makeText(v.getContext(), info + " -- Child clicked on Position " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
