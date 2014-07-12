package com.tenjava.entries.Kazzababe.t1.weapons;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Weapons {
	BASIC_SWORD("Basic Sword", "The most basic of swords", Material.WOOD_SWORD, WeaponInfo.BASIC_SWORD, WeaponType.COMMON);
	
	private String name;
	private String description;
	
	private Material material;
	private WeaponInfo info;
	private WeaponType type;
	
	private Weapons(String name, String description, Material material, WeaponInfo info, WeaponType type) {
		this.name = name;
		this.description = description;
		
		this.material = material;
		this.info = info;
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
		itemMeta.setDisplayName(this.type.getClass() + this.name);
		itemMeta.setLore(Arrays.asList(this.description));
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public WeaponInfo getWeaponInfo() {
		return this.info;
	}
	
	public WeaponType getWeaponType() {
		return this.type;
	}
}
