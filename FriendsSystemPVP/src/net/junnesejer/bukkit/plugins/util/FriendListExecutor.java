package net.junnesejer.bukkit.plugins.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.junnesejer.bukkit.plugins.Main;

public class FriendListExecutor implements CommandExecutor{

	private Main plugin;
	public FriendListExecutor(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		return false;
	}
}