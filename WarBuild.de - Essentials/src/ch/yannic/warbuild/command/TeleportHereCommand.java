package ch.yannic.warbuild.command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.yannic.warbuild.main.Main;

public class TeleportHereCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du kannst keinen zu dir teleportieren!");
			return true;
		}
		Player player = (Player) sender;
		if(!player.hasPermission("warbuild.teleport.here")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length != 0) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				target.teleport(player);
				player.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " zu dir teleportiert!");
				player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 4, 4);
				target.sendMessage(Main.getInstance().prefix() + " §7Du wurdest zu " + player.getName() + " teleportiert!");
				return true;
			}
			player.sendMessage(Main.getInstance().prefix() + " §7Der Spieler " + args[0] + " ist nicht online!");
		}
		if(args.length > 1) {
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /tphere (SPIELER)!");
			return true;
		}
		player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /tphere (SPIELER)!");

		return false;
	}

}
