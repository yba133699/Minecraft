package ch.yannic.warbuild.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import ch.yannic.warbuild.utils.ItemBuilder;
import ch.yannic.warbuild.utils.ItemManager;

public class KitListener implements Listener {
	
	@EventHandler
	public void kitGui(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();
		player.closeInventory();
		player.getInventory().setHelmet(new ItemBuilder(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DURABILITY, 10).build());
		player.getInventory().setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DURABILITY, 10).build());
		player.getInventory().setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DURABILITY, 10).build());
		player.getInventory().setBoots(new ItemBuilder(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchantment(Enchantment.DURABILITY, 10).build());
		player.getInventory().setItem(0, new ItemBuilder(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 5).addEnchantment(Enchantment.DURABILITY, 10).build());
		player.getInventory().setItem(0, new ItemBuilder(Material.FISHING_ROD).addEnchantment(Enchantment.DURABILITY, 10).build());
		new ItemManager();
		player.getInventory().setItem(8, ItemManager.createItem(Material.POTION, 64, 1, "§cdrugs"));
		player.getInventory().setItem(8, ItemManager.createItem(Material.GOLDEN_APPLE, 8, 1, "§cdrugs"));
		player.getInventory().setItem(8, new ItemBuilder(Material.ENDER_PEARL).setAmount(4).build());
	}

}
