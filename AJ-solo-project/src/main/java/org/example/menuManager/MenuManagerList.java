package org.example.menuManager;

import org.example.menus.Menu;

import java.util.ArrayList;

public class MenuManagerList implements MenuManager{
    private final ArrayList<Menu> menus = new ArrayList<>();
    @Override
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    @Override
    public ArrayList<Menu> getMenus() {
        return menus;
    }

    @Override
    public Menu getMenu(String name) {
        Menu menuValue = null;
        for(Menu menu : menus) {
            if(name.equalsIgnoreCase(menu.getName())) {
                menuValue = menu;
            }
        }
        return menuValue;
    }
}
