package net.junnesejer.bukkit.plugins;

import java.io.File;
import java.util.logging.Logger;

import net.junnesejer.bukkit.plugins.util.FriendAcceptExecutor;
import net.junnesejer.bukkit.plugins.util.FriendDeleteExecutor;
import net.junnesejer.bukkit.plugins.util.FriendDenyExecutor;
import net.junnesejer.bukkit.plugins.util.FriendListExecutor;
import net.junnesejer.bukkit.plugins.util.FriendReqExecutor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

//Please note I use the latest dev build 1.4.6-R0.4!
public class Main extends JavaPlugin{
	
	Logger getLogger = this.getLogger();
	
	@Override
	public void onDisable(){
		
	}
	
	@Override
	public void onEnable(){
		
		//get data folder and check if it exists if not then create it
		String pluginFolder = this.getDataFolder().getAbsolutePath();
		(new File(pluginFolder)).mkdirs();
		
			String x = ListStore.ReturnString(this.getDataFolder().getAbsolutePath());
		    getLogger.info(x);
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
