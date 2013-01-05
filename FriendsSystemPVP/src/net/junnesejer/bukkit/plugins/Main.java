package net.junnesejer.bukkit.plugins;

import java.io.File;
import java.util.ArrayList;

import net.junnesejer.bukkit.plugins.commands.AddExecutor;
import net.junnesejer.bukkit.plugins.util.ListStore;

import org.bukkit.plugin.java.JavaPlugin;

//Please note I use the latest dev build 1.4.6-R0.4!
public class Main extends JavaPlugin{
	
	public ArrayList<String> activePlayers = new ArrayList<String>();
	public ArrayList<String> requested = new ArrayList<String>();
	
	public ListStore friendlist;
	
	@Override
	public void onDisable(){
		this.friendlist.save();
	}
	
	@Override
	public void onEnable(){
		
		String pluginFolder = this.getDataFolder().getAbsolutePath();
		
		(new File(pluginFolder)).mkdirs();
		
		this.friendlist = new ListStore(new File(pluginFolder + File.separator + "friend-list.txt"));
		this.friendlist.load();
		
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		this.getCommand("friend").setExecutor(new AddExecutor(this));
	}
}
