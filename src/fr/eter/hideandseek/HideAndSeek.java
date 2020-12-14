package fr.eter.hideandseek;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.hideandseek.GStates;

public class HideAndSeek extends JavaPlugin {

	/**
	 * List of player
	 */
	private List<Player> players = new ArrayList<Player>();
	/**
	 * Player marked as the hunter
	 */
	private Player hunter = null;
	/**
	 * Game states
	 */
	private GStates states;
	
	/**
	 * On function
	 */
	@Override
	public void onEnable() {
		/* Console log to check if the plugin is loaded. */
		System.out.println(this.getName() + " on!");
	}

	/**
	 * Off function
	 */
	@Override
	public void onDisable() {
		/* Console log to check if the plugin is loaded. */
		System.out.println(this.getName() + " off!");
	}
	
	/**
	 * Set a new state to the game
	 * 
	 * @param states	States contained by GStates enum
	 */
	public void setState(GStates states) {
		this.states = states;
	}
	
	/**
	 * Compare the two states
	 * 
	 * @param states	States which need to be check
	 * @return	boolean type : true/false
	 */
	public boolean isState(GStates states) {
		return this.states == states;
	}
	
	
	/**
	 * Getter Method
	 * 
	 * Return a specific player from the list
	 * @param player
	 * @return
	 */
	public Player getPlayer(Player player) {
		return players.get(players.indexOf(player));
	}
	
	/**
	 * Check if the player is inside the list
	 * @param player
	 * @return
	 */
	public boolean isPlayerInTheList(Player player) {
		return (players.contains(player));
	}
	/**
	 * Getter Method
	 * Get the whole list of players
	 * 
	 * @return
	 */
	public List<Player> getPlayerList() {
		return (players);
	}
	
	/**
	 * Setter method
	 * 
	 * Set a player into the list
	 * @param player
	 */
	public void setPlayerInList(Player player) {
		players.add(player);
	}
	
	/**
	 * Getter method
	 * 
	 * Get the hunter
	 * @return
	 */
	public Player getHunter() {
		return hunter;
	}
	
	/**
	 * Setter method
	 * 
	 * Set the hunter
	 * @param player
	 */
	public void setHunter(Player player) {
		hunter = player;
	}
}
