package net.junnesejer.bukkit.plugins.commands;

import net.junnesejer.bukkit.plugins.util.ListStore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FriendAcceptExecutor extends JavaPlugin implements CommandExecutor {

	private ListStore plugin;
	public FriendAcceptExecutor(ListStore plugin){
		this.plugin = plugin;
	}
	private FriendExecutor parent;
	public FriendAcceptExecutor(FriendExecutor parent){
		this.parent = parent;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("friendaccept")){
			if(sender instanceof Player){
				if(!args[0].isEmpty()){
					if(parent.requestedlist.contains(sender.getName())){
						
					}
				}
				else {
					sender.sendMessage(ChatColor.RED + "You did not specify a player!");
					return true;
				}
			}
			else {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You can't use this command via the console!");
				return true;
			}
		}
		
		
		return false;
	}
}
