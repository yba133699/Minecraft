package ch.yannic.warbuild.command;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import ch.yannic.warbuild.main.Main;

public class InvseeCommand implements CommandExecutor, Listener {

	private final static ArrayList<Player> invsee = new ArrayList<Player>();
		
		public static ArrayList<Player> getInvsee() {
			return new ArrayList<Player>(invsee);
		}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du kannst kein Inventar öffnen!");
			return true;
		}
		Player player = (Player) sender;
		if(!player.hasPermission("warbuild.invsee")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(!player.hasPermission("warbuild.invsee.bypass")) {
				if(player.getInventory() == target.getInventory()) {
					invsee.add(player);
					player.openInventory(target.getInventory());
					return true;
				}
				return true;
			}
			player.openInventory(target.getInventory());
			return true;
		}
		if(args.length > 1) {
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /invsee (SPIELER)");
			player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			return true;
		}
		if(args.length == 0) {
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /invsee (SPIELER)");
			player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			return true;
		}
	return false;
	
	}
}
	

