package org.hisotau.petsimulator.PetManager;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class PetManager {
    public static void spawnPet(String name, EntityType entity, Location location) {
        World world = location.getWorld();
        Entity pet = world.spawn(location, entity.getEntityClass());
        pet.setCustomNameVisible(true);
        pet.setCustomName(name);
    }
    }

