package fr.eter.hideandseek.manager.task;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eter.hideandseek.utils.PlayerManager;
import fr.eter.hideandseek.utils.PlayerMoving;

public class GPlayerMove extends BukkitRunnable {

	@Override
	public void run() {
		for(Player p : PlayerManager.getPlayerList()) {
			if (PlayerMoving.isInList(p)) {
				Long lastTime = PlayerMoving.getTimer(p);
				Long actualTime = System.currentTimeMillis();
				if ((actualTime - lastTime) >= 30000) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 3.0F, 0.5F);
					PlayerMoving.replaceTimer(p, System.currentTimeMillis());
				}
				if ((actualTime - lastTime) >= 2000) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20,0, false, false));
				}
			}
		}
	}

}
