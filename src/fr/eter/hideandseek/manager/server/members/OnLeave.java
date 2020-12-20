package fr.eter.hideandseek.manager.server.members;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.eter.hideandseek.utils.PlayerManager;

public class OnLeave implements Listener {

	/**
	 * onJoin event function, triggered when someone join the server
	 * 
	 * @param e	Event triggered
	 */
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if (PlayerManager.isPlayerInTheList(player)) PlayerManager.removePlayerInList(player);
	}
	
}
