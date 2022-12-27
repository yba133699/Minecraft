package ch.yannic.warbuild.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatPrefixListener implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player player = e.getPlayer();
		
		String msg = e.getMessage().replaceAll( "%", "%%" );

            if(player.hasPermission("prefix.manager")) {
                e.setFormat("§4Manager §8• §4" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.admin")) {
                e.setFormat("§4Admin §8• §4" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.srmod")) {
                e.setFormat("§cSrMod §8• §c" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.mod")) {
                e.setFormat("§cMod §8• §c" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.srdev")) {
                e.setFormat("§bSrDev §8• §b" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.dev")) {
                e.setFormat("§bDev §8• §b" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.sup")) {
                e.setFormat("§9Sup §8• §9" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.archi")) {
                e.setFormat("§2Archi §8• §2" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.content")) {
                e.setFormat("§eContent §8• §e" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.youtuber")) {
                e.setFormat("§5Youtuber §8• §5" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.freund")) {
                e.setFormat("§dFreund §8• §d" + player.getName() + " §8» §7" + msg);
            } else if(player.hasPermission("prefix.premium")) {
                e.setFormat("§6Premium §8• §6" + player.getName() + " §8» §7" + msg);
            } else {
                e.setFormat("§7Spieler §8• §7" + player.getName() + " §8» §7" + msg);
            }
	}

}
