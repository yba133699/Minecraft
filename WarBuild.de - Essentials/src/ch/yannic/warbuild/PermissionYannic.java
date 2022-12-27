package ch.yannic.warbuild;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionYannic implements CommandExecutor {
	private Player player;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		player = (Player) sender;

		// Hier wird überprüft ob der Spieler eine Console ist..
		if (!(player instanceof Player))
			return false;

		if (player.hasPermission("permission.yannic")) {
			// Hier wird alles eingetragen was passieren soll
			if (label.equalsIgnoreCase("setpermission")) {
				try {
					String argument1_spielername = args[0];
					String argument2_permissionname = args[1];
				}catch(java.lang.ArrayIndexOutOfBoundsException ex) {}
				if(args.length > 2) return false;
				else if(args.length < 2) return false;
				
				//Hier kommt der Code rein der genau die richtige Menge an Argumenten beinhaltet
				//Sollte in MySQL gemacht werden
			} else if (label.equalsIgnoreCase("delpermission")) {

			}
		}
		return false;
	}
}
