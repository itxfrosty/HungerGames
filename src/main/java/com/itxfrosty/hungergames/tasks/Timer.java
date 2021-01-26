package com.itxfrosty.hungergames.tasks;

import com.itxfrosty.hungergames.HungerGames;
import com.itxfrosty.hungergames.utils.MessageUtil;
import com.itxfrosty.hungergames.utils.SoundUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Timer implements Listener {

    // Timers
    private static int count = 0;
    private static int start = 0;

    // TASKS
    private static int StartTimer = 1;
    private static int SixPlayerLeft = 2;

    // Location
    private static final Location location = new Location(Bukkit.getWorld("world"),23,65,25);

    public static void StartTimer(Player player) {
        StartTimer = Bukkit.getScheduler().scheduleSyncRepeatingTask(HungerGames.getInstance(), () -> {
            if (start == 0) {
                player.setWalkSpeed(0);
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 100000));
            }
            start++;
            if (start == 1) {
                MessageUtil.sendTitle(player,ChatColor.RED + "5", ChatColor.RED + "", 15, 2, 2);
                SoundUtils.playSoundForAll(location, Sound.BLOCK_NOTE_BLOCK_HAT, 1, 800);
                player.sendMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.RED + "5" + ChatColor.YELLOW + " seconds!" );
            }
            if (start == 2) {
                MessageUtil.sendTitle(player,ChatColor.RED + "4", ChatColor.YELLOW + "", 15, 2, 2);
                SoundUtils.playSoundForAll(location, Sound.BLOCK_NOTE_BLOCK_HAT, 1, 800);
                player.sendMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.RED + "4" + ChatColor.YELLOW + " seconds!" );
            }
            if (start == 3) {
                MessageUtil.sendTitle(player,ChatColor.YELLOW + "3", ChatColor.YELLOW + "", 15, 2, 2);
                SoundUtils.playSoundForAll(location, Sound.BLOCK_NOTE_BLOCK_HAT, 1, 800);
                player.sendMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.RED + "3" + ChatColor.YELLOW + " seconds!" );
            }
            if (start == 4) {
                MessageUtil.sendTitle(player,ChatColor.YELLOW + "2", ChatColor.GREEN + "", 15, 2, 2);
                SoundUtils.playSoundForAll(location, Sound.BLOCK_NOTE_BLOCK_HAT, 1, 800);
                player.sendMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.RED + "2" + ChatColor.YELLOW + " seconds!" );
            }
            if (start == 5) {
                MessageUtil.sendTitle(player,ChatColor.GREEN + "1", ChatColor.GREEN + "", 15, 2, 2);
                SoundUtils.playSoundForAll(location, Sound.BLOCK_NOTE_BLOCK_HAT, 1, 800);
                player.sendMessage(ChatColor.YELLOW + "The game starts in " + ChatColor.RED + "1" + ChatColor.YELLOW + " seconds!" );
            }
            if (start == 6) {
                player.removePotionEffect(PotionEffectType.JUMP);
                player.setWalkSpeed((float) 0.2);
                Bukkit.getScheduler().cancelTask(StartTimer);
            }
        },0L,20L);
    }

    public static void SixPlayerLeft(WorldBorder wb) {
        SixPlayerLeft = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HungerGames.getInstance(), () -> {
            count++;

            SoundUtils.playSoundForAll(location, Sound.ITEM_LODESTONE_COMPASS_LOCK, 1, 800);

            if (count == 1) {
                wb.setCenter(23,25);
                wb.setWarningDistance(5);
                wb.setSize(150, 90);
            }

            if (count >= 90) {
                SoundUtils.playSoundForAll(location, Sound.BLOCK_BEACON_POWER_SELECT, 0, 800);

                Bukkit.getServer().getScheduler().cancelTask(SixPlayerLeft);
            }
        }, 0L, 20L);
    }
}
