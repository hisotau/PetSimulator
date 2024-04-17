package org.hisotau.petsimulator.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.hisotau.petsimulator.PetManager.PetRarity;
import org.hisotau.petsimulator.PetSimulator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.hisotau.petsimulator.PetManager.PetManager;

import java.util.Arrays;
import java.util.List;



public class summonPetCMD implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(!(commandSender instanceof Player)) {
            System.out.println("Команда вызвана не игроком");
            return false;
        }

        Player player = (Player) commandSender;
        PetManager pets = new PetManager();
        var PetType = PetSimulator.getInstance().getConfig().getConfigurationSection("CUSTOM_PETS." + strings[0]+ ".");
        String name = PetType.getString("Name");
        EntityType entity = EntityType.valueOf("Entity");
        PetRarity rarity = PetRarity.valueOf("Rarity");
        if (name != null) {
            String coloredName = rarity + name;
            pets.spawnPet(coloredName,entity,player.getLocation());
            player.sendMessage("§9§lPetSimulator // §RВы успешно призвали: " + coloredName);
        }
        else {
            System.out.println("Такого типа питомца не существует");
            return false;
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            return Arrays.asList("Olivia", "Rosie", "SvinPauk", "Ксюня");
        }
        return null;
    }
}
