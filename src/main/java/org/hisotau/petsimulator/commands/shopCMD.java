package org.hisotau.petsimulator.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.hisotau.petsimulator.PetSimulator;

public class shopCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            System.out.println();
            return false;
        }
        Player player = (Player) sender;
        Inventory inventory = Bukkit.createInventory(player,9*6,
                ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Pets Shops");


        player.openInventory(inventory);
        player.setMetadata("OpenedMenu",new FixedMetadataValue(PetSimulator.getInstance(),"Shop menu"));
        return true;
    }
}
