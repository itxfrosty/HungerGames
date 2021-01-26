package com.itxfrosty.hungergames.commands.cmd;

import com.itxfrosty.hungergames.commands.CommandBase;
import com.itxfrosty.hungergames.lang.TPLocations;
import com.itxfrosty.hungergames.tasks.Timer;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class StartCommand extends CommandBase {

    public StartCommand() {
        super("start",null);
    }

    @Getter public static ArrayList<UUID> tributes = new ArrayList();

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
            Random rand = new Random();

            TPLocations.locationRegister();

            tributes.forEach(UUID -> Bukkit.getPlayer(UUID).teleport(TPLocations.loc.get(rand.nextInt(TPLocations.loc.size()))));
            System.out.println(player.getWalkSpeed());
            player.setWalkSpeed(1);

            tributes.forEach(UUID -> Bukkit.getPlayer(UUID).setWalkSpeed(0));


            Timer.StartTimer(player);

            if (tributes.size() <= 6) {
               //Timer.SixPlayerLeft(wb);
            }
        }
    }
}
// Extra Code..... May be used LOL
    /*

Player player = (Player) sender;
            WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
            Location center = new Location(Bukkit.getWorld("world"), 23, 91, 25);
            // ADDED /join
            //tributes.addAll(Bukkit.getOnlinePlayers());

            wb.setCenter(23,25);
            wb.setSize(1200);

            if (tributes.size() <= 6) {
                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HungerGames.getInstance(), () -> {
                    count++;

                    SoundUtils.playSoundForAll(center, Sound.ITEM_LODESTONE_COMPASS_LOCK, 1, 800);

                    if (count == 1) {
                        wb.setCenter(23,25);
                        wb.setWarningDistance(5);
                        wb.setSize(150, 90);
                    }

                    if (count >= 90) {
                        SoundUtils.playSoundForAll(center, Sound.BLOCK_BEACON_POWER_SELECT, 0, 800);
                        count = 0;
                        Bukkit.getServer().getScheduler().cancelTasks(HungerGames.getInstance());
                    }
                }, 0L, 20L);
            }

 */