package fr.eter.hideandseek.manager;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.hideandseek.HideAndSeek;
import fr.eter.hideandseek.manager.server.interaction.OnInteract;
import fr.eter.hideandseek.manager.server.interaction.OnInv;
import fr.eter.hideandseek.manager.server.members.OnJoin;
import fr.eter.hideandseek.manager.server.members.OnLeave;
import fr.eter.hideandseek.manager.server.members.OnMovement;
import fr.eter.hideandseek.manager.server.object.OnBreak;

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
