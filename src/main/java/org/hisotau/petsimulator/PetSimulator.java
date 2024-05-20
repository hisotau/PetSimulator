package org.hisotau.petsimulator;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.hisotau.petsimulator.MYSQL.ConfigMySQL;
import org.hisotau.petsimulator.MYSQL.MysqlStorage;
import org.hisotau.petsimulator.commands.*;
import org.hisotau.petsimulator.eventsListener.PlayerJoinQuit;
import org.hisotau.petsimulator.loader.ListenerLoader;
import org.hisotau.petsimulator.loader.commandLoader;
import org.hisotau.petsimulator.player.PlayerManager;
import org.hisotau.petsimulator.scoreboard.Board;

import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Bukkit.getServer;


public final class PetSimulator extends JavaPlugin {

    private final Map<String, PlayerManager> playerCache = new HashMap<>();
    private BukkitTask task;
    private BukkitTask task1;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        ConfigMySQL.load(getConfig());
        getLogger().info("Plugin started...");
        getServer().getPluginCommand("calculator").setExecutor(new CalculatorCMD());
        getServer().getPluginCommand("gms").setExecutor(new gmsCMD());
        getServer().getPluginCommand("gmc").setExecutor(new gmcCMD());
        getServer().getPluginCommand("pet").setExecutor(new summonPetCMD());
        getServer().getPluginCommand("visemoney").setExecutor(new getDBUser(PetSimulator.getInstance()));
        getServer().getPluginCommand("money").setExecutor(new addMoney());
        MysqlStorage storage = new MysqlStorage();
        getServer().getPluginManager().registerEvents(new PlayerJoinQuit(PetSimulator.getInstance(), storage), PetSimulator.getInstance());
        task = getServer().getScheduler().runTaskTimer(this, Board.getInstance(),0,20);
      //  task1 = getServer().getScheduler().runTaskTimer(this, RandomPredmet.getInstance(),0,160);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin stopped...");
        MysqlStorage storage = new MysqlStorage();

        for (PlayerManager playerManager : playerCache.values()) {
            storage.addUser(playerManager.getPlayerName(), playerManager.getUser().getMoney());
        }

        getServer().getPluginManager().registerEvents(new PlayerJoinQuit(this, storage), this);
        //Plugin shutdown logic
      assert task != null;
      if (!task.isCancelled())
      {
           task.cancel();
        }
    }


    public PlayerManager getPlayerWrapper(String playerName) {
        return playerCache.get(playerName);
    }

    public void addPlayerWrapper(String playerName, PlayerManager playerWrapper) {
        playerCache.put(playerName, playerWrapper);
    }

    public void removePlayerWrapper(String playerName) {
        playerCache.remove(playerName);
    }

    public static PetSimulator getInstance(){
        return getPlugin(PetSimulator.class);
    }
}


