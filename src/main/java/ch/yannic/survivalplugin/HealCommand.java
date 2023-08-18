package ch.yannic.survivalplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Sound.BLOCK_ANVIL_DESTROY;
import static org.bukkit.Sound.ENTITY_PLAYER_LEVELUP;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player) s;
        if(p.hasPermission("system.heal")) {
            if(args.length == 0) {
                p.setHealth(20); //p.getMaxHealth()
                p.setFoodLevel(20);
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest geheilt");
                p.playSound(p.getLocation(), ENTITY_PLAYER_LEVELUP, 1f, 1f);
            } else if(args.length == 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if(t != null) {
                    t.setHealth(20); //p.getMaxHealth()
                    t.setFoodLevel(20);
                    t.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest geheilt");
                    p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du hast §a" + t.getName() + " §7geheilt");
                    p.playSound(p.getLocation(), ENTITY_PLAYER_LEVELUP, 1f, 1f);
                    t.playSound(t.getLocation(), ENTITY_PLAYER_LEVELUP, 1f, 1f);
                } else {
                    p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§c" + args[0] + "§7 ist offline");
                    p.playSound(p.getLocation(), BLOCK_ANVIL_DESTROY, 1f, 1f);
                }

            } else {
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§c/heal <Player>");
                p.playSound(p.getLocation(), BLOCK_ANVIL_DESTROY, 1f, 1f);
            }
        } else {
            p.sendMessage(SurvivalPlugin.getInstance().prefix() + SurvivalPlugin.getInstance().noperms());
            p.playSound(p.getLocation(), BLOCK_ANVIL_DESTROY, 1f, 1f);
        }



        return false;
    }
}
