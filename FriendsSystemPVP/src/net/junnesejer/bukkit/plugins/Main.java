package net.junnesejer.bukkit.plugins;

import java.io.File;
import java.util.logging.Logger;

import net.junnesejer.bukkit.plugins.commands.FriendExecutor;
import org.bukkit.plugin.java.JavaPlugin;

//Please note I use the latest dev build 1.4.6-R0.4!
public class Main extends JavaPlugin{
	
	public Logger log;
	
	@Override
	public void onDisable(){
		
	}
	
	@Override
	public void onEnable(){
		
		//get data folder and check if it exists if not then create it
		String pluginFolder = this.getDataFolder().getAbsolutePath();
		(new File(pluginFolder)).mkdirs();
		
		
		this.getCommand("friend").setExecutor(new FriendExecutor());
	}
}
