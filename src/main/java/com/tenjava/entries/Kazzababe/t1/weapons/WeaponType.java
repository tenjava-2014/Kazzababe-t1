package com.tenjava.entries.Kazzababe.t1.weapons;

import org.bukkit.ChatColor;

public enum WeaponType {
	COMMON(ChatColor.WHITE, 80), 
	UNCOMMON(ChatColor.LIGHT_PURPLE, 65), 
	RARE(ChatColor.RED, 50), 
	EPIC(ChatColor.GOLD, 40), 
	MIGHTY(ChatColor.AQUA, 25), 
	LEGENDARY(ChatColor.YELLOW, 2);
	
	private ChatColor color;
	private int weight;
	
	private WeaponType(ChatColor color, int weight) {
		this.color = color;
		this.weight = weight;
	}
	
	public ChatColor getColor() {
		return this.color;
	}
	
	public int getWeight() {
		return this.weight;
	}
}
