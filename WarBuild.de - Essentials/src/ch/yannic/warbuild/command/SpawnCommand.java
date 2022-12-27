package ch.yannic.warbuild.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import ch.yannic.warbuild.main.Main;

public class SpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cDu musst ein Spieler sein!");
			return true;
		}
	
		Player player = (Player) sender;
		
		if(!player.hasPermission("warbuild.spawn")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length != 0) {
			player.sendMessage(Main.getInstance().prefix() + "§cBitte benutze /spawn!");
			return true;
		}
		FileConfiguration config = Main.getInstance().getConfig();
		World world = Bukkit.getWorld(config.getString("Spawn.World"));
		double x = config.getDouble("Spawn.X");
		double y = config.getDouble("Spawn.Y");
		double z = config.getDouble("Spawn.Z");
		float yaw = (float) config.getDouble("Spawn.Yaw");
		float pitch = (float) config.getDouble("Spawn.Pitch");
		Location spawn = new Location(world, x, y, z, yaw, pitch);
		player.teleport(spawn);
		player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
		player.sendMessage(Main.getInstance().prefix() + "§7Du wurdest zum Spawn teleportiert!");
		return false;
	}

	
}
