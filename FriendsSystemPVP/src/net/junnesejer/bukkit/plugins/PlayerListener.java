package net.junnesejer.bukkit.plugins;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
//
	
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getAction() == Action.PHYSICAL){
			
		}
	}
}
