package fr.eter.hideandseek.manager.task;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eter.hideandseek.HideAndSeek;
import fr.eter.hideandseek.utils.PlayerManager;
import fr.eter.hideandseek.utils.StateManager;
import fr.eter.hideandseek.GStates;

public class GAutoStart extends BukkitRunnable {

	private int timer = 20;
	private HideAndSeek main;

	public GAutoStart(HideAndSeek main) {
		this.main = main;
	}

	@Override
	public void run() {
		for (Player pl : PlayerManager.getPlayerList()) {
			pl.setLevel(timer);
		}
		if (timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1)
			Bukkit.broadcastMessage("The game will start in " + timer + "s.");
		if (timer == 0) {
			PlayerManager.setHunter(
					PlayerManager.getPlayerList().get((int) (Math.random() * PlayerManager.getPlayerList().size())));
			for (Player pl : PlayerManager.getPlayerList()) {
				if (pl == PlayerManager.getHunter()) {
					pl.sendTitle("Hunter", "The game has started.", 10, 80, 20);
					ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("Ghost Hunter");
					meta.setUnbreakable(true);
					List<String> lore = new ArrayList<String>();
					lore.add("The definition of god himself.");
					lore.add("The special sword for the Ghost hunter.");
					meta.setLore(lore);
					meta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
					item.setItemMeta(meta);
					pl.getInventory().setItemInMainHand(item);
					Location spawn = new Location(pl.getWorld(), 165.500, 4, 133.300);
					pl.teleport(spawn);
				} else {
					pl.sendTitle("Human", "Try to live.", 10, 80, 20);
					pl.addPotionEffect(PotionEffectType.SPEED.createEffect(99999, 3));
				}
			}
			StateManager.setState(GStates.HUNT);
			GPlayerMove moveCycle = new GPlayerMove();
			moveCycle.runTaskTimer(this.main, 0, 3);
			GChase cycle = new GChase(this.main);
			cycle.runTaskTimer(this.main, 0, 20);
			cancel();
		}
		timer--;
	}

}
