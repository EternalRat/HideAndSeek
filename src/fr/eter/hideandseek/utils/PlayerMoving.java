package fr.eter.hideandseek.utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerMoving extends JavaPlugin {
	
	private Map<Player, Integer> moveTimer = new HashMap<Player, Integer>();
	
	public Integer getTimer(Player player) {
		return (moveTimer.get(player));
	}
	
	public void setTimer(Player player, Integer timer) {
		moveTimer.put(player, timer);
	}
}
