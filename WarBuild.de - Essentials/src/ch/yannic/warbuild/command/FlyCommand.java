package ch.yannic.warbuild.command;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ch.yannic.warbuild.main.Main;

public class FlyCommand implements CommandExecutor{

private final static ArrayList<Player> onFly = new ArrayList<Player>();
	
	public static ArrayList<Player> getOnFly() {
		return new ArrayList<Player>(onFly);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			if(args.length != 1) {
				sender.sendMessage("§cAls KONSOLE kannst du nur den Flugmodus von anderen ändern /fly <SPIELER>");
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(!onFly.contains(target)) {
					target.setAllowFlight(true);
					target.sendMessage("Dein Flugmodus wurde von CONSOLE aktiviert!");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					sender.sendMessage("Du hast den Flugmodus von " + target.getName() + " aktiviert!");
					onFly.add(target);
					return true;
				}
				target.setAllowFlight(false);
				target.sendMessage("Dein Flugmodus wurde von CONSOLE deaktiviert!");
				target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
				sender.sendMessage("Du hast den Flugmodus von " + target.getName() + " deaktiviert!");
				onFly.remove(target);
				return true;
			}
			sender.sendMessage("§c" + args[0] + " §7ist nicht online!");
			return true;
		}
		Player player = (Player)sender;
    	if(!player.hasPermission("warbuild.fly") && !player.hasPermission("warbuild.fly.other")) {
    		player.sendMessage(Main.getInstance().noperms());
    		player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
    		return true;
    	}
    	if(!player.hasPermission("warbuild.fly") && player.hasPermission("warbuild.fly.other")) {
		    if (args.length != 1) {
		    	player.sendMessage(Main.getInstance().noperms());
			    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    return true;
		    } 
		    Player target = Bukkit.getPlayer(args[0]);
		    if(target != null) {
		    	if(!onFly.contains(target)) {
					target.setAllowFlight(true);
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					target.sendMessage("Dein Flugmodus wurde von " + player.getName() + " aktiviert!");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
					player.sendMessage("Du hast den Flugmodus von " + target.getName() + " aktiviert!");
					onFly.add(target);
					return true;
			    }
		    	if(onFly.contains(target)) {
		    		target.setAllowFlight(false);
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					target.sendMessage("Dein Flugmodus wurde von " + player.getName() + " aktiviert!");
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
					player.sendMessage("Du hast den Flugmodus von " + target.getName() + " aktiviert!");
					onFly.remove(target);
					return true;
		    	}
			    player.sendMessage("§c" + args[0] + " §7ist nicht online!");
			    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    return true;
	    	}
		    if(player.hasPermission("warbuild.fly") && !player.hasPermission("warbuild.fly.other")) {
	    		if (args.length > 1) {
			    	player.sendMessage("§cBitte benutze §6/fly <SPIELER>§c!");
			    	player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    	return true;
			    } 
			    if (args.length != 1) {
			    	if(!onFly.contains(player)) {
			    		player.setAllowFlight(true);
			    		player.sendMessage("Dein Flugmodus wurde aktiviert!");
			    		player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
			    		onFly.add(player);
			    		return true;
			    	}
			    	player.setAllowFlight(true);
			    	player.sendMessage("Dein Flugmodus wurde deaktiviert!");
		    		player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
		    		onFly.remove(player);
		    		return true;
			    } 
			    player.sendMessage(Main.getInstance().noperms());
			    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    return true;
	    	}
	    	if(player.hasPermission("warbuild.fly") && player.hasPermission("warbuild.fly.other")) {
	    		if (args.length > 1) {
			    	player.sendMessage("§cBitte benutze §6/fly <SPIELER>§c!");
			    	player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    	return true;
			    } 
			    if (args.length != 1) {
			    	if(!onFly.contains(player)) {
			    		player.setAllowFlight(true);
			    		player.sendMessage("Dein Flugmodus wurde aktiviert!");
			    		player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
			    		onFly.add(player);
			    		return true;
			    	}
			    	player.setAllowFlight(true);
			    	player.sendMessage("Dein Flugmodus wurde deaktiviert!");
		    		player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
		    		onFly.remove(player);
		    		return true;
			    } 
			    if(!onFly.contains(target)) {
			    	player.setAllowFlight(true);
		    		player.sendMessage("Dein Flugmodus wurde aktiviert!");
		    		player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
		    		onFly.add(player);
		    		return true;
			    }
		    		
	    	}
		    player.sendMessage("§c" + args[0] + " §7ist nicht online!");
		    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
		    return true;
    	}
    	return false;
	}
			
}
