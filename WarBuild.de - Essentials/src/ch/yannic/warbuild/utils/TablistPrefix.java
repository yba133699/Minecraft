package ch.yannic.warbuild.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class TablistPrefix {

	public static Scoreboard sb;
	
	public static void setScoreboard() {
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		
		sb.registerNewTeam("000Manager");
		sb.registerNewTeam("001Admin");
		sb.registerNewTeam("002SrMod");
		sb.registerNewTeam("003Mod");
		sb.registerNewTeam("004SrDev");
		sb.registerNewTeam("005Dev");
		sb.registerNewTeam("006Sup");
		sb.registerNewTeam("007Archi");
		sb.registerNewTeam("008Content");
		sb.registerNewTeam("009Youtuber");
		sb.registerNewTeam("010Freund");
		sb.registerNewTeam("011Premium");
		sb.registerNewTeam("012Spieler");
		
		sb.getTeam("000Manager").setPrefix("§4Manager §8• §4");
		sb.getTeam("001Admin").setPrefix("§4Admin §8• §4");
		sb.getTeam("002SrMod").setPrefix("§cSrMod §8• §c");
		sb.getTeam("003Mod").setPrefix("§cMod §8• §c");
		sb.getTeam("004SrDev").setPrefix("§bSrDev §8• §b");
		sb.getTeam("005Dev").setPrefix("§bDev §8• §b");
		sb.getTeam("006Sup").setPrefix("§9Sup §8• §9");
		sb.getTeam("007Archi").setPrefix("§2Archi §8• §2");
		sb.getTeam("008Content").setPrefix("§eContent §8• §e");
		sb.getTeam("009Youtuber").setPrefix("§5Youtube §8• §5");
		sb.getTeam("010Freund").setPrefix("§dFreund §8• §d");
		sb.getTeam("011Premium").setPrefix("§6Premium §8• §6");
		sb.getTeam("012Spieler").setPrefix("§7Spieler §8• §7");
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			TablistPrefix.setTeams(all);
		}
		
	}
	
	private static void setTeams(Player player) {
		String team = "";
		
		if(player.hasPermission("prefix.manager") || player.isOp()) {
			team = "000Manager";
		
		}else if(player.hasPermission("prefix.admin")) {
			team = "001Admin";	
		
		}else if(player.hasPermission("prefix.srmod")) {
			team = "002SrMod";
		
		} else if(player.hasPermission("prefix.mod")) {
			team = "003Mod";
		
		} else if(player.hasPermission("prefix.srdev")) {
			team = "004SrDev";
		
		} else if(player.hasPermission("prefix.dev")) {
			team = "005Dev";
		
		} else if(player.hasPermission("prefix.sup")) {
			team = "006Sup";
		
		} else if(player.hasPermission("prefix.archi")) {
			team = "007Archi";
		
		} else if(player.hasPermission("prefix.content")) {
			team = "008Content";
		
		} else if(player.hasPermission("prefix.youtuber")) {
			team = "009Youtuber";
		
		} else if(player.hasPermission("prefix.freund")) {
			team = "010Freund";
		
		} else if(player.hasPermission("prefix.premium")) {
			team = "011Premium";	
		
		} else {
			team = "012Spieler";
		}
		
		sb.getTeam(team).addPlayer(player);
		player.setScoreboard(sb);
	}
	
}
