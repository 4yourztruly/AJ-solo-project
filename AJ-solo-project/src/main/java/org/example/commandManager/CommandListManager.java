package org.example.commandManager;

import org.example.commands.Command;

import java.util.ArrayList;

public class CommandListManager implements CommandManager {
    private final ArrayList<Command>commands = new ArrayList<>();

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public ArrayList<Command> getCommands() {
        return commands;
    }
}
