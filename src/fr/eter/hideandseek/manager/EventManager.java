package fr.eter.hideandseek.manager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.hideandseek.HideAndSeek;
import fr.eter.hideandseek.manager.server.OnBreak;
import fr.eter.hideandseek.manager.server.OnJoin;
import fr.eter.hideandseek.manager.server.OnLeave;
import fr.eter.hideandseek.manager.server.OnMovement;

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
		
		/* Leave event done by using a Listener */
		Listener leaveEvent = new OnLeave();
		PluginManager leaveEventPM = getServer().getPluginManager();
		leaveEventPM.registerEvents(leaveEvent, this.main);
		
		Listener moveEvent = new OnMovement();
		PluginManager moveEventPM = getServer().getPluginManager();
		moveEventPM.registerEvents(moveEvent, this.main);
		
		Listener onBreak = new OnBreak();
		PluginManager onBreakPM = getServer().getPluginManager();
		onBreakPM.registerEvents(onBreak, this.main);
	}
}
