package org.hisotau.petsimulator;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.hisotau.petsimulator.commands.summonPetCMD;
import org.hisotau.petsimulator.eventsListener.events;
import org.hisotau.petsimulator.scoreboard.Board;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class PetSimulator extends JavaPlugin {

    private BukkitTask task;
    @Override
    public void onEnable() {
        // Plugin startup logic
       saveDefaultConfig();
       // Configs.load(getConfig());
//        List<enumCommands> listCommands = Arrays.asList(
//                enumCommands.CALCULATOR,
//                enumCommands.GMC,
//                enumCommands.GMS,
//                enumCommands.SHOP,
//                enumCommands.SUMMON_PET);
//
//        for (enumCommands command : listCommands) {
//            Objects.requireNonNull(getCommand(command.getName())).setExecutor(command.getExecutor());
//        }

        getServer().getPluginCommand("pet").setExecutor(new summonPetCMD());
        getServer().getPluginManager().registerEvents(new events(),this);
        getLogger().info("Plugin started...");

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
