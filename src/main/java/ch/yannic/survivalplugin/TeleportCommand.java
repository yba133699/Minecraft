package ch.yannic.survivalplugin;

import ch.yannic.survivalplugin.SurvivalPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Sound.*;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player) s;
        Player t1 = Bukkit.getPlayer(args[0]);
        Player t2 = Bukkit.getPlayer(args[1]);
        if (args.length == 1) {
            if (t1 != null) {
                p.teleport(t1);
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest zu §a" + t1.getName() + " §7teleportiert.");
                p.playSound(p.getLocation(), ENTITY_PLAYER_LEVELUP, 1f, 1f);
            } else {
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§c" + args[0] + "§7 ist offline");
                p.playSound(p.getLocation(), BLOCK_ANVIL_DESTROY, 1f, 1f);
            }
        } else if (args.length == 2) {
            if (t1 != null && t2 != null) {
                t1.teleport(t2);
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§a" + t1.getName() + "§7wurde zu §a" + t2.getName() + " §7teleportiert.");
                t1.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest zu §a" + t2.getName() + " §7teleportiert.");
                t2.sendMessage(SurvivalPlugin.getInstance().prefix() + "§a" + t1.getName() + " §7wurde zu dir teleportiert.");
            } else if(t1 == null) {
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§c" + args[0] + " §7ist nicht online");
            } else {
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§c" + args[1] + " §7ist nicht online");
            }
        } else {
            p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§c/teleport <Player>");
            p.playSound(p.getLocation(), BLOCK_ANVIL_DESTROY, 1f, 1f);
        }
        return false;
    }

}
