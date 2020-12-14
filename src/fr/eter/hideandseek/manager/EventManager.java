package fr.eter.hideandseek.manager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.hideandseek.HideAndSeek;
import fr.eter.hideandseek.manager.server.OnJoin;

public class EventManager extends JavaPlugin {
	/**
	 * main for constructor
	 */
	private HideAndSeek main;
	
	/**
	 * Constructor for manager class
	 * 
	 * @param main
	 */
	public EventManager(HideAndSeek main) {
		this.main = main;
	}
	
	/**
	 * Listener manager
	 */
	public void ListenerManager() {
		/* Join event done by using a Listener */
		Listener joinEvent = new OnJoin(this.main);
		PluginManager joinEventPM = getServer().getPluginManager();
		joinEventPM.registerEvents(joinEvent, this.main);
	}
}
