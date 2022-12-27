package ch.yannic.warbuild.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import ch.yannic.warbuild.main.Main;

public class SetDeathhigh implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du kannst die Todeshöhe nicht definieren");
			return true;
		}
		Player player = (Player) sender;
		if(!player.hasPermission("warbuild.deathhigh")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length != 0) {
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /deathhigh");
			return true;
		}
		FileConfiguration config = Main.getInstance().getConfig();
		
		config.set("Lufthafen.World", player.getWorld().getName());
		config.set("Lufthafen.Y", player.getLocation().getY());
		Main.getInstance().saveConfig();
		player.sendMessage(Main.getInstance().prefix() + "§7Du hast die Todeshöhe gesetzt!");
		return true;
	}

}
