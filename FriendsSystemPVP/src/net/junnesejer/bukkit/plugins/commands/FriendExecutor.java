package net.junnesejer.bukkit.plugins.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.junnesejer.bukkit.plugins.util.ListStore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FriendExecutor extends JavaPlugin implements CommandExecutor {
	
	public ListStore requested;
	
	private ListStore plugin;
	public FriendExecutor(ListStore plugin){
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("friend")){
			if(sender instanceof Player){
				/*
				 * Check if user gave a playername
				 */
				if(!args[0].isEmpty()){
					//if user gave a player name we create the request.
					if(args[0] != null){
						String pluginFolder = this.getDataFolder().getAbsolutePath();
						Player target = getServer().getPlayer(args[0]);
						/*
						 * Here we handle the request. It handles itself as follows:
						 * Create a text file for the requester
						 * Add the specified player to the requested list
						 * Send the player a message that a request was sent
						 */
						this.requested = new ListStore(new File(pluginFolder + File.separator + sender.getName() + "_requested.txt"));
						requested.add(target.getName());
						//
						//add player to it's own unique 'requested' list
						//
						this.requested = new ListStore(new File(pluginFolder + File.separator + "completeList.txt"));
						requested.add(value)
						String[] requestedPlayers = new String[] {};
						List<String> requestedPlayersList = Arrays.asList(requestedPlayers );
						requestedPlayersList.add(sender.getName() + target.getName());
						//
						//
						sender.sendMessage(ChatColor.GREEN + "Request was sent to: " + ChatColor.WHITE + target.getDisplayName());
						/*
						 * From here we tell the specified player that they received a request.
						 */
						target.sendMessage("=========================================");
						target.sendMessage(ChatColor.GREEN + "You recieved a new friend request!");
						target.sendMessage("");
						target.sendMessage(sender.getName() + " requested to be your friend.");
						target.sendMessage("To accept this request type: " + ChatColor.GREEN + "/friendaccept");
						target.sendMessage("To deny this request type: " + ChatColor.RED + "/frienddeny");
						target.sendMessage("=========================================");
						}
					}
					else {
						sender.sendMessage(ChatColor.RED + "Specified player did not exist or was not online!");
						return true;
					}
				}
				else {
					sender.sendMessage(ChatColor.RED + "You did not specify a player!");
					return true;
				}
			}
			else {
				/*
				 * tell the user a message if command was sent from the console, this is not possible!
				 */
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You can't use this command via the console!");
				return true;
		}
		return false;
	}
}