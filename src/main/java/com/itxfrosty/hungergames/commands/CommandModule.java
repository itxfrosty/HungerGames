package com.itxfrosty.hungergames.commands;

import com.itxfrosty.hungergames.HungerGames;
import com.itxfrosty.hungergames.commands.cmd.StartCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;

public class CommandModule {
	
	private static CommandMap commandMap;

	public static void registerCommands() {
		CommandModule.registerCommand(new StartCommand());
	}

	public static void registerCommand(CommandBase command) {
		getCommandMap().register(HungerGames.getInstance().getName(), command);
	}
	
	private static CommandMap getCommandMap() {
		if(commandMap == null) {
		 
			try {
				if (Bukkit.getPluginManager() instanceof SimplePluginManager) {
					Field f = SimplePluginManager.class.getDeclaredField("commandMap");
					f.setAccessible(true);
		 
					commandMap = (CommandMap) f.get(Bukkit.getPluginManager());
				}
			} catch (Exception e) {
				e.printStackTrace();
				commandMap = null;
			}
		}
		return commandMap;
	}
}
