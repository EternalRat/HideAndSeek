package fr.eter.hideandseek.utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerMoving extends JavaPlugin {
	
	private static Map<Player, Long> moveTimer = new HashMap<Player, Long>();
	
	/**
	 * Get the timer for the specified player
	 * @param player
	 * @return
	 */
	public static Long getTimer(Player player) {
		return (moveTimer.get(player));
	}
	
	/**
	 * Check if the player is in the list
	 * @param player
	 * @return
	 */
	public static boolean isInList(Player player) {
		return moveTimer.containsKey(player);
	}
	
	/**
	 * Create the timer
	 * @param player
	 * @param timer
	 */
	public static void setTimer(Player player, Long timer) {
		moveTimer.put(player, timer);
	}
	
	/**
	 * Replace the timer
	 * @param player
	 * @param timer
	 */
	public static void replaceTimer(Player player, Long timer) {
		moveTimer.replace(player, timer);
	}
}
