package ch.yannic.warbuild.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ch.yannic.warbuild.main.Main;

public class SetSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDu musst ein Spieler sein!");
			return true;
		}
	
		Player player = (Player) sender;
		
		if(!player.hasPermission("warbuild.spawn.set")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length != 0) {
			player.sendMessage(Main.getInstance().prefix() + "§cBitte benutze /setspawn!");
			return true;
		}
		FileConfiguration config = Main.getInstance().getConfig();
		config.set("Spawn.World", player.getWorld().getName());
		config.set("Spawn.X", player.getLocation().getX());
		config.set("Spawn.Y", player.getLocation().getY());
		config.set("Spawn.Z", player.getLocation().getZ());
		config.set("Spawn.Yaw", player.getLocation().getYaw());
		config.set("Spawn.Pitch", player.getLocation().getPitch());
		Main.getInstance().saveConfig();
		player.sendMessage(Main.getInstance().prefix() + "§7Du hast den Spawnpunkt gesetzt!");
		return false;
	}

}
