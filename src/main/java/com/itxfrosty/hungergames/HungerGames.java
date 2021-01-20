package com.itxfrosty.hungergames;

import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info(getName() + "is now enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(getName() + "is now disabled!");
    }
}
