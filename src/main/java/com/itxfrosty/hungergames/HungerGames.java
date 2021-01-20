package com.itxfrosty.hungergames;

import com.itxfrosty.hungergames.events.AntiGrief;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin {

    @Getter private HungerGames instance;

    @Override
    public void onEnable() {
        instance = this;

        registerEvents();
        this.getLogger().info(getName() + "is now enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(getName() + "is now disabled!");
    }

    public void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new AntiGrief(), this);
    }

}
