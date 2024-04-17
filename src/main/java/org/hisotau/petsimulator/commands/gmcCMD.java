package org.hisotau.petsimulator.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gmcCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("Testing");
            return false;
        }
        Player player = (Player) commandSender;
        player.setGameMode(GameMode.CREATIVE);
        Bukkit.broadcastMessage("§a§lHSTUDEV // " + "§RРежим игры изменен на: " + "§6Креатив" + "§R.");
        return true;
    }
}
