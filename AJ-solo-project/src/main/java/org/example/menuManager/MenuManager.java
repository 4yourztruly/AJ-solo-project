package org.example.menuManager;

import org.example.menus.Menu;

import java.util.ArrayList;

public interface MenuManager {
    void addMenu(Menu menu);
    ArrayList<Menu> getMenus();
    Menu getMenu(String name);
}
