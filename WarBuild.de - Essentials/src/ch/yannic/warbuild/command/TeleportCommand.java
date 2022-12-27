package ch.yannic.warbuild.command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.yannic.warbuild.main.Main;

public class TeleportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du kannst dich nicht teleportieren!");
			return true;
		}
		Player player = (Player) sender;
		if(!player.hasPermission("warbuild.teleport")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length != 0) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				player.teleport(target);
				player.sendMessage(Main.getInstance().prefix() + " §7Du wurdest zu " + target.getName() + " teleportiert!");
				player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 4, 4);
				target.sendMessage(Main.getInstance().prefix() + "§7" + player.getName() + " hat sich zu dir teleportiert!");
				return true;
			}
			player.sendMessage(Main.getInstance().prefix() + " §7Der Spieler " + args[0] + " ist nicht online!");
		}
		if(args.length > 1) {
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /tp (SPIELER)!");
			return true;
		}
		player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /tp (SPIELER)!");

		return false;
	}

}
