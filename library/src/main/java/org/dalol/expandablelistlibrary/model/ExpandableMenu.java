/*
 * Copyright (c) 2016 Dalol Technology Services
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dalol.expandablelistlibrary.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 10/2/2016
 */
public class ExpandableMenu<T> {

    private final ExpandableType mExpandableType;
    private ExpandedState mState = ExpandedState.COLLAPSED;
    private List<ExpandableMenu> mMenuItems = new ArrayList<>();
    private T mMenuInfo;

    public ExpandableMenu(ExpandableType expandableType) {
        mExpandableType = expandableType;
    }

    public void addMenuInfo(T info) {
        mMenuInfo = info;
    }

    public T getMenuInfo() {
        return mMenuInfo;
    }

    public void setExpandedState(ExpandedState state) {
        mState = state;
    }

    public ExpandableMenu addSubMenu(ExpandableMenu expandableMenu) {
        mMenuItems.add(expandableMenu);
        return this;
    }

    public ExpandableMenu addSubMenus(List<ExpandableMenu> menuItems) {
        mMenuItems.addAll(menuItems);
        return this;
    }

    public ExpandedState getState() {
        return mState;
    }

    public ExpandableType getExpandableType() {
        return mExpandableType;
    }

    public List<ExpandableMenu> getMenuItems() {
        return mMenuItems;
    }
}
