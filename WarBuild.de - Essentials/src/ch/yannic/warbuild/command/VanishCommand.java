package ch.yannic.warbuild.command;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.yannic.warbuild.main.Main;

public class VanishCommand implements CommandExecutor {
	
	private final static ArrayList<Player> vanish = new ArrayList<Player>();
	
	public static ArrayList<Player> getVanish() {
		return new ArrayList<Player>(vanish);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			if(args.length != 1) {
				sender.sendMessage("Bitte benutze /vanish (SPIELER)!");
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(!vanish.contains(target)) {
					vanish.add(target);
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(target);
						return true;
					}
					return true;
				}
				vanish.remove(target);
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(target);
					return true;
				}	
				return true;
			}
			sender.sendMessage("Der Spieler " + args[0] + " ist nicht Online!");
			return true;
		}			
		Player player = (Player) sender;
		if(!player.hasPermission("warbuild.vanish") && !player.hasPermission("warbuild.vanish.other")) {
			if(args.length == 0 || args.length == 1) {
				player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
				return true;
			}
			player.sendMessage(Main.getInstance().prefix() + "§7Bitte benutze /vanish (SPIELER)");
			return true;
		}
		if(player.hasPermission("warbuild.vanish") && !player.hasPermission("warbuild.vanish.other")) {
			if(args.length == 0) {
				if(!vanish.contains(player)) {
					player.sendMessage(Main.getInstance().prefix() + " §7Du bist nun Unsichtbar!");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
					vanish.add(player);
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(player);
						return true;
					}
					return true;
				}
				vanish.remove(player);
				player.sendMessage(Main.getInstance().prefix() + " §7Du bist nun Sichtbar!");
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(player);
				}
				if(args.length == 1) {
					player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
					return true;
				}
				return true;
			}
			if(!player.hasPermission("warbuild.vanish") && player.hasPermission("warbuild.vanish.other")) {
				if(args.length == 0) {
					player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
					return true;
				}
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						vanish.add(target);
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.hidePlayer(target);
							return true;
						}
						return true;	
					}
					sender.sendMessage(Main.getInstance().prefix() + " §7Der Spieler " + args[0] + " ist nicht Online!");
					return true;
				} 
				return true;
			}
			if(player.hasPermission("warbuild.vanish") && player.hasPermission("warbuild.vanish.other")) {
				if(args.length == 0) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(player);
						player.sendMessage(Main.getInstance().prefix() + " §7Du bist nun Unsichtbar!");
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
						vanish.add(player);
						return true;
					}
					return true;
				}
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						vanish.add(target);
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.hidePlayer(target);
							return true;
						}
						return true;	
					}
					sender.sendMessage(Main.getInstance().prefix() + " §7Der Spieler " + args[0] + " ist nicht Online!");
					return true;
				}
				return true;
			}	
			return true;
		}
		return false;
	}
}