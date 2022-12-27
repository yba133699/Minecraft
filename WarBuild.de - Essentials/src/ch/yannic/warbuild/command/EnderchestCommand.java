package ch.yannic.warbuild.command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.yannic.warbuild.main.Main;

public class EnderchestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du kannst keine Enderchest öffnen!");
			return true;
		}
		Player player = (Player) sender;
		if(!player.hasPermission("warbuild.enderchest") && !player.hasPermission("warbuild.enderchest.other")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(player.hasPermission("warbuild.enderchest") && !player.hasPermission("warbuild.enderchest.other")) {
			if(args.length != 1) {
				player.openInventory(player.getEnderChest());
				return true;
			}
			if(args.length > 1) {
				player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /ec (SPIELER)");
				player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
				return true;
			}
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(!player.hasPermission("warbuild.enderchest") && player.hasPermission("warbuild.enderchest.other")) {
			if(args.length != 0) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					player.openInventory(target.getEnderChest());
					return true;
				}
				player.sendMessage(Main.getInstance().prefix() + " §7Der Spieler " + args[0] + " ist nicht online!");
				return true;
			}if(args.length != 1) {
				player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
				return true;
			}
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /ec (SPIELER)");
			player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			return true;
		}
		if(player.hasPermission("warbuild.enderchest") && player.hasPermission("warbuild.enderchest.other")) {	
			if(args.length == 0) {
				player.openInventory(player.getEnderChest());
				return true;
			}
			if(args.length > 1) {
				player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /ec (SPIELER)");
				player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
				return true;
			}
			if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				player.openInventory(target.getEnderChest());
				return true;
			}
			
		}
		return false;
	}
	
}
