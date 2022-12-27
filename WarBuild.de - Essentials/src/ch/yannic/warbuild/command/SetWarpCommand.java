package ch.yannic.warbuild.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ch.yannic.warbuild.main.Main;

public class SetWarpCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDu musst ein Spieler sein!");
			return true;
		}
	
		Player player = (Player) sender;
		
		if(!player.hasPermission("warbuild.warp.set")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length != 1) {
			player.sendMessage(Main.getInstance().prefix() + "§cBitte benutze /setwarp (NAME)!");
			return true;
		}
		FileConfiguration config = Main.getInstance().getConfig();
		config.set("Warp.Name", args[0]);
		config.set("Warp.World", player.getWorld().getName());
		config.set("Warp.X", player.getLocation().getX());
		config.set("Warp.Y", player.getLocation().getY());
		config.set("Warp.Z", player.getLocation().getZ());
		config.set("Warp.Yaw", player.getLocation().getYaw());
		config.set("Warp.Pitch", player.getLocation().getPitch());
		Main.getInstance().saveConfig();
		player.sendMessage(Main.getInstance().prefix() + "§7Du hast den Warp " + args[0] + " gesetzt!");
		return false;
	}
	
}