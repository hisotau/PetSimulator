package org.hisotau.petsimulator.PetManager;

import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;

import java.util.HashMap;
import java.util.Map;


public enum PetType {
    OLIVIA(Cat.class,PetRarity.COMMON ,"Olivia"),
    ROISE(Cat.class,PetRarity.UNCOMMON ,"Roise"),
    PAUK(Pig.class,PetRarity.COMMON ,"Pauk"),
    MILKA(Cat.class,PetRarity.LEGENDARY ,"Ксюня"),;

    private final Class<? extends Entity> clazz;
    private final String alias;
    private final PetRarity rarity;


    private static final Map<String, PetType> VALUES = new HashMap<>();

    static {
        for (PetType petType : values()) {
            VALUES.put(petType.alias, petType);
        }
    }

    public static PetType getByAlias(String alias) {
        return VALUES.get(alias);
    }

    public PetRarity getRarity() {
        return rarity;
    }

    PetType(Class<? extends Entity> clazz, PetRarity rarity, String alias) {
        this.clazz = clazz;
        this.alias = alias;
        this.rarity = rarity;

    }


    public Class<? extends Entity> getClazz() {
        return this.clazz;
    }


}

