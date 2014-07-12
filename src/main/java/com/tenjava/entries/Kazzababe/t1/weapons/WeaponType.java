package com.tenjava.entries.Kazzababe.t1.weapons;

import org.bukkit.ChatColor;

public enum WeaponType {
	COMMON(ChatColor.WHITE), 
	RARE(ChatColor.RED), 
	LEGENDARY(ChatColor.YELLOW);
	
	private ChatColor color;
	
	private WeaponType(ChatColor color) {
		this.color = color;
	}
	
	public ChatColor getColor() {
		return this.color;
	}
}
