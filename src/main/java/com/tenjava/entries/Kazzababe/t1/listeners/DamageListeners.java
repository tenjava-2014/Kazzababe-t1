package com.tenjava.entries.Kazzababe.t1.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.tenjava.entries.Kazzababe.t1.weapons.Weapons;

public class DamageListeners implements Listener {

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		Entity entity = event.getDamager();
		if(entity instanceof Player) {
			Player player = (Player) entity;
			
			ItemStack item = player.getItemInHand();
			if(item != null) {
				Weapons weapon = Weapons.getFromItemStack(item);
				if(weapon != null) {
					event.setDamage(weapon.getWeaponInfo().getDamage());
				} else {
					player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 35, 1));
				}
			} else {
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 35, 1));
			}
		}
	}
}
