package org.hisotau.petsimulator;

import org.bukkit.command.CommandExecutor;
import org.hisotau.petsimulator.commands.*;

public enum enumCommands {
    CALCULATOR("calc", new CalculatorCMD()),
    GMC("gmc", new gmcCMD()),
    GMS("gms", new gmsCMD()),
    SHOP("shop", new shopCMD()),
    SUMMON_PET("pet", new summonPetCMD());

    private final String name;
    private final CommandExecutor executor;

    enumCommands(String name, CommandExecutor executor) {
        this.name = name;
        this.executor = executor;
    }

    public String getName() {
        return this.name;
    }

    public CommandExecutor getExecutor() {
        return this.executor;
    }
}
