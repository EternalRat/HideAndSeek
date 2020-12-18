package fr.eter.hideandseek;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.hideandseek.manager.EventManager;
import fr.eter.hideandseek.manager.server.OnBreak;
import fr.eter.hideandseek.manager.server.OnJoin;
import fr.eter.hideandseek.manager.server.OnLeave;
import fr.eter.hideandseek.manager.server.OnMovement;
import fr.eter.hideandseek.utils.StateManager;

public class HideAndSeek extends JavaPlugin {
	
	public static JavaPlugin instance;
	
	/**
	 * On function
	 */
	@Override
	public void onEnable() {
		instance = this;
		System.out.println(this.getName() + " on!");
		StateManager.setState(GStates.WAITING);
		/*EventManager eventManager = new EventManager(instance);
		eventManager.ListenerManager();*/
		/* Join event done by using a Listener */
		Listener joinEvent = new OnJoin(this);
		PluginManager joinEventPM = getServer().getPluginManager();
		joinEventPM.registerEvents(joinEvent, this);
		
		/* Leave event done by using a Listener */
		Listener leaveEvent = new OnLeave();
		PluginManager leaveEventPM = getServer().getPluginManager();
		leaveEventPM.registerEvents(leaveEvent, this);
		
		Listener moveEvent = new OnMovement();
		PluginManager moveEventPM = getServer().getPluginManager();
		moveEventPM.registerEvents(moveEvent, this);
		
		Listener onBreak = new OnBreak();
		PluginManager onBreakPM = getServer().getPluginManager();
		onBreakPM.registerEvents(onBreak, this);
	}

	/**
	 * Off function
	 */
	@Override
	public void onDisable() {
		System.out.println(this.getName() + " off!");
	}
}
