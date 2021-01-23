package com.itxfrosty.hungergames;

import com.itxfrosty.hungergames.commands.CommandModule;
import com.itxfrosty.hungergames.events.AntiGrief;
import com.itxfrosty.hungergames.events.DeathEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerGames extends JavaPlugin {

    @Getter private static HungerGames instance;

    @Override
    public void onEnable() {
        instance = this;

        CommandModule.registerCommands();

        registerEvents();

        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        Location center = new Location(Bukkit.getWorld("world"), 23, 91, 25);

        wb.setCenter(center);
        wb.setSize(1200);

        this.getLogger().info(getName() + "is now enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(getName() + "is now disabled!");
    }

    public void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new AntiGrief(),this);
        pm.registerEvents(new DeathEvent(),this);
    }

}
