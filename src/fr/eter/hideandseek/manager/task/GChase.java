package fr.eter.hideandseek.manager.task;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eter.hideandseek.GStates;
import fr.eter.hideandseek.utils.PlayerManager;
import fr.eter.hideandseek.utils.StateManager;

public class GChase extends BukkitRunnable {

	private int timer = 600;
	public GChase() {
	}

	@Override
	public void run() {
		if (timer != 0 && PlayerManager.getPlayerList().size() == 1) {
			Bukkit.broadcastMessage("The hunter has win!");
			StateManager.setState(GStates.END);
			cancel();
		}
		if (timer == 30 || timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1)
			Bukkit.broadcastMessage("The game will end in " + timer + "s.");
		if (timer == 0) {
			if (PlayerManager.getPlayerList().size() >= 2) {
				Bukkit.broadcastMessage("Ghosts won!");
			}
			StateManager.setState(GStates.END);
			cancel();
		}
		timer--;
	}
}
