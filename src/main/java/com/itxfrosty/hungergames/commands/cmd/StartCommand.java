package com.itxfrosty.hungergames.commands.cmd;

import com.itxfrosty.hungergames.HungerGames;
import com.itxfrosty.hungergames.commands.CommandBase;
import com.itxfrosty.hungergames.utils.SoundUtils;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.WorldBorder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class StartCommand extends CommandBase {

    public StartCommand() {
        super("start",null);
    }

    @Getter private static ArrayList<Player> tributes = new ArrayList();
    private int count = 0;

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

            tributes.addAll(Bukkit.getOnlinePlayers());

            wb.setCenter(23,25);
            wb.setSize(1200);

            if (tributes.size() <= 6) {
                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HungerGames.getInstance(), () -> {
                    count++;

                    SoundUtils.playSoundForAll(player.getLocation(), Sound.ITEM_LODESTONE_COMPASS_LOCK, 1, 800);

                    // TODO: Time it takes for the border to come in is not working.
                    if (count == 1) {
                        wb.setCenter(23,25);
                        wb.setWarningTime(90);
                        wb.setSize(150);
                    }

                    if (count >= 90) {
                        SoundUtils.playSoundForAll(player.getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, 0, 800);
                        Bukkit.getServer().getScheduler().cancelTasks(HungerGames.getInstance());
                    }
                }, 0L, 20L);
            }
        }
    }
}

