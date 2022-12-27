package ch.yannic.warbuild.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import ch.yannic.warbuild.main.Main;
import ch.yannic.warbuild.utils.ItemBuilder;

public class KitCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du kannst kein Kit auswählen.");
			return true;
		}
		Player player = (Player) sender;
		if(args.length != 0) {
			player.sendMessage(Main.getInstance().prefix() + " §7Bitte benutze /kit");
			return true;
		}
		Inventory kitGUI = Bukkit.createInventory(null, 3*9);
		kitGUI.setItem(13, new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName("§bMinewars").build());
		player.openInventory(kitGUI);
		player.sendMessage(Main.getInstance().prefix() + " §7Du hast das Kit erfolgreich ausgewählt!");
		return false;
	}

}
