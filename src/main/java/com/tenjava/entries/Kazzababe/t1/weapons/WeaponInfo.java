package com.tenjava.entries.Kazzababe.t1.weapons;

public class WeaponInfo {
	protected static final WeaponInfo BASIC_SWORD = new WeaponInfo(1.0, 0.75, 1.0);
	
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
