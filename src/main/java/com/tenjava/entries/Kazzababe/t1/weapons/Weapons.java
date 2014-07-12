package com.tenjava.entries.Kazzababe.t1.weapons;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Weapons {
	TRAINING_SWORD("Training Sword", "The most basic of swords", Material.WOOD_SWORD, WeaponInfo.TRAINING_SWORD, ResourceSet.TRAINING_SWORD, WeaponType.COMMON), 
	SHORT_SWORD("Short Sword", "Short Sword", Material.IRON_SWORD, WeaponInfo.SHORT_SWORD, ResourceSet.SHORT_SWORD, WeaponType.COMMON);
	
	private String name;
	private String description;
	
	private Material material;
	private WeaponInfo info;
	private ResourceSet resources;
	private WeaponType type;
	
	private Weapons(String name, String description, Material material, WeaponInfo info, ResourceSet resources, WeaponType type) {
		this.name = name;
		this.description = description;
		
		this.material = material;
		this.info = info;
		this.resources = resources;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Material getMaterial() {
		return this.material;
	}
	
	public ItemStack getItemStack() {
		ItemStack item = new ItemStack(this.material);
		
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(this.type.getColor() + this.name);
		itemMeta.setLore(Arrays.asList(this.description));
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public WeaponInfo getWeaponInfo() {
		return this.info;
	}
	
	public ResourceSet getResources() {
		return this.resources;
	}
	
	public WeaponType getWeaponType() {
		return this.type;
	}
	
	public static Weapons getFromItemStack(ItemStack item) {
		for(Weapons weapon : values()) {
			if(weapon.getItemStack().equals(item)) {
				return weapon;
			}
		}
		return null;
	}
}
