package com.itxfrosty.hungergames.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class SoundUtils {

	public static void playSoundForAll(Location location, Sound sound, float pitch, int radius) {
		for(Player pp : Bukkit.getOnlinePlayers()) {
			if(pp.getLocation().distance(location) <= radius) {
				pp.playSound(pp.getLocation(), sound, Integer.MAX_VALUE, pitch);
			}
		}
	}

	public static void playSoundForAll(Location location, String sound, SoundCategory soundCategory, float volume, float pitch, int radius) {
		for(Player pp : Bukkit.getOnlinePlayers()) {
			if(pp.getLocation().distance(location) <= radius) {
				pp.playSound(pp.getLocation(), sound, soundCategory, volume, pitch);
			}
		}
	}

	public static void playSound(Player player, Sound sound, float pitch) {
		player.playSound(player.getLocation(), sound, Integer.MAX_VALUE, pitch);
	}

	public static void playSound(Player player, String sound, SoundCategory soundCategory, float volume, float pitch) {
		player.playSound(player.getLocation(), sound, soundCategory, volume, pitch);
	}

	public static void playSound(Location location, String sound, SoundCategory soundCategory, float volume, float pitch, int radius) {
		for(Player pp : Bukkit.getOnlinePlayers()) {

			if(!pp.getWorld().equals(location.getWorld())) continue;

			if(pp.getLocation().distance(location) <= radius) {
				pp.playSound(location, sound, soundCategory, volume, pitch);
			}
		}
	}
}