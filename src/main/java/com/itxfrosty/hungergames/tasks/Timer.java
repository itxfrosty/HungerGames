package com.itxfrosty.hungergames.tasks;

import com.itxfrosty.hungergames.HungerGames;
import com.itxfrosty.hungergames.utils.MessageUtil;
import com.itxfrosty.hungergames.utils.SoundUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;

public class Timer {

    private static int count = 0;
    private static int start = 0;

    public static void timer5(Player player) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(HungerGames.getInstance(), () -> {
            start++;
            if (start == 1) {
                MessageUtil.sendTitle(player,ChatColor.GREEN + "5", ChatColor.GREEN + "till start!", 15, 2, 2);
            }
            if (start == 2) {
                MessageUtil.sendTitle(player,ChatColor.GREEN + "4", ChatColor.GREEN + "till start!", 15, 2, 2);
            }
            if (start == 3) {
                MessageUtil.sendTitle(player,ChatColor.GREEN + "3", ChatColor.GREEN + "till start!", 15, 2, 2);
            }
            if (start == 4) {
                MessageUtil.sendTitle(player,ChatColor.GREEN + "2", ChatColor.GREEN + "till start!", 15, 2, 2);
            }
            if (start == 5) {
                MessageUtil.sendTitle(player,ChatColor.GREEN + "1", ChatColor.GREEN + "till start!", 15, 2, 2);
            }
            if (start == 6) {
                // TODO: Cancel the specific Task.
                Bukkit.getScheduler().cancelTasks(HungerGames.getInstance());
            }
        },0L,20L);
    }

    public static void sixPlayerEvent(WorldBorder wb) {
        Location location = new Location(Bukkit.getWorld("world"),23,65,25);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HungerGames.getInstance(), () -> {
            count++;

            SoundUtils.playSoundForAll(location, Sound.ITEM_LODESTONE_COMPASS_LOCK, 1, 800);

            if (count == 1) {
                wb.setCenter(23,25);
                wb.setWarningDistance(5);
                wb.setSize(150, 90);
            }

            if (count >= 90) {
                SoundUtils.playSoundForAll(location, Sound.BLOCK_BEACON_POWER_SELECT, 0, 800);

                // TODO: Cancel the specific Task.
                Bukkit.getServer().getScheduler().cancelTasks(HungerGames.getInstance());
            }
        }, 0L, 20L);
    }
}
