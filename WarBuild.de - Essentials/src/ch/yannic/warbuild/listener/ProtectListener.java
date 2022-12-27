package ch.yannic.warbuild.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import ch.yannic.warbuild.main.Main;

public class ProtectListener implements Listener{

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

    @SuppressWarnings("unlikely-arg-type")
	@EventHandler
    public void onWeatherChange(WeatherChangeEvent event){
    	if(!event.getWorld().equals("Spawn")) {
    		 event.setCancelled(false);
    		 return;
    	}
    	event.setCancelled(true);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        event.setDeathMessage(null);
        FileConfiguration config = Main.getInstance().getConfig();
		World world = Bukkit.getWorld(config.getString("Spawn.World"));
		double x = config.getDouble("Spawn.X");
		double y = config.getDouble("Spawn.Y");
		double z = config.getDouble("Spawn.Z");
		float yaw = (float) config.getDouble("Spawn.Yaw");
		float pitch = (float) config.getDouble("Spawn.Pitch");
		Location spawn = new Location(world, x, y, z, yaw, pitch);
        event.getEntity().teleport(spawn);
    }

    @EventHandler
    public void onErfolg(PlayerAchievementAwardedEvent event){
        event.setCancelled(true);
    }
    
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
    	event.setCancelled(true);
    }
    
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
    	if(!BuildCommand.getBuild().contains(event.getPlayer())) {
    		event.setCancelled(true);
    		return;
    	}
    	event.setCancelled(false);
    }
    
    @EventHandler
    public void onBlockBreak(BlockPlaceEvent event) {
    	if(!BuildCommand.getBuild().contains(event.getPlayer())) {
    		event.setCancelled(true);
    		return;
    	}
    	event.setCancelled(false);
    }
    
    @EventHandler
    public void onFall(PlayerMoveEvent event) {
    	Player player = event.getPlayer();
    	if(player.getLocation().getBlockY() <= 0) {
    		player.setHealth(0);
	    }
    }
}
    