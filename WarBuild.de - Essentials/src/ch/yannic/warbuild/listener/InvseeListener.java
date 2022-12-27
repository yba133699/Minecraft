package ch.yannic.warbuild.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import ch.yannic.warbuild.command.InvseeCommand;

public class InvseeListener implements Listener {

	@EventHandler	
	public void onInventoryMove(InventoryClickEvent event) {
		if(!InvseeCommand.getInvsee().contains(event.getWhoClicked())) {
			event.setCancelled(false);
			return;
		}
		event.setCancelled(true);
	}
}
