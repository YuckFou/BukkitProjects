package net.junnesejer.bukkit.plugins;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

//Please note I use the latest dev build 1.4.6-R0.4!
public class Main extends JavaPlugin{
	
	public ArrayList<String> activePlayers = new ArrayList<String>();
	public ArrayList<String> requested = new ArrayList<String>();
	
	@Override
	public void onDisable(){
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
	}
	
	@Override
	public void onEnable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("friend") || commandLabel.equalsIgnoreCase("friendaccept") || 
				commandLabel.equalsIgnoreCase("friends") || commandLabel.equalsIgnoreCase("frienddel")){
			/*
			 * First check what command the user casts so we don't have to check if twice
			 */
			if(sender instanceof Player){
				if(commandLabel.equalsIgnoreCase("friend")){
					if(args[0].length() != 0){
						//get the specified player's name..
						Player player = (Player) sender;
						String sendername = player.getName();
						String playername = getServer().getPlayer(args[0]).getName();
						//check if request was already sent before
						if(this.activePlayers.contains(sendername)){
							player.sendMessage(ChatColor.GRAY + "You had already sent a request.");
							return true;
						}
						else {
							//now if never a request was sent we make a request
							//first add them to their lists
							this.activePlayers.add(sendername);
							this.requested.add(playername);
						}
					}
				}
			}
			else {
				//tell the user that you can't use these commands via the console
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "These commands can only be used in game!");
			}
		}
		//always standard return false :)
		return false;
	}
}
