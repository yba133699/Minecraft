package ch.yannic.survivalplugin;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

import static org.bukkit.Sound.*;

public class GodCommand implements CommandExecutor {


    private final static ArrayList<Player> godMode = new ArrayList<Player>();

    public static ArrayList<Player> getGodMode() {
        return new ArrayList<Player>(godMode);
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player) s;
        if(args.length != 0) {
            p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§c/god");
            p.playSound(p.getLocation(), BLOCK_ANVIL_DESTROY, 1f, 1f);
            return true;
        }
        if(!godMode.contains(p)) {
            p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§eDu bist jetzt im Godmode!");
            p.playSound(p.getLocation(), ITEM_TRIDENT_THUNDER, 1f, 1f);
            p.sendTitle("§e§lGODMODE", "§a§lACTIVE", 1, 20, 1);
            godMode.add(p);
        } else {
            p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§eDu bist jetzt nicht mehr im Godmode!.");
            p.playSound(p.getLocation(), ITEM_TRIDENT_THUNDER, 1f, 1f);
            p.sendTitle("§e§lGODMODE", "§c§lDISABLED", 1, 20, 1);
            godMode.remove(p);
        }
        return false;
    }


}
