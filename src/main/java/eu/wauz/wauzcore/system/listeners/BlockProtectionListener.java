package eu.wauz.wauzcore.system.listeners;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import eu.wauz.wauzcore.system.WauzRegion;

/**
 * A listener to catch events, related to damaging or modifying blocks.
 * 
 * @author Wauzmons
 */
public class BlockProtectionListener implements Listener {
	
	/**
	 * Prevents changes to protected regions.
	 * 
	 * @param event
	 * 
	 * @see WauzRegion#disallowBlockChange(Block)
	 */
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		for(Block block : new ArrayList<>(event.blockList())) {
			if(WauzRegion.disallowBlockChange(block)) {
				event.blockList().remove(block);
			}
		}
	}
	
	/**
	 * Prevents changes to protected regions.
	 * 
	 * @param event
	 * 
	 * @see WauzRegion#disallowBlockChange(Block)
	 */
	@EventHandler
	public void onBlockChangeExplode(BlockExplodeEvent event) {
		if(WauzRegion.disallowBlockChange(event.getBlock())) {
			event.setCancelled(true);
		}
	}
	
	/**
	 * Prevents changes to protected regions.
	 * 
	 * @param event
	 * 
	 * @see WauzRegion#disallowBlockChange(Block)
	 */
	@EventHandler
	public void onBlockChangeFade(BlockFadeEvent event) {
		if(WauzRegion.disallowBlockChange(event.getBlock())) {
			event.setCancelled(true);
		}
	}
	
	/**
	 * Prevents changes to protected regions.
	 * 
	 * @param event
	 * 
	 * @see WauzRegion#disallowBlockChange(Block)
	 */
	@EventHandler
	public void onBlockChangeFertilize(BlockFertilizeEvent event) {
		if(WauzRegion.disallowBlockChange(event.getBlock())) {
			event.setCancelled(true);
		}
	}
	
	/**
	 * Prevents changes to protected regions.
	 * 
	 * @param event
	 * 
	 * @see WauzRegion#disallowBlockChange(Block)
	 */
	@EventHandler
	public void onBlockChangeGrow(BlockGrowEvent event) {
		if(WauzRegion.disallowBlockChange(event.getBlock())) {
			event.setCancelled(true);
		}
	}
	
	/**
	 * Prevents changes to protected regions.
	 * 
	 * @param event
	 * 
	 * @see WauzRegion#disallowBlockChange(Block)
	 */
	@EventHandler
	public void onBlockChangeIgnite(BlockIgniteEvent event) {
		if(WauzRegion.disallowBlockChange(event.getBlock())) {
			event.setCancelled(true);
		}
	}
	
	/**
	 * Prevents changes to protected regions.
	 * 
	 * @param event
	 * 
	 * @see WauzRegion#disallowBlockChange(Block)
	 */
	@EventHandler
	public void onBlockChangePistonExtend(BlockPistonExtendEvent event) {
		if(WauzRegion.disallowBlockChange(event.getBlock())) {
			event.setCancelled(true);
		}
	}
	
	/**
	 * Prevents changes to protected regions.
	 * 
	 * @param event
	 * 
	 * @see WauzRegion#disallowBlockChange(Block)
	 */
	@EventHandler
	public void onBlockChangePistonRetract(BlockPistonRetractEvent event) {
		if(WauzRegion.disallowBlockChange(event.getBlock())) {
			event.setCancelled(true);
		}
	}

}
