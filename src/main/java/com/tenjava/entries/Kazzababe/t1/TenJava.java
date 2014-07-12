package com.tenjava.entries.Kazzababe.t1;

import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.Kazzababe.t1.listeners.DamageListeners;
import com.tenjava.entries.Kazzababe.t1.listeners.PlayerInteractListeners;
import com.tenjava.entries.Kazzababe.t1.weapons.Loot;

public class TenJava extends JavaPlugin {
	/*
	 * TODO: Add more weapons
	 * TODO: Create an easier way to get anvils
	 * TODO: Make mobs stronger
	 */
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new PlayerInteractListeners(), this);
		this.getServer().getPluginManager().registerEvents(new DamageListeners(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static boolean areItemsSimilar(ItemStack item1, ItemStack item2) {
		if ((item1 == null) || (item2 == null)) {
			return false;
		}
		ItemStack itemOne = item1.clone();
		ItemStack itemTwo = item2.clone();
		
		itemOne.setAmount(1);
		itemTwo.setAmount(1);
		
		itemOne.setDurability(item2.getDurability());
		
		return itemOne.equals(itemTwo);
	}
	
	public static Loot getRandomItemFromLootTable(List<Loot> lootTable) {
		double totalWeight = 0;
		for(Loot loot : lootTable) {
			totalWeight += loot.getWeight();
		}
		
		double threshold = Math.random() * totalWeight;
		double currentWeight = 0;
		
		for(Loot loot : lootTable) {
			currentWeight += loot.getWeight();
			if(currentWeight >= threshold) {
				return loot;
			}
		}
		return null;
	}
}
