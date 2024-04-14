package org.hisotau.petsimulator.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CalculatorCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        int a, b;
        a = Integer.parseInt(strings[0]);
        b = Integer.parseInt(strings[2]);

        if (strings[1].equals("+"))
        {
            commandSender.sendMessage("Result: " + (a+b));
            return true;
        }
        else if (strings[1].equals("-"))
        {
            commandSender.sendMessage("Result: " + (a-b));
            return true;
        }
        else if (strings[1].equals("*"))
        {
            commandSender.sendMessage("Result: " + (a*b));
            return true;
        }
        else if (strings[1].equals("/")){
            commandSender.sendMessage("Result: " + (a/b));
            return true;
        }
        return false;
    }
}
