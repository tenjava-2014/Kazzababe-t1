package com.tenjava.entries.Kazzababe.t1;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.Kazzababe.t1.listeners.DamageListeners;
import com.tenjava.entries.Kazzababe.t1.listeners.PlayerInteractListeners;

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
}
