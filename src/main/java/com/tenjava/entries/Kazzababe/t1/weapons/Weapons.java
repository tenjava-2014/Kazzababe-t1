package com.tenjava.entries.Kazzababe.t1.weapons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.tenjava.entries.Kazzababe.t1.TenJava;

public enum Weapons {
	TRAINING_SWORD("Training Sword", "The most basic of swords", Material.WOOD_SWORD, WeaponInfo.TRAINING_SWORD, ResourceSet.TRAINING_SWORD, WeaponType.COMMON), 
	SHORT_SWORD("Short Sword", "Short Sword", Material.IRON_SWORD, WeaponInfo.SHORT_SWORD, ResourceSet.SHORT_SWORD, WeaponType.COMMON), 
	STONE_SWORD("Stone Sword", "A sword crafted from stone", Material.STONE_SWORD, WeaponInfo.STONE_SWORD, ResourceSet.STONE_SWORD, WeaponType.COMMON), 
	LONG_SWORD("Long Sword", "Long Sword", Material.IRON_SWORD, WeaponInfo.LONG_SWORD, ResourceSet.LONG_SWORD, WeaponType.COMMON), 
	MIGHTY_SWORD("Mighty Sword", "The mighty sword of a fallen king", Material.GOLD_SWORD, WeaponInfo.MIGHTY_SWORD, ResourceSet.MIGHTY_SWORD, WeaponType.MIGHTY), 
	FIERY_SWORD("Fiery Sword", "A sword for those who like to watch the world burn", Material.GOLD_SWORD, WeaponInfo.FIERY_SWORD, ResourceSet.FIERY_SWORD, WeaponType.RARE, new EnchantmentSet(Enchantment.FIRE_ASPECT, 1)), 
	ADVENTURE_SWORD("Adventurers Sword", "A must have sword for any adventurer", Material.DIAMOND_SWORD, WeaponInfo.ADVENTURE_SWORD, ResourceSet.ADVENTURE_SWORD, WeaponType.EPIC), 
	DEFEND_SWORD("Defenders Sword", "Knockback your opponenents and maintain a strong defense", Material.DIAMOND_SWORD, WeaponInfo.DEFEND_SWORD, ResourceSet.DEFEND_SWORD, WeaponType.EPIC, new EnchantmentSet(Enchantment.KNOCKBACK, 3)), 
	MINECRAFTIA_SWORD("Sword o' Minecraftia", "The legendary sword of Minecraftia", Material.DIAMOND_SWORD, WeaponInfo.MINECRAFTIA_SWORD, ResourceSet.MINECRAFTIA_SWORD, WeaponType.LEGENDARY), 
	WORN_AXE("Worn Battleaxe", "A weak wooden battle axe", Material.WOOD_AXE, WeaponInfo.WORN_AXE, ResourceSet.WORN_AXE, WeaponType.COMMON), 
	HEAVY_AXE("Heavy Battleaxe", "A heavy stone battle axe", Material.STONE_AXE, WeaponInfo.HEAVY_AXE, ResourceSet.HEAVY_AXE, WeaponType.COMMON), 
	GOLDEN_AXE("Golden Crusher", "A strong golden axe", Material.GOLD_AXE, WeaponInfo.GOLDEN_AXE, ResourceSet.GOLDEN_AXE, WeaponType.UNCOMMON), 
	BARBARIAN_AXE("Barbarian Axe", "The axe of a brave barbarian", Material.DIAMOND_AXE, WeaponInfo.BARBARIAN_AXE, ResourceSet.BARBARIAN_AXE, WeaponType.LEGENDARY);
	
	private String name;
	private String description;
	
	private Material material;
	private WeaponInfo info;
	private ResourceSet resources;
	private WeaponType type;
	
	private EnchantmentSet[] enchants;
	
	private Weapons(String name, String description, Material material, WeaponInfo info, ResourceSet resources, WeaponType type, EnchantmentSet... enchants) {
		this.name = name;
		this.description = description;
		
		this.material = material;
		this.info = info;
		this.resources = resources;
		this.type = type;
		
		this.enchants = enchants;
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
		for(EnchantmentSet enchant : this.enchants) {
			item.addUnsafeEnchantment(enchant.getEnchantment(), enchant.getLevel());
		}
		
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
	
	public static List<Loot> generateLootTable() {
		List<Loot> table = new ArrayList<Loot>();
		for(Weapons weapon : values()) {
			Loot loot = new Loot(weapon.getItemStack(), 1, 1, weapon.getWeaponType().getWeight());
			table.add(loot);
		}
		return table;
	}
}
