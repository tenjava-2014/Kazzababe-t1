package com.tenjava.entries.Kazzababe.t1.weapons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public enum ResourceSet {
	TRAINING_SWORD(new ItemStack(Material.STICK, 10), new ItemStack(Material.WOOD, 15), null), 
	SHORT_SWORD(new ItemStack(Material.STICK, 20), new ItemStack(Material.IRON_INGOT, 20), null), 
	STONE_SWORD(new ItemStack(Material.STICK, 20), new ItemStack(Material.COBBLE_WALL, 60), null), 
	LONG_SWORD(new ItemStack(Material.STICK, 22), new ItemStack(Material.IRON_INGOT, 28), null), 
	MIGHTY_SWORD(new ItemStack(Material.STICK, 25), new ItemStack(Material.GOLD_INGOT, 22), null), 
	ADVENTURE_SWORD(new ItemStack(Material.STICK, 20), new ItemStack(Material.DIAMOND, 8), null), 
	WORN_AXE(new ItemStack(Material.STICK, 10), new ItemStack(Material.WOOD, 20), null), 
	HEAVY_AXE(new ItemStack(Material.STICK, 18), new ItemStack(Material.COBBLESTONE, 50), null), 
	GOLDEN_AXE(new ItemStack(Material.STICK, 28), new ItemStack(Material.GOLD_INGOT, 35), null), 
	FIERY_SWORD(new ItemStack(Material.STICK, 25), new ItemStack(Material.GOLD_INGOT, 25), new ItemStack(Material.BLAZE_ROD, 3)), 
	DEFEND_SWORD(new ItemStack(Material.STICK, 32), new ItemStack(Material.DIAMOND_BLOCK, 3), new ItemStack(Material.OBSIDIAN, 3)), 
	BARBARIAN_AXE(new ItemStack(Material.STICK, 85), new ItemStack(Material.DIAMOND, 31), new ItemStack(Material.NETHER_STAR)), 
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
