package org.hisotau.petsimulator.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gmsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        player.setGameMode(GameMode.SURVIVAL);
        Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "HstuDev // " + ChatColor.RESET + "Режим игры изменен на: " + ChatColor.GOLD + "Выживание" + ChatColor.RESET + ".");
        return true;
    }
}