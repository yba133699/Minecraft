package ch.yannic.warbuild.command;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.yannic.warbuild.main.Main;

public class GamemodeCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			if(args.length != 2) {
				sender.sendMessage("Bitte benutze /gm (GAMEMODE) (SPIELER)");
				return true;
			}
			
			Player target = Bukkit.getPlayer(args[1]);
			if(target != null) {
				if(args[0].equals("0")) {
					target.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " in den Überlebensmodus gesetzt");
					target.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Survivalmodus");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					return true;
				} 
				if(args[0].equals("1")) {
					target.setGameMode(GameMode.CREATIVE);
					sender.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " in den Kreativmodus gesetzt");
					target.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Kreativmodus");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					return true;
				} 
				if(args[0].equals("2")) {
					target.setGameMode(GameMode.ADVENTURE);
					sender.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " in den Adventuremodus gesetzt");
					target.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Adventuremodus");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					return true;
				}
				if(args[0].equals("3")) {
					target.setGameMode(GameMode.SPECTATOR);
					sender.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " in den Zuschauermodus gesetzt");
					target.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Zuschauermodus");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					return true;
				}
				sender.sendMessage("Du kannst den Spieler nur in 1/2/3/4 setzen!");
				return true;
			}
			sender.sendMessage(args[1] + " ist nicht online!");
			return true;
		}
		Player player = (Player) sender;
		if(!player.hasPermission("warbuild.gamemode")) {
			player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			return true;
		}
		if(args.length != 1) {
			Player target = Bukkit.getPlayer(args[1]);
			if(target != null) {
				if(args[0].equals("0") || args[0].equalsIgnoreCase("survival")) {
					target.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " in den Überlebensmodus gesetzt");
					target.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Survivalmodus");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					return true;
				}
				if(args[0].equals("1") || args[0].equalsIgnoreCase("creative")) {
					target.setGameMode(GameMode.CREATIVE);
					player.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " in den Kreativmodus gesetzt");
					target.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Kreativmodus");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					return true;
				}
				if(args[0].equals("2") || args[0].equalsIgnoreCase("adventure")) {
					target.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " in den Adventuremodus gesetzt");
					target.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Adventuremodus");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					return true;
				}
				if(args[0].equals("3") || args[0].equalsIgnoreCase("spectator")) {
					target.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(Main.getInstance().prefix() + " §7Du hast " + target.getName() + " in den Zuschauermodus gesetzt");
					target.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Zuschauermodus");
					target.playSound(target.getLocation(), Sound.LEVEL_UP, 4, 4);
					return true;
				}
				player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /gm (GAMEMODE) (SPIELER)");
				return true;
				
			}
			player.sendMessage(Main.getInstance().prefix() + " §7Der Spieler " + args[1] + " ist nicht online!");
			return true;
		}
		if(args.length != 2) {
			if(args[0].equals("0") || args[0].equalsIgnoreCase("survival")) {
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Survivalmodus");
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
				return true;
			}
			if(args[0].equals("1") || args[0].equalsIgnoreCase("creative")) {
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Kreativmodus");
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
				return true;
			}
			if(args[0].equals("2") || args[0].equalsIgnoreCase("adventure")) {
				player.setGameMode(GameMode.ADVENTURE);
				player.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Adventuremodus");
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
				return true;
			}
			if(args[0].equals("3") || args[0].equalsIgnoreCase("spectator")) {
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage(Main.getInstance().prefix() + " §7Du bist nun im Zuschauermodus");
				player.playSound(player.getLocation(), Sound.LEVEL_UP, 4, 4);
				return true;
			}
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /gm (GAMEMODE)");
			return true;
		}
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /gm (GAMEMODE) (SPIELER)");
			return true;
	}
}
