package com.tenjava.entries.Kazzababe.t1.weapons;

import org.bukkit.ChatColor;

public enum WeaponType {
	COMMON(ChatColor.WHITE, 60), 
	UNCOMMON(ChatColor.LIGHT_PURPLE, 52), 
	RARE(ChatColor.RED, 40), 
	EPIC(ChatColor.GOLD, 30), 
	MIGHTY(ChatColor.AQUA, 16), 
	LEGENDARY(ChatColor.YELLOW, 5);
	
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
