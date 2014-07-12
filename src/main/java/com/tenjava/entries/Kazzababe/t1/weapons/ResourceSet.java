package com.tenjava.entries.Kazzababe.t1.weapons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public enum ResourceSet {
	TRAINING_SWORD(new ItemStack(Material.STICK, 10), new ItemStack(Material.WOOD, 15), null), 
	SHORT_SWORD(new ItemStack(Material.STICK, 20), new ItemStack(Material.IRON_INGOT, 20), null), 
	LONG_SWORD(new ItemStack(Material.STICK, 22), new ItemStack(Material.IRON_INGOT, 28), null), 
	MINECRAFTIA_SWORD(new ItemStack(Material.STICK, 80), new ItemStack(Material.DIAMOND, 32), new ItemStack(Material.NETHER_STAR));
	
	private ItemStack item1;
	private ItemStack item2;
	private ItemStack item3;
	
	private ResourceSet(ItemStack item1, ItemStack item2, ItemStack item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
	public ItemStack getItem1() {
		return this.item1;
	}
	
	public ItemStack getItem2() {
		return this.item2;
	}
	
	public ItemStack getItem3() {
		return this.item3;
	}
}
