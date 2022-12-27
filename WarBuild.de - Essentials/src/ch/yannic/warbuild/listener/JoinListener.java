package ch.yannic.warbuild.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ch.yannic.warbuild.main.Main;
import ch.yannic.warbuild.utils.TablistPrefix;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		FileConfiguration config = Main.getInstance().getConfig();
		World world = Bukkit.getWorld(config.getString("Spawn.World"));
		double x = config.getDouble("Spawn.X");
		double y = config.getDouble("Spawn.Y");
		double z = config.getDouble("Spawn.Z");
		float yaw = (float) config.getDouble("Spawn.Yaw");
		float pitch = (float) config.getDouble("Spawn.Pitch");
		Location spawn = new Location(world, x, y, z, yaw, pitch);
		player.teleport(spawn);
		event.setJoinMessage("§7[§a+§7] " + event.getPlayer().getName());
		player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
		TablistPrefix.setScoreboard();
		
	}

	@EventHandler
	public void Quit(PlayerQuitEvent event) {
		event.setQuitMessage("§7[§c-§7] " + event.getPlayer().getName());
	
	}
}
