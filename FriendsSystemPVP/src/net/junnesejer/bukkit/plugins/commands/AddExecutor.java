package net.junnesejer.bukkit.plugins.commands;

import net.junnesejer.bukkit.plugins.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddExecutor implements CommandExecutor{

	private Main plugin;
	public AddExecutor(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(args.length != 1){
			sender.sendMessage(ChatColor.RED + "Usage is: /friend <playername>");
			return true;
		}
		
		Player friend = plugin.getServer().getPlayer(args[0]);
		
		plugin.friendlist.add(args[0]);
		
		sender.sendMessage(ChatColor.GREEN + "Request sent to " + friend.getDisplayName());
		
		return true;
	}

	
}
