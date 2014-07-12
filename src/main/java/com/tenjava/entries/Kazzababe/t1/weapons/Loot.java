package com.tenjava.entries.Kazzababe.t1.weapons;

import java.util.Random;

import org.bukkit.inventory.ItemStack;

public class Loot {
	private ItemStack item;
	
	private int min;
	private int max;
	
	private double weight;
	
	public Loot(ItemStack item, int min, int max, double weight) {
		this.item = item;
		
		this.min = min;
		this.max = max;
		
		this.weight = weight;
	}
	
	public ItemStack getItem() {
		return this.item;
	}
	
	public ItemStack getRandomItem() {
		ItemStack item = this.item.clone();
		
		Random random = new Random();
		item.setAmount(random.nextInt(this.max - this.min + 1) + this.min);
		
		return item;
	}
	
	public double getWeight() {
		return this.weight;
	}
}
