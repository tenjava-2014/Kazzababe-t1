package com.tenjava.entries.Kazzababe.t1.weapons;

public class WeaponInfo {
	protected static final WeaponInfo TRAINING_SWORD = new WeaponInfo(1.0, 0.75, 1.0);
	protected static final WeaponInfo SHORT_SWORD = new WeaponInfo(2.5, 0.90, 1.15);
	protected static final WeaponInfo LONG_SWORD = new WeaponInfo(4, 0.8, 1.5);
	protected static final WeaponInfo MINECRAFTIA_SWORD = new WeaponInfo(22, 0.8, 1.5);
	protected static final WeaponInfo MIGHTY_SWORD = new WeaponInfo(7.5, 1.0, 1.35);
	protected static final WeaponInfo ADVENTURE_SWORD = new WeaponInfo(8.0, 1.25, 1.4);
	
	private double damage;
	private double swingSpeed;
	private double armorPenetration;
	
	protected WeaponInfo(double damage, double swingSpeed, double armorPenetration) {
		this.damage = damage;
		this.swingSpeed = swingSpeed;
		this.armorPenetration = armorPenetration;
	}
	
	public double getDamage() {
		return this.damage;
	}
	
	public double getSwingSpeed() {
		return this.swingSpeed;
	}
	
	public double getArmorPenetration() {
		return this.armorPenetration;
	}
}
