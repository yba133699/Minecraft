package ch.yannic.survivalplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderchestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(!(s instanceof Player)) {
            s.sendMessage("Du kannst diesen Befehl nicht ausführen");
            return true;
        }
        Player p = (Player) s;
        if(args.length == 0) {
            p.openInventory(p.getEnderChest());
        }
        return false;
    }
}
