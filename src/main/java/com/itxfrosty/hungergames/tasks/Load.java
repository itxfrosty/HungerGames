package com.itxfrosty.hungergames.tasks;

import com.itxfrosty.hungergames.commands.CommandModule;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;

public class Load {

    public static void startup() {
        CommandModule.registerCommands();
        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        Location center = new Location(Bukkit.getWorld("world"), 23, 91, 25);
        wb.setCenter(center);
        wb.setSize(1200);
    }
}
