package fr.eter.hideandseek.manager.server.members;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import fr.eter.hideandseek.GStates;
import fr.eter.hideandseek.utils.PlayerMoving;
import fr.eter.hideandseek.utils.StateManager;

public class OnMovement implements Listener {
	
	/**
	 * onJoin event function, triggered when someone join the server
	 * 
	 * @param e	Event triggered
	 */
	@EventHandler
	public void onMovement(PlayerMoveEvent e) {
		if (!StateManager.isState(GStates.HUNT)) return;
		Player player = e.getPlayer();
		if (PlayerMoving.isInList(player)) {
			PlayerMoving.replaceTimer(player, System.currentTimeMillis());
			boolean playerHasEffect = player.hasPotionEffect(PotionEffectType.INVISIBILITY);
			if (playerHasEffect) {
				player.removePotionEffect(PotionEffectType.INVISIBILITY);
			}
		} else {
			PlayerMoving.setTimer(player, System.currentTimeMillis());
		}
	}
	
}
