package org.hisotau.petsimulator.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.hisotau.petsimulator.PetManager.PetManager;
import org.hisotau.petsimulator.PetManager.PetRarity;
import org.hisotau.petsimulator.PetSimulator;
import org.jetbrains.annotations.NotNull;



public class summonPetCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {


        if(!(commandSender instanceof Player)) {
            System.out.println("Команда вызвана не игроком");
            return false;
        }
        Player player = (Player) commandSender;
        PetManager spawnPet = new PetManager();
        var r = PetSimulator.getInstance().getConfig().getConfigurationSection("CUSTOM_PETS." + strings[0].toUpperCase() + ".");
        String name = r.getString("Name");
        EntityType type = EntityType.valueOf(r.getString("Entity"));
        PetRarity rarity = PetRarity.valueOf(r.getString("Rarity"));
        if (name != null)
        {
            String coloredName = rarity.getColor() + name;
            spawnPet.spawnPet(coloredName,type,player.getLocation());
            player.sendMessage("§a§lHSTUDEV //" + "§R Вы успешно призвали: " + coloredName);
        }
        else
        {
            System.out.println("§a§lHSTUDEV //" + "§c Питомца " + strings[0] + " нет.");
            return false;
        }
            return true;
        }
        }
//        PetType petType = PetType.getByAlias(strings[0]);
//        if (petType != null) {
//            String coloredAlias = petType.getRarity().color + strings[0];
//            pets.spawnPet(petType,coloredAlias,player.getLocation());
//            player.sendMessage("§a§lHSTUDEV //" + "§R Вы успешно призвали: " + coloredAlias);
//        }
//        else {
//            System.out.println("False");
//            return false;
//        }
//
//        return true;



