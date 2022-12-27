package ch.yannic.warbuild.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import ch.yannic.warbuild.command.InvseeCommand;
import ch.yannic.warbuild.main.Main;

public class MinewarsListener implements Listener {
	
	@EventHandler
	public void onKill(EntityDeathEvent event) {
		Player target = (Player) event;
		Player killer = event.getEntity().getKiller();
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.sendMessage(Main.getInstance().prefix() + " §6" + target.getName() + " §7wurde von §6" + killer.getName() + " §7getötet!");
		}
		
	}
	

}
