package fr.eter.hideandseek.manager.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OnBreak implements Listener {

	@EventHandler
	public void onBreakBlocks(BlockBreakEvent block) {
		block.setCancelled(true);
	}
	
}