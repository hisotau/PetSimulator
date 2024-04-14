package org.hisotau.petsimulator.eventsListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class events implements Listener {

    @EventHandler
    public void testing(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType() == Material.SPONGE) {
            final Player player =  (Player) e.getPlayer();
            Bukkit.broadcastMessage(ChatColor.BOLD + " " + ChatColor.LIGHT_PURPLE + "Ксюша зайка <3");
        }
    }
}
