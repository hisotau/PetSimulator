package org.hisotau.petsimulator.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.ConfigurationSection;
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
        if (!(commandSender instanceof Player)) {
            System.out.println("Команда вызвана не игроком");
            return false;
        }

        Player player = (Player) commandSender;
        PetManager pets = new PetManager();
        var PetType = PetSimulator.getInstance().getConfig().getConfigurationSection("CUSTOM_PETS." + strings[0].toUpperCase());

        if (PetType != null) {
            handleValidPetType(PetType, player, pets);
        } else {
            handleInvalidPetType(player);
        }

        return true;
    }

    private void handleValidPetType(ConfigurationSection petType, Player player, PetManager pets) {
        String name = petType.getString("Name");
        EntityType entity = EntityType.valueOf(petType.getString("Entity"));
        PetRarity rarity = PetRarity.valueOf(petType.getString("Rarity"));

        String coloredName = rarity.getColor() + name;
        pets.spawnPet(coloredName, entity, player.getLocation());
        player.sendMessage("§9§lPetSimulator // §RВы успешно призвали: " + coloredName);
    }

    private void handleInvalidPetType(Player player) {
        player.sendMessage("§9§lPetSimulator // §cТакого питомца не существует");
    }


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            return Arrays.asList("Olivia", "Rosie", "SvinPauk", "Ксюня");
        }
        return null;
    }
}
