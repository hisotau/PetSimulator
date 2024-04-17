package org.hisotau.petsimulator;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.hisotau.petsimulator.commands.summonPetCMD;
import org.hisotau.petsimulator.scoreboard.Board;


public final class PetSimulator extends JavaPlugin {

    private BukkitTask task;
    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("Plugin started...");
        getServer().getPluginCommand("pet").setExecutor(new summonPetCMD());
        task = getServer().getScheduler().runTaskTimer(this, Board.getInstance(),0,20);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin stopped...");
        // Plugin shutdown logic
        assert task != null;
        if (!task.isCancelled())
        {
            task.cancel();
        }
    }
    public static PetSimulator getInstance(){
        return getPlugin(PetSimulator.class);
    }
}
