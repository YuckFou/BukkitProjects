package net.junnesejer.bukkit.plugins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class examplemain extends JavaPlugin{
	
	@Override
	public void onDisable(){
		this.getLogger().info("ExamplePlugin has been disabled!");
	}
	
	@Override
	public void onEnable(){
		this.getLogger().info("ExamplePlugin has been enabled!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		if (sender instanceof Player) {
			if(command.equalsIgnoreCase("xp")){
				if(args.length == 2){
					Player player = (Player) sender;
					Player target = player.getServer().getPlayer(args[0]);
					//check if user exists/is online
					if(target != null){
						try {
							//give xp amount, goes if only NUMERICAL values were given
							int exp = Integer.parseInt(args[1]);
							target.giveExp(exp);
						}
						catch(NumberFormatException nfe){
							//if not only numerical values were given we take all non-numerical values out
							String check = args[1].replaceAll("[^\\d]", "");
							int exp = Integer.parseInt(check);
							target.giveExp(exp);
						}
						return true;
					}
					//if target player was offline or did not exist
					else {
						player.sendMessage(ChatColor.RED + "Could not find " + ChatColor.WHITE + args[0] + ChatColor.RED + " or was offline.");
					}
				}
				else if(args.length == 1){
					Player player = (Player) sender;
					//player did not give an exp amount
					player.sendMessage(ChatColor.RED + "You did not give an amount!");
				}
				else if(args.length == 0){
					Player player = (Player) sender;
					//player only gave command
					player.sendMessage(ChatColor.RED + "Too few arguments!");
				}
			}
		} else {
			if(command.equalsIgnoreCase("xp")){
				if(args.length == 2){
					Player target = this.getServer().getPlayer(args[0]);
					//check if user exists/is online
					if(target != null){
						try {
							//give xp amount, goes if only NUMERICAL values were given
							int exp = Integer.parseInt(args[1]);
							target.giveExp(exp);
						}
						catch(NumberFormatException nfe){
							//if not only numerical values were given we take all non-numerical values out
							String check = args[1].replaceAll("[^\\d]", "");
							int exp = Integer.parseInt(check);
							target.giveExp(exp);
						}
						return true;
					}
					//if target player was offline or did not exist
					else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Could not find " + ChatColor.WHITE + args[0] + ChatColor.RED + " or was offline.");
					}
				}
				else if(args.length == 1){
					//player did not give an exp amount
					Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You did not give an amount!");
				}
				else if(args.length == 0){
					//player only gave command
					Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Too few arguments!");
				}
			}
		}
	    return false;
	}
}
