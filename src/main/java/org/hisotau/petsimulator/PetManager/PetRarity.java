package org.hisotau.petsimulator.PetManager;

public enum PetRarity {
    COMMON("§7"),
    UNCOMMON("§b"),
    RARE("§a"),
    EPIC("§d"),
    LEGENDARY("§6");


    public final String color;

    public String getColor() {
        return color;
    }

    PetRarity(String color) {
        this.color = color;
    }
}
