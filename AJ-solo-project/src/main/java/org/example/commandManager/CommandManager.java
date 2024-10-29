package org.example.commandManager;

import org.example.commands.Command;

import java.util.ArrayList;

public interface CommandManager {
    void addCommand(Command command);
    ArrayList<Command> getCommands();
}
