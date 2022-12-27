package ch.yannic.warbuild.command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.yannic.warbuild.main.Main;

public class TeleportAllCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du kannst keinen zu dir teleportieren!");
			return true;
		}
		Player player = (Player) sender;
		if(!player.hasPermission("warbuild.teleport.all")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length != 0) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				for (Player all : Bukkit.getOnlinePlayers()){
					all.teleport(target);
					all.sendMessage(Main.getInstance().prefix() + " §7Es wurden alle zu " + target.getName() + " teleportiert!");
					target.sendMessage(Main.getInstance().prefix() + " §7Es wurden alle zu dir teleportiert!");
					target.playSound(target.getLocation(), Sound.ENDERMAN_TELEPORT, 4, 4);
					return true;
				}
				return true;
			}
			player.sendMessage(Main.getInstance().prefix() + " §7Der Spieler " + args[1] + " ist nicht online!");
			return true;
		}
		if(args.length != 1) {
			for (Player all : Bukkit.getOnlinePlayers()){
				all.teleport(player);
				all.sendMessage(Main.getInstance().prefix() + " §7Es wurden alle zu " + player.getName() + " teleportiert!");
				player.sendMessage(Main.getInstance().prefix() + " §7Es wurden alle zu dir teleportiert!");
				player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 4, 4);
				return true;
			}
			return true;
		}
		player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /tpall (SPIELER)");
		return false;
	}

}
