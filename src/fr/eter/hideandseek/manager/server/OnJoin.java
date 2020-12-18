package fr.eter.hideandseek.manager.server;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.eter.hideandseek.HideAndSeek;
import fr.eter.hideandseek.manager.task.GAutoStart;
import fr.eter.hideandseek.utils.PlayerManager;
import fr.eter.hideandseek.utils.StateManager;
import fr.eter.hideandseek.GStates;

public class OnJoin implements Listener {

	private HideAndSeek main;
	
	public OnJoin(HideAndSeek main) {
		this.main = main;
	}
	
	/**
	 * onJoin event function, triggered when someone join the server
	 * 
	 * @param e	Event triggered
	 */
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		player.sendTitle("Welcome", "Hide And Seek made by EternalRat", 10, 80, 20);
		Location spawn = new Location(player.getWorld(), 25.0, 5, 25.0);
		player.teleport(spawn);
		player.getInventory().clear();
		
		if (!StateManager.isState(GStates.WAITING)) {
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage("The game already started.");
			e.setJoinMessage(null);
			return;
		}
		
		if (!PlayerManager.isPlayerInTheList(player)) PlayerManager.setPlayerInList(player);
		Bukkit.broadcastMessage("§7[§cHIDE AND SEEK MINECRAFT VERSION§7]§r " + player.getName() + " has joined the game.");
		if (StateManager.isState(GStates.WAITING) && PlayerManager.getPlayerList().size() >= 10) {
			GAutoStart start = new GAutoStart(this.main);
			start.runTaskTimer(this.main, 0, 20);
			StateManager.setState(GStates.LAUNCH);
		}
	}

}
