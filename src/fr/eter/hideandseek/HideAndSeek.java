package fr.eter.hideandseek;

import org.bukkit.plugin.java.JavaPlugin;

public class HideAndSeek extends JavaPlugin {
	
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
}
