package net.junnesejer.bukkit.plugins;

import java.io.File;
import java.util.logging.Logger;

//import all from util package, makes life easier :)
import net.junnesejer.bukkit.plugins.util.*;
//don't try to import all from *bukkit, might cause overload!
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

//Using latest dev build 1.4.6-R0.4!
public class Main extends JavaPlugin{
	
	//get logger but also info from plugin (second line)
	Logger getLogger = this.getLogger();
	PluginDescriptionFile pdFile = this.getDescription();
	
	@Override
	public void onDisable(){
		getLogger.info(ChatColor.YELLOW + "========================");
		getLogger.info(ChatColor.RED + "We're sad to see you go! :(!");
		getLogger.info(ChatColor.YELLOW + pdFile.getName() + ChatColor.WHITE + " has been disabled!");
		getLogger.info(ChatColor.YELLOW + "========================");
	}
	
	@Override
	public void onEnable(){
		
		//get data folder and check if it exists if not then create it
		String pluginFolder = this.getDataFolder().getAbsolutePath();
		(new File(pluginFolder)).mkdirs();
		
		getLogger.info(ChatColor.YELLOW + "========================");
		getLogger.info(ChatColor.RED + "We are happy to see you!");
		getLogger.info(ChatColor.YELLOW + pdFile.getName() + ChatColor.WHITE + " has been enabled!");
		getLogger.info(ChatColor.YELLOW + "========================");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]){
		if(commandLabel.equalsIgnoreCase("friend") || commandLabel.equalsIgnoreCase("friendaccept") || commandLabel.equalsIgnoreCase("frienddeny") || commandLabel.equalsIgnoreCase("friends") || commandLabel.equalsIgnoreCase("frienddel")){
			if(sender instanceof Player){
				if(commandLabel.equalsIgnoreCase("friend")){
					this.getCommand("friend").setExecutor(new FriendReqExecutor(this));
				}
				else if(commandLabel.equalsIgnoreCase("friendaccept")){
					this.getCommand("friendaccept").setExecutor(new FriendAcceptExecutor(this));
				}
				else if(commandLabel.equalsIgnoreCase("frienddeny")){
					this.getCommand("frienddeny").setExecutor(new FriendDenyExecutor(this));
				}
				else if(commandLabel.equalsIgnoreCase("friends")){
					this.getCommand("friends").setExecutor(new FriendListExecutor(this));
				}
				else if(commandLabel.equalsIgnoreCase("frienddel")){
					this.getCommand("frienddel").setExecutor(new FriendDeleteExecutor(this));
				}
			}
			else {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You can't use this command via the console!");
			}
		}
		
		return false;
	}
}
