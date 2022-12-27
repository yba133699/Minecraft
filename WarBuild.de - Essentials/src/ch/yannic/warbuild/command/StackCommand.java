package ch.yannic.warbuild.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import ch.yannic.warbuild.main.Main;

public class StackCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(player.hasPermission("warbuild.stack")) {
				this.stack(player);
				player.sendMessage(Main.getInstance().prefix() + " §7Deine Items wurden gestackt!");
			}else {
				player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
			}
		}
		return false;
	}
	
	private void stack(Player player) {
		Inventory inv = player.getInventory();
		for(int i = 0; i < inv.getSize(); i++) {
			ItemStack current = inv.getItem(i);
			Material material = current.getType();
			if(current.getAmount() >= 64) continue;
			for(int j = i + 1; j < inv.getSize(); j++) {
				ItemStack to_add = inv.getItem(j);
				if(material == to_add.getType() && material != Material.AIR) {
					int max_to_add = current.getMaxStackSize() - current.getAmount();
					if(to_add.getAmount() < max_to_add) {
						current.setAmount(current.getAmount() + to_add.getAmount());
						inv.setItem(j, new ItemStack(Material.AIR));
					}else {
						current.setAmount(current.getMaxStackSize());
						to_add.setAmount(to_add.getAmount() - max_to_add);
					}
				}
				
			}
		}
	}

}
