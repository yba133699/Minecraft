package ch.yannic.survivalplugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player) s;
        if(args.length == 1) {
            if(args[0].equals("0")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest in den Survivalmodus gesetzt.");
            } else if(args[0].equals("1")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest in den Kreativmodus gesetzt.");
            } else if(args[0].equals("2")) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest in den Adventuremodus gesetzt.");
            } else if(args[0].equals("3")) {
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest in den Zuschauermodus gesetzt.");
            } else {
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§cBitte benutze /gm <Gamemode> <Spieler>");
            }
        } else if(args.length == 2) {
            Player t = Bukkit.getPlayer(args[1]);
            if(t != null) {
                if(args[0].equals("0")) {
                    t.setGameMode(GameMode.SURVIVAL);
                    t.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest in den Survivalmodus gesetzt.");
                } else if(args[0].equals("1")) {
                    t.setGameMode(GameMode.CREATIVE);
                    t.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest in den Kreativmodus gesetzt.");
                } else if(args[0].equals("2")) {
                    t.setGameMode(GameMode.ADVENTURE);
                    t.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest in den Adventuremodus gesetzt.");
                } else if(args[0].equals("3")) {
                    t.setGameMode(GameMode.SPECTATOR);
                    t.sendMessage(SurvivalPlugin.getInstance().prefix() + "§7Du wurdest in den Zuschauermodus gesetzt.");
                } else {
                    p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§cBitte benutze /gm <Gamemode> <Spieler>");
                }
            } else {
                p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§c" + args[1] + " §7ist offline!");
            }
        } else {
            p.sendMessage(SurvivalPlugin.getInstance().prefix() + "§cBitte benutze /gm <Gamemode> <Spieler>");
        }
        return false;
    }
}
