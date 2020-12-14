package fr.eter.hideandseek.manager.task;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eter.hideandseek.HideAndSeek;
import fr.eter.hideandseek.GStates;

public class GAutoStart extends BukkitRunnable {
	
	private int timer = 20;
	private HideAndSeek main;

	public GAutoStart(HideAndSeek main) {
		this.main = main;
	}

	@Override
	public void run() {
		for (Player pl : this.main.getPlayerList()) {
			pl.setLevel(timer);
		}
		if (timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1)
			Bukkit.broadcastMessage("The game will start in " + timer + "s.");
		if (timer == 0) {
			this.main.setHunter(this.main.getPlayerList().get((int)(Math.random() * main.getPlayerList().size())));
			for (Player pl : this.main.getPlayerList()) {
				if (pl == this.main.getHunter()) {
					pl.sendTitle("Hunter", "The game has started.", 10, 80, 20);
					ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("Supra Deaths");
					meta.setUnbreakable(true);
					List<String> lore = new ArrayList<String>();
					lore.add("The definition of god himself.");
					lore.add("The special sword for the Ghost hunter.");
					meta.setLore(lore);
					meta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
					item.setItemMeta(meta);
					pl.getInventory().setItemInMainHand(item);
				} else {
					pl.sendTitle("Humans", "Try to live.", 10, 80, 20);
					pl.addPotionEffect(PotionEffectType.SPEED.createEffect(99999, 3));
					pl.addPotionEffect(PotionEffectType.JUMP.createEffect(99999, 3));
				}
			}
			this.main.setState(GStates.HUNT);
			//GChase cycle = new GChase(main);
			
			//cycle.runTaskTimer(main, 0, 20);
			cancel();
		}
		timer--;
	}

}
