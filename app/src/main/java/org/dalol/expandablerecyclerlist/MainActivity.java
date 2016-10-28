package org.dalol.expandablerecyclerlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.dalol.expandablelistlibrary.adapter.ExpandableRecyclerAdapter;
import org.dalol.expandablelistlibrary.model.ExpandableMenu;
import org.dalol.expandablelistlibrary.model.ExpandableType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerList = (RecyclerView) this.findViewById(R.id.recyclerList);
        mRecyclerList.setHasFixedSize(true);
        mRecyclerList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<ExpandableMenu> expandableMenus = populateMenus();

        ExpandableRecyclerAdapter adapter = new ExpandableRecyclerAdapter(this) {
            @Override
            protected int getChildContentView() {
                return R.layout.item_child_layout;
            }

            @Override
            protected int getParentContentView() {
                return R.layout.item_parent_layout;
            }

            @Override
            protected int getArrowId() {
                return R.id.handle;
            }
        };
        adapter.setExpandableMenuList(expandableMenus);
        mRecyclerList.setAdapter(adapter);
    }

    private List<ExpandableMenu> populateMenus() {
        List<ExpandableMenu> expandableMenuList = new ArrayList<>();

        ExpandableMenu expandableMenu = new ExpandableMenu(ExpandableType.TYPE_MENU);
        for(int i = 0; i < 2; i++) {
            ExpandableMenu<String> menuItem = new ExpandableMenu(ExpandableType.TYPE_ITEM);
            menuItem.addMenuInfo("Filippo " + i);
            expandableMenu.addSubMenu(menuItem);
        }
        expandableMenuList.add(expandableMenu);

        ExpandableMenu expandableMenu2 = new ExpandableMenu(ExpandableType.TYPE_MENU);
        for(int i = 0; i < 3; i++) {
            ExpandableMenu<String> menuItem = new ExpandableMenu(ExpandableType.TYPE_ITEM);
            menuItem.addMenuInfo("Marta " + i);
            expandableMenu2.addSubMenu(menuItem);
        }
        expandableMenuList.add(expandableMenu2);

        ExpandableMenu expandableMenu3 = new ExpandableMenu(ExpandableType.TYPE_MENU);
        for(int i = 0; i < 3; i++) {
            ExpandableMenu<String> menuItem = new ExpandableMenu(ExpandableType.TYPE_ITEM);
            menuItem.addMenuInfo("Piyanki " + i);
            expandableMenu3.addSubMenu(menuItem);
        }
        expandableMenuList.add(expandableMenu3);
        return expandableMenuList;
    }
}
