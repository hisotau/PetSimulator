package org.hisotau.petsimulator.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.hisotau.petsimulator.PetSimulator;
import org.hisotau.petsimulator.player.PlayerManager;

public class Board implements Runnable {
    private final static Board instance = new Board();
    private Board() {

    }
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()){
            if(player.getScoreboard() != null && player.getScoreboard().getObjective(PetSimulator.getInstance().getName()) != null)
                updateScoreboard(player);
            else
                createNewScoreboard(player);
        }
    }

    private void createNewScoreboard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective(PetSimulator.getInstance().getName(),"hello");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§b§lPET SIMULATOR");

        objective.getScore( "ㅤ").setScore(1);
        objective.getScore("§fВаш уровень: ").setScore(2);
        objective.getScore("§fВаш баланс: ").setScore(3);
        objective.getScore("ㅤ").setScore(4);
        objective.getScore("§fКол-во ваших питомцев: ").setScore(5);
        objective.getScore("§fВы можете вызвать:1 ").setScore(6);
        objective.getScore("ㅤ").setScore(7);
        objective.getScore("§7me.hisotau").setScore(6);
        player.setScoreboard(scoreboard);
        setTeam(player);
    }

    private void updateScoreboard(Player player) {
        setTeam(player);
    }

    private void setTeam(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team team1 = scoreboard.getTeam("team1");
        if (team1 == null) {
            team1 = scoreboard.registerNewTeam("team1");
            String teamkey = ChatColor.GOLD.toString();
            team1.addEntry(teamkey);
            team1.setPrefix("У вас на балансе: ");
        }
        PlayerManager playerManager = PetSimulator.getInstance().getPlayerWrapper(player.getName());

        if (playerManager != null) {
            int money = playerManager.getUser().getMoney();
            team1.setSuffix(ChatColor.YELLOW + "" + money + " монет.");
        }
        Objective objective = scoreboard.getObjective(DisplaySlot.SIDEBAR);

        objective.getScore(ChatColor.GOLD.toString()).setScore(0);
    }



    public static Board getInstance(){
        return instance;
    }
}
