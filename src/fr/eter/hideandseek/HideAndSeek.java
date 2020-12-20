package fr.eter.hideandseek;

import org.bukkit.plugin.java.JavaPlugin;

import fr.eter.hideandseek.manager.EventManager;
import fr.eter.hideandseek.utils.StateManager;

public class HideAndSeek extends JavaPlugin {

	private JavaPlugin instance;
	
	/**
	 * On function
	 */
	@Override
	public void onEnable() {
		instance = this;
		System.out.println(this.getName() + " on!");
		StateManager.setState(GStates.WAITING);
		EventManager evtManager = new EventManager();
		evtManager.ListenerManager(this, instance);
	}

	/**
	 * Off function
	 */
	@Override
	public void onDisable() {
		System.out.println(this.getName() + " off!");
	}
}
