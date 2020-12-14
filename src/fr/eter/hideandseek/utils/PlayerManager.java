package fr.eter.hideandseek.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class PlayerManager {

	/**
	 * List of player
	 */
	private static List<Player> players = new ArrayList<Player>();
	/**
	 * Player marked as the hunter
	 */
	private static Player hunter = null;
	
	/**
	 * Getter Method
	 * 
	 * Return a specific player from the list
	 * @param player
	 * @return
	 */
	public static Player getPlayer(Player player) {
		return players.get(players.indexOf(player));
	}
	
	/**
	 * Check if the player is inside the list
	 * @param player
	 * @return
	 */
	public static boolean isPlayerInTheList(Player player) {
		return (players.contains(player));
	}
	/**
	 * Getter Method
	 * Get the whole list of players
	 * 
	 * @return
	 */
	public static List<Player> getPlayerList() {
		return (players);
	}
	
	/**
	 * Setter method
	 * 
	 * Set a player into the list
	 * @param player
	 */
	public static void setPlayerInList(Player player) {
		players.add(player);
	}
	
	/**
	 * Getter method
	 * 
	 * Get the hunter
	 * @return
	 */
	public static Player getHunter() {
		return hunter;
	}
	
	/**
	 * Setter method
	 * 
	 * Set the hunter
	 * @param player
	 */
	public static void setHunter(Player player) {
		hunter = player;
	}
}
