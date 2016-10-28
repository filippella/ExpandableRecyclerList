package org.dalol.expandablelistlibrary.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 10/28/2016
 */
public class ExpandableItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ExpandableItemHolder(View itemView) {
        super(itemView);
    }

    public void setItemActionListener(ExpandableItemActionListener actionListener) {
        actionListener.setActionListener(itemView, getAdapterPosition());
    }

    @Override
    public void onClick(View v) {

    }

    public interface ExpandableItemActionListener {

        void setActionListener(View parentView, int position);
    }
}
