package net.junnesejer.bukkit.plugins.util;

import java.io.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.junnesejer.bukkit.plugins.Main;

public class FriendReqExecutor implements CommandExecutor{

	private Main plugin;
	public FriendReqExecutor(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args[0] != null){
			
			//make some strings etc.
			File file = new File(sender.getName() + "_requested.txt");
			Player target = sender.getServer().getPlayer(args[0]);
			
			//if file did not exist then simply create it
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {e.printStackTrace();}
			}
			//check if the target specified was already in the list..
			BufferedReader reader = new BufferedReader(new
			InputStreamReader(this.getClass().getResourceAsStream(sender.getName() + "_requested.txt")));
			FileWriter fw = null;
			try {
				fw = new FileWriter(sender.getName() + "_requested.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        BufferedWriter bw = new BufferedWriter(fw);
			String line = "";

			try {
				while ((line = reader.readLine()) != null) {
				     if(line.equals(target.getName())) {
				         //user was found so there was already a request!
				    	 sender.sendMessage(ChatColor.GRAY + "You already sent a request to that player!");
				    	 return true;
					 }
				     else {
				    	 //user was not found so make the request!
				    	 bw.append(target.getName());
				    	 bw.newLine();
				    	 plugin.getLogger().info(sender.getName() + " requested " + target.getName() + " to be friends.");
				    	 //user was added, sent notifications now
				    	 sender.sendMessage(ChatColor.GREEN + "Request was successfully sent!");
				    	 target.sendMessage(ChatColor.YELLOW + "=============================");
				    	 target.sendMessage(ChatColor.GREEN + "You received a friend request!");
				    	 target.sendMessage(ChatColor.RED + sender.getName() + ChatColor.WHITE + " wishes to be your friend.");
				    	 target.sendMessage("");
				    	 target.sendMessage("To accept this request type: " + ChatColor.GREEN + "/friendaccept");
				    	 target.sendMessage("To deny this request type: " + ChatColor.RED + "/frienddeny");
				    	 target.sendMessage(ChatColor.YELLOW + "=============================");
				    	 return true;
				     }
			    }
		    } catch (IOException e) {e.printStackTrace(); return false;
			} finally {
				//now try to close the reader, else give an IOException
		    	try {
					reader.close();
					bw.close();
					fw.close();
				} catch (IOException e) {e.printStackTrace();}
		      }
		}
		else {
			//user did not give a username.
			sender.sendMessage(ChatColor.RED + "Too few arguments.");
		}
		
		return false;
	}
}
