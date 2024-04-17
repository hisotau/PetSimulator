package org.hisotau.petsimulator.PetManager;

import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;

import java.util.HashMap;
import java.util.Map;

public enum PetType {
    OLIVIA(Cat.class, "Olivia"),
    ROISE(Cat.class, "Roise"),
    PAUK(Pig.class, "Pauk"),
    MILKA(Cat.class, "Ксюня");

    private final Class<? extends Entity> clazz;
    private final String alias;

    private static final Map<String, PetType> VALUES = new HashMap<>();

    static {
        for (PetType petType : values()) {
            VALUES.put(petType.alias, petType);
        }
    }

    public static PetType getByAlias(String alias) {
        return VALUES.get(alias);
    }

    PetType(Class<? extends Entity> clazz, String alias) {
        this.clazz = clazz;
        this.alias = alias;
    }

    public Class<? extends Entity> getClazz() {
        return this.clazz;
    }
}

