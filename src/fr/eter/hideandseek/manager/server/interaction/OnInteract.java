package fr.eter.hideandseek.manager.server.interaction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnInteract implements Listener {

	@EventHandler
	public void onInteraction(PlayerInteractEvent evt) {
		Player p = evt.getPlayer();
		Action a = evt.getAction();
		ItemStack it = evt.getItem();
		
		if (it == null) return;
		
		if (a != Action.RIGHT_CLICK_AIR && a != Action.RIGHT_CLICK_BLOCK) return;
		
		if (it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.MAGIC + "Emetteur de bruit")) {
			Inventory soundInv = Bukkit.createInventory(null, 18, "Différents sons");
			
			soundInv.addItem(getItem(Material.DRAGON_EGG, "Dragon"));
			soundInv.addItem(getItem(Material.ENDERMAN_SPAWN_EGG, "Enderman"));
			soundInv.addItem(getItem(Material.DROWNED_SPAWN_EGG, "Noyé"));
			soundInv.addItem(getItem(Material.ZOMBIE_SPAWN_EGG, "Zombie"));
			soundInv.addItem(getItem(Material.WOLF_SPAWN_EGG, "Loup"));
			soundInv.addItem(getItem(Material.BLAZE_SPAWN_EGG, "Blaze"));
			soundInv.addItem(getItem(Material.CREEPER_SPAWN_EGG, "Creeper"));
			soundInv.addItem(getItem(Material.FOX_SPAWN_EGG, "Renard"));
			soundInv.addItem(getItem(Material.GHAST_SPAWN_EGG, "Ghast"));
			soundInv.addItem(getItem(Material.WITCH_SPAWN_EGG, "Sorcière"));
			soundInv.addItem(getItem(Material.WITHER_SKELETON_SKULL, "Wither"));
			soundInv.addItem(getItem(Material.GLASS_BOTTLE, "Verre"));
			
			p.openInventory(soundInv);
		}
	}

	private ItemStack getItem(Material mat, String name) {
		ItemStack newItem = new ItemStack(mat);
		ItemMeta newItemMeta = newItem.getItemMeta();
		if (name != null) newItemMeta.setDisplayName(name);
		newItem.setItemMeta(newItemMeta);
		return newItem;
	}
	
}
