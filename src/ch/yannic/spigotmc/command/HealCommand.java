package ch.yannic.spigotmc.command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ch.yannic.spigotmc.main.Main;

public class HealCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if (!(sender instanceof Player)) {
			if (args.length != 1) {
				sender.sendMessage(String.valueOf(Main.prefix) + Main.consoleusage);
				return true;
			} 
			Player target = Bukkit.getPlayer(args[0]);
			if (target != null) {
				target.setHealth(target.getMaxHealth());
		        target.setFoodLevel(20);
		        target.sendMessage(String.valueOf(Main.prefix) + Main.healedfromconsole);
		        target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
		        sender.sendMessage(String.valueOf(Main.prefix) + Main.playermessage);
		        return true;
			} 
			sender.sendMessage(String.valueOf(Main.prefix) + Main.notonline);
			return true;
	    } 
		Player player = (Player)sender;
	    	if(!player.hasPermission(String.valueOf(Main.healperms)) && !player.hasPermission(String.valueOf(Main.healotherperms))) {
	    		player.sendMessage(String.valueOf(Main.prefix) + Main.noperms);
	    		player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
	    		return true;
	    	}
	    	if(!player.hasPermission(String.valueOf(Main.healperms)) && player.hasPermission(String.valueOf(Main.healotherperms))) {
			    if (args.length != 1) {
			    	player.sendMessage(String.valueOf(Main.prefix) + Main.noperms);
				    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
				    return true;
			    } 
			    Player target = Bukkit.getPlayer(args[0]);
			    if(target != null) {
			    	target.setHealth(target.getMaxHealth());
			    	target.setFoodLevel(20);
			    	target.sendMessage(String.valueOf(Main.prefix) + Main.targetmessage);
			    	player.sendMessage(String.valueOf(Main.prefix) + Main.playermessage);
			    	player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
			    	return true;
			    }
			    player.sendMessage(String.valueOf(Main.prefix) + Main.notonline);
			    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    return true;
	    	} 
	    	if(player.hasPermission(String.valueOf(Main.healperms)) && !player.hasPermission(String.valueOf(Main.healotherperms))) {
	    		if (args.length > 1) {
			    	player.sendMessage(String.valueOf(Main.prefix) + Main.usage);
			    	player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    	return true;
			    } 
			    if (args.length != 1) {
			    	player.setHealth(player.getMaxHealth());
			    	player.setFoodLevel(20);
			    	player.sendMessage(String.valueOf(Main.prefix) + Main.selfmessage);
			    	player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
			    	return true;
			    } 
			    player.sendMessage(String.valueOf(Main.prefix) + Main.noperms);
			    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    return true;
	    	}
	    	if(player.hasPermission(String.valueOf(Main.healperms)) && player.hasPermission(String.valueOf(Main.healotherperms))) {
	    		if (args.length > 1) {
			    	player.sendMessage(String.valueOf(Main.prefix) + Main.usage);
			    	player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    	return true;
			    } 
			    if (args.length != 1) {
			    	player.setHealth(player.getMaxHealth());
			    	player.setFoodLevel(20);
			    	player.sendMessage(String.valueOf(Main.prefix) + Main.selfmessage);
			    	player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
			    	return true;
			    } 
			    Player target = Bukkit.getPlayer(args[0]);
			    if(target != null) {
			    	target.setHealth(target.getMaxHealth());
			    	target.setFoodLevel(20);
			    	target.sendMessage(String.valueOf(Main.prefix) + Main.targetmessage);
			    	player.sendMessage(String.valueOf(Main.prefix) + Main.playermessage);
			    	player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
			    	return true;
			    }
			    player.sendMessage(String.valueOf(Main.prefix) + Main.notonline);
			    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
			    return true;
	    	}
	    	return false;
		}
	}