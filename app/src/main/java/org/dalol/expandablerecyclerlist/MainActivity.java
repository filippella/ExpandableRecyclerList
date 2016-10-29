package org.dalol.expandablerecyclerlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import org.dalol.expandablelistlibrary.model.ExpandableMenu;
import org.dalol.expandablelistlibrary.model.ExpandableType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerList;
    private MainController controller;
    private CheckBox mSelectMode;
    private MyExpandableReyclerAdapter myExpandableReyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerList = (RecyclerView) this.findViewById(R.id.recyclerList);
        mSelectMode = (CheckBox) this.findViewById(R.id.selectMode);
        mRecyclerList.setHasFixedSize(true);
        mRecyclerList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        controller = new MainController(this);

        List<ExpandableMenu> expandableMenus = populateMenus();

        myExpandableReyclerAdapter = new MyExpandableReyclerAdapter(this);
        myExpandableReyclerAdapter.setExpandableMenuList(expandableMenus);
        mRecyclerList.setAdapter(myExpandableReyclerAdapter);

        mSelectMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    myExpandableReyclerAdapter.setAccordionStyle(true);
                }  else {
                    myExpandableReyclerAdapter.setAccordionStyle(false);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionAbout:
                controller.showAbout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<ExpandableMenu> populateMenus() {
        List<ExpandableMenu> expandableMenuList = new ArrayList<>();

        ExpandableMenu expandableMenu = new ExpandableMenu(ExpandableType.TYPE_PARENT);
        for(int i = 0; i < 2; i++) {
            ExpandableMenu<String> menuItem = new ExpandableMenu(ExpandableType.TYPE_CHILD);
            menuItem.addMenuInfo("Filippo " + i);
            expandableMenu.addSubMenu(menuItem);
        }
        expandableMenuList.add(expandableMenu);

        ExpandableMenu expandableMenu2 = new ExpandableMenu(ExpandableType.TYPE_PARENT);
        for(int i = 0; i < 5; i++) {
            ExpandableMenu<String> menuItem = new ExpandableMenu(ExpandableType.TYPE_CHILD);
            menuItem.addMenuInfo("Marta " + i);
            expandableMenu2.addSubMenu(menuItem);
        }
        expandableMenuList.add(expandableMenu2);

        ExpandableMenu expandableMenu3 = new ExpandableMenu(ExpandableType.TYPE_PARENT);
        for(int i = 0; i < 3; i++) {
            ExpandableMenu<String> menuItem = new ExpandableMenu(ExpandableType.TYPE_CHILD);
            menuItem.addMenuInfo("Piyanki " + i);
            expandableMenu3.addSubMenu(menuItem);
        }
        expandableMenuList.add(expandableMenu3);

        ExpandableMenu expandableMenu4 = new ExpandableMenu(ExpandableType.TYPE_PARENT);
        for(int i = 0; i < 10; i++) {
            ExpandableMenu<String> menuItem = new ExpandableMenu(ExpandableType.TYPE_CHILD);
            menuItem.addMenuInfo("Yolanda " + i);
            expandableMenu4.addSubMenu(menuItem);
        }
        expandableMenuList.add(expandableMenu4);

        ExpandableMenu expandableMenu5 = new ExpandableMenu(ExpandableType.TYPE_PARENT);
        for(int i = 0; i < 3; i++) {
            ExpandableMenu<String> menuItem = new ExpandableMenu(ExpandableType.TYPE_CHILD);
            menuItem.addMenuInfo("Engidashet " + i);
            expandableMenu5.addSubMenu(menuItem);
        }
        expandableMenuList.add(expandableMenu5);

        return expandableMenuList;
    }
}
