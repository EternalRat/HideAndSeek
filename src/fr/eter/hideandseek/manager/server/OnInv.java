package fr.eter.hideandseek.manager.server;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class OnInv implements Listener {

	@EventHandler
	public void onInv(InventoryClickEvent evt) {
		Inventory inv = evt.getInventory();
		InventoryView invView = evt.getView();
		Player p = (Player) evt.getWhoClicked();
		ItemStack item = evt.getCurrentItem();
		
		if (item == null) return;
		
		if (invView.getTitle().equalsIgnoreCase("Différents sons")) {
			evt.setCancelled(true);
			p.closeInventory();
			Material[] materials = new Material[] {Material.DRAGON_EGG, Material.ENDERMAN_SPAWN_EGG, Material.DROWNED_SPAWN_EGG, Material.ZOMBIE_SPAWN_EGG, Material.WOLF_SPAWN_EGG, Material.BLAZE_SPAWN_EGG,
					Material.CREEPER_SPAWN_EGG, Material.FOX_SPAWN_EGG, Material.GHAST_SPAWN_EGG, Material.WITCH_SPAWN_EGG};
			Sound[] sounds = new Sound[] {Sound.ENTITY_ENDER_DRAGON_AMBIENT, Sound.ENTITY_ENDERMAN_SCREAM, Sound.ENTITY_DROWNED_AMBIENT, Sound.ENTITY_ZOMBIE_AMBIENT, Sound.ENTITY_WOLF_AMBIENT, Sound.ENTITY_BLAZE_AMBIENT,
					Sound.ENTITY_CREEPER_PRIMED, Sound.ENTITY_FOX_SCREECH, Sound.ENTITY_GHAST_AMBIENT, Sound.ENTITY_WITCH_AMBIENT};
			playSound(sounds[searchIndex(materials, item.getType())], p);
		}
	}
	
	private Integer searchIndex(Material[] materials, Material mat) {
		Integer index = 0;
		for (Material material : materials) {
			if (material == mat) {
				return index;
			}
			index++;
		}
		return 0;
	}
	
	private void playSound(Sound sound, Player p) {
		p.getWorld().playSound(p.getLocation(), sound, 3.0F, 0.5F);
	}
	
}
