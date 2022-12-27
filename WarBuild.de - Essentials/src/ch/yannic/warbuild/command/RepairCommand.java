package ch.yannic.warbuild.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ch.yannic.warbuild.main.Main;
import net.minecraft.server.v1_8_R1.Material;

public class RepairCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Du kannst kein Item reparieren!");
			return true;
		}
		Player player = (Player) sender;
		
		if(command.getName().equalsIgnoreCase("repair")) {
			if(!player.hasPermission("warbuild.repair")) {
				player.sendMessage(Main.getInstance().prefix() + Main.getInstance().noperms());
				return true;
			}

			if(args.length == 0) {
				if(player.getItemInHand().getItemMeta() != Material.AIR) {
					
					player.getItemInHand().setDurability((short) 0);
					player.sendMessage(Main.getInstance().prefix() + " §7Dein Item wurde repariert");
					return true;
				}
				player.sendMessage(Main.getInstance().prefix() + " §7Kein Item zum Reparieren!");
				return true;
			
			} 
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("all")) {
					repairAll(player);
					player.sendMessage(Main.getInstance().prefix() + " §7Du hast alle Items repariert!");
					return true;
				}
				player.sendMessage(Main.getInstance().prefix() + "§7Bitte benutze /repair <all>");
				return true;
			} 
			player.sendMessage(Main.getInstance().prefix() + "§7Bitte benutze /repair <all>");
			return true;
		}
		
				
		return false;
	}

	
	
	
	private void repairAll(Player player) {
		ItemStack[] items = player.getInventory().getContents();
		ItemStack[] armor = player.getInventory().getArmorContents();
		
		for(ItemStack item : items) {
			if(item != null) {
				item.setDurability((short) 0);
			}
		}
		
		for(ItemStack item : armor) {
				if(item != null) {
					item.setDurability((short) 0);
				}
			}
		}
 	}
		

	
	

