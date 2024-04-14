package org.hisotau.petsimulator.PetManager;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class PetManager {
    public void spawnPet(PetType type, Location location) {
        World world = location.getWorld();
        world.spawn(location, type.getClazz());

        }
    }

