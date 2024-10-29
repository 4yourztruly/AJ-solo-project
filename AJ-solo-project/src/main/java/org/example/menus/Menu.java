package org.example.menus;

import org.example.dependencies.Dependencies;

public abstract class Menu {
    private final String name;
    protected Dependencies dependencies;

    public abstract void display();

    public Menu(String name,Dependencies dependencies) {
        this.name = name;
        this.dependencies = dependencies;
    }

    public String getName() {
        return name;
    }
}
