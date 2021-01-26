package com.itxfrosty.hungergames.commands.cmd;

import com.itxfrosty.hungergames.commands.CommandBase;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand extends CommandBase {

    public JoinCommand() {
        super("join", null);
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            StartCommand.tributes.add(player.getUniqueId());
            player.sendMessage(ChatColor.GREEN + "You have joined the game. To start the game do /start!");
        }
    }
}
