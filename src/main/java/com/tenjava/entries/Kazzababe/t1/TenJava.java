package com.tenjava.entries.Kazzababe.t1;

import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.Kazzababe.t1.listeners.DamageListeners;
import com.tenjava.entries.Kazzababe.t1.listeners.PlayerInteractListeners;

public class TenJava extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new PlayerInteractListeners(), this);
		this.getServer().getPluginManager().registerEvents(new DamageListeners(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
