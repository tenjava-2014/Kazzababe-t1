package com.tenjava.entries.Kazzababe.t1.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

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
				}
			}
		}
	}
}
