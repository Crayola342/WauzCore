package eu.wauz.wauzcore.items;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import eu.wauz.wauzcore.WauzCore;
import eu.wauz.wauzcore.players.WauzPlayerData;
import eu.wauz.wauzcore.players.WauzPlayerDataPool;
import eu.wauz.wauzcore.players.calc.DamageCalculator;
import eu.wauz.wauzcore.players.calc.ExperienceCalculator;
import eu.wauz.wauzcore.system.util.WauzMode;

/**
 * A class to serialize and deserialize player inventories, including stats, to a character file.
 * 
 * @author Wauzmons
 */
public class InventoryStringConverter {

	/**
	 * A direct reference to the main class.
	 */
	private static WauzCore core = WauzCore.getInstance();
    
	/**
	 * Serializes the player inventory and current stats to the selected character config.
	 * Includes last played time, health, mana, level, pvp resistance and saturation.
	 * 
	 * @param player The player whose inventory should be serialized.
	 * 
	 * @see WauzPlayerData#getSelectedCharacterSlot()
	 */
    public static void saveInventory(Player player) {
    	File playerDirectory = new File(core.getDataFolder(), "PlayerData/" + player.getUniqueId() + "/");
		File playerDataFile = new File(playerDirectory, WauzPlayerDataPool.getPlayer(player).getSelectedCharacterSlot() + ".yml");
		FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
		
		WauzPlayerData playerData = WauzPlayerDataPool.getPlayer(player);
		
		playerDataConfig.set("lastplayed", System.currentTimeMillis());
		
		if(WauzMode.isMMORPG(player)) {
			playerDataConfig.set("stats.current.health", playerData.getHealth());
			playerDataConfig.set("stats.current.mana", playerData.getMana());
		}
		else {
			playerDataConfig.set("stats.current.health", player.getHealth());
			playerDataConfig.set("level", player.getLevel());
			playerDataConfig.set("reput.exp", player.getExp() * 100F);
			playerDataConfig.set("pvp.resticks", playerData.getResistancePvP());
		}
		playerDataConfig.set("stats.current.hunger", player.getFoodLevel());
		playerDataConfig.set("stats.current.saturation", player.getSaturation());
		
		playerDataConfig.set("inventory.items", player.getInventory().getContents());
		playerDataConfig.set("inventory.armor", player.getInventory().getArmorContents());
		
		try {
			playerDataConfig.save(playerDataFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
	 * Deserializes the player inventory and current stats to the selected character config.
	 * Includes health, mana, level, pvp resistance and saturation.
	 * 
	 * @param player The player whose inventory should be deserialized.
	 * 
	 * @see WauzPlayerData#getSelectedCharacterSlot()
	 */
    public static void loadInventory(Player player) {
    	File playerDirectory = new File(core.getDataFolder(), "PlayerData/" + player.getUniqueId() + "/");
		File playerDataFile = new File(playerDirectory, WauzPlayerDataPool.getPlayer(player).getSelectedCharacterSlot() + ".yml");
		FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
    	
    	WauzPlayerData playerData = WauzPlayerDataPool.getPlayer(player);
    	
    	if(WauzMode.isMMORPG(player)) {
    		DamageCalculator.setHealth(player, playerDataConfig.getInt("stats.current.health"));
    		playerData.setMana(playerDataConfig.getInt("stats.current.mana"));
    	}
    	else {
    		player.setHealth(playerDataConfig.getInt("stats.current.health"));
    		playerData.setResistancePvP((short) playerDataConfig.getInt("pvp.resticks"));
    	}
    	player.setLevel(playerDataConfig.getInt("level"));
    	ExperienceCalculator.updateExperienceBar(player);
    	player.setFoodLevel(playerDataConfig.getInt("stats.current.hunger"));
    	player.setSaturation((float) playerDataConfig.getDouble("stats.current.saturation"));
    	
    	ItemStack[] items = playerDataConfig.getList("inventory.items").toArray(new ItemStack[0]);
    	player.getInventory().setContents(items);
    	
    	ItemStack[] armor = playerDataConfig.getList("inventory.armor").toArray(new ItemStack[0]);
    	player.getInventory().setArmorContents(armor);
    }
    
}