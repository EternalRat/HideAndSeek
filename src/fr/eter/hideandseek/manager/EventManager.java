package fr.eter.hideandseek.manager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.hideandseek.HideAndSeek;
import fr.eter.hideandseek.manager.server.OnBreak;
import fr.eter.hideandseek.manager.server.OnInteract;
import fr.eter.hideandseek.manager.server.OnInv;
import fr.eter.hideandseek.manager.server.OnJoin;
import fr.eter.hideandseek.manager.server.OnLeave;
import fr.eter.hideandseek.manager.server.OnMovement;

public class EventManager {
	
	/**
	 * Listener manager
	 */
	public void ListenerManager(HideAndSeek main, JavaPlugin instance) {
		Listener joinEvent = new OnJoin(main);
		PluginManager joinEventPM = instance.getServer().getPluginManager();
		joinEventPM.registerEvents(joinEvent, main);
		
		Listener leaveEvent = new OnLeave();
		PluginManager leaveEventPM = instance.getServer().getPluginManager();
		leaveEventPM.registerEvents(leaveEvent, main);
		
		Listener moveEvent = new OnMovement();
		PluginManager moveEventPM = instance.getServer().getPluginManager();
		moveEventPM.registerEvents(moveEvent, main);
		
		Listener onBreak = new OnBreak();
		PluginManager onBreakPM = instance.getServer().getPluginManager();
		onBreakPM.registerEvents(onBreak, main);
		
		Listener onInteract = new OnInteract();
		PluginManager onInteractPM = instance.getServer().getPluginManager();
		onInteractPM.registerEvents(onInteract, main);
		
		Listener onInv = new OnInv();
		PluginManager onInvPM = instance.getServer().getPluginManager();
		onInvPM.registerEvents(onInv, main);
	}
}
