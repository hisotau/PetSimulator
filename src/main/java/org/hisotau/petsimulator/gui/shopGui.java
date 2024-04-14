package org.hisotau.petsimulator.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.hisotau.petsimulator.PetSimulator;

public class shopGui implements Listener {

    @EventHandler
    public void OnClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (player.hasMetadata("OpenedMenu")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void closeClick(InventoryCloseEvent e) {

        Player player = (Player) e.getPlayer();
        if (player.hasMetadata("OpenedMenu")) {
            player.removeMetadata("OpenedMenu", PetSimulator.getInstance());
        }
    }
}
