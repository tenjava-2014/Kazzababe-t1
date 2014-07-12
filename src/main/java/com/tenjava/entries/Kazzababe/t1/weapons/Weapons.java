package com.tenjava.entries.Kazzababe.t1.weapons;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.tenjava.entries.Kazzababe.t1.TenJava;

public enum Weapons {
	TRAINING_SWORD("Training Sword", "The most basic of swords", Material.WOOD_SWORD, WeaponInfo.TRAINING_SWORD, ResourceSet.TRAINING_SWORD, WeaponType.COMMON), 
	SHORT_SWORD("Short Sword", "Short Sword", Material.IRON_SWORD, WeaponInfo.SHORT_SWORD, ResourceSet.SHORT_SWORD, WeaponType.COMMON), 
	LONG_SWORD("Long Sword", "Long Sword", Material.IRON_SWORD, WeaponInfo.LONG_SWORD, ResourceSet.LONG_SWORD, WeaponType.COMMON), 
	MIGHTY_SWORD("Mighty Sword", "The mighty sword of a fallen king", Material.GOLD_SWORD, WeaponInfo.MIGHTY_SWORD, ResourceSet.MIGHTY_SWORD, WeaponType.RARE), 
	ADVENTURE_SWORD("Adventureres Sword", "A must have sword for any adventurer", Material.DIAMOND_SWORD, WeaponInfo.ADVENTURE_SWORD, ResourceSet.ADVENTURE_SWORD, WeaponType.COMMON), 
	MINECRAFTIA_SWORD("Sword o' Minecraftia", "The legendary sword of Minecraftia", Material.DIAMOND_SWORD, WeaponInfo.MINECRAFTIA_SWORD, ResourceSet.MINECRAFTIA_SWORD, WeaponType.LEGENDARY);
	
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
		itemMeta.setLore(Arrays.asList("Deals " + this.info.getDamage() + " damage"));
		item.setItemMeta(itemMeta);
		
		item.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
		
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
			if(TenJava.areItemsSimilar(weapon.getItemStack(), item)) {
				return weapon;
			}
		}
		return null;
	}
}
