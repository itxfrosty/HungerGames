package com.itxfrosty.hungergames.events;

import com.itxfrosty.hungergames.commands.cmd.StartCommand;
import com.itxfrosty.hungergames.utils.SoundUtils;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        Location location = player.getLocation();

        SoundUtils.playSoundForAll(location, Sound.ENTITY_WITHER_SPAWN,1,800);

        if (StartCommand.getTributes().contains(player)) {
            StartCommand.getTributes().remove(player);
        }

        player.setGameMode(GameMode.SPECTATOR);

    }

}