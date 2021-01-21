package com.itxfrosty.hungergames.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class AntiGrief implements Listener {

    @EventHandler
    public void onBreakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if (player.getGameMode().equals(GameMode.SURVIVAL)) {
            e.setCancelled(true);
        }
    }
}
