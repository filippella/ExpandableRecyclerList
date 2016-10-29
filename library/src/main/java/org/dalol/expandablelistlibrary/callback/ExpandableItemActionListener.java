package org.dalol.expandablelistlibrary.callback;

import org.dalol.expandablelistlibrary.model.ExpandedState;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 10/29/2016
 */
public interface ExpandableItemActionListener {

    /**
     * This method will notify a click on a holder
     *
     * @param state
     * @param startPosition
     * @param totalCount
     */
    void onAction(ExpandedState state, int startPosition, int totalCount);
}
