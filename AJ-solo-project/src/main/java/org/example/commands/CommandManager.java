package org.example.commands;

import java.util.ArrayList;

public interface CommandManager {
    void addCommand(Command command);
    ArrayList<Command> getCommands();
}
