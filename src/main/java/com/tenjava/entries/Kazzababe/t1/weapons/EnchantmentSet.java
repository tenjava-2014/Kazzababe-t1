package com.tenjava.entries.Kazzababe.t1.weapons;

import org.bukkit.enchantments.Enchantment;

public class EnchantmentSet {
	private Enchantment enchantment;
	private int level;
	
	public EnchantmentSet(Enchantment enchant, int level) {
		this.enchantment = enchant;
		this.level = level;
	}
	
	public Enchantment getEnchantment() {
		return this.enchantment;
	}
	
	public int getLevel() {
		return this.level;
	}
}
