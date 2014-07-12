package com.tenjava.entries.Kazzababe.t1.listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.tenjava.entries.Kazzababe.t1.weapons.Weapons;

public class PlayerInteractListeners implements Listener {
	private Map<UUID, Inventory> anvilInventories = new HashMap<UUID, Inventory>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Action action = event.getAction();
		
		if(action == Action.RIGHT_CLICK_BLOCK) {
			Block block = event.getClickedBlock();
			if(block.getType() == Material.ANVIL) {
				//Open a custom anvil GUI
				event.setCancelled(true);
				
				Player player = event.getPlayer();
				UUID id = player.getUniqueId();
				
				this.anvilInventories.put(id, this.generateNewAnvilInventory());
				Inventory inventory = this.anvilInventories.get(id);
				
				this.updatePage(player);
				
				player.openInventory(inventory);
			}
		} else if(action == Action.LEFT_CLICK_BLOCK) {
			if(event.getItem() != null) {
				Weapons weapon = Weapons.getFromItemStack(event.getItem());
				if(weapon != null) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		HumanEntity human = event.getWhoClicked();
		if(human instanceof Player) {
			Player player = (Player) human;
			UUID id = player.getUniqueId();
			
			if(this.anvilInventories.containsKey(id)) {
				Inventory inventory = this.anvilInventories.get(id);
				if(event.getInventory().equals(inventory)) {
					ItemStack currentItem = event.getCurrentItem();
					
					int slot = event.getRawSlot();
					if((slot >= 10 && slot <= 15) || (slot >= 19 && slot <= 24)) {
						if(currentItem.getType() != Material.AIR) {
							inventory.setItem(37, currentItem.clone());
							Weapons weapon = Weapons.getFromItemStack(currentItem);
							
							this.updateResourcesSet(player, weapon);
						} else {
							inventory.setItem(37, null);
							inventory.setItem(39, null);
							inventory.setItem(40, null);
							inventory.setItem(41, null);
						}
					} else if(slot == 43) {
						int have = 0;
						int needed = 0;
						
						ItemStack toCraft = inventory.getItem(37);
						if(toCraft != null) {
							Weapons weapon = Weapons.getFromItemStack(toCraft);
							
							ItemStack item1 = weapon.getResources().getItem1();
							ItemStack item2 = weapon.getResources().getItem2();
							ItemStack item3 = weapon.getResources().getItem3();
							
							if(item1 != null) {
								needed++;
								have += player.getInventory().containsAtLeast(item1, item1.getAmount())? 1 : 0;
							}
							if(item2 != null) {
								needed++;
								have += player.getInventory().containsAtLeast(item2, item2.getAmount())? 1 : 0;
							}
							if(item3 != null) {
								needed++;
								have += player.getInventory().containsAtLeast(item3, item3.getAmount())? 1 : 0;
							}
							if(have == needed) {
								if(have > 0) player.getInventory().removeItem(item1);
								if(have > 1) player.getInventory().removeItem(item2);
								if(have > 2) player.getInventory().removeItem(item3);
								player.getInventory().addItem(toCraft);
							} else {
								player.sendMessage(ChatColor.RED + "You do not have the required materials to craft this");
							}
						}
					} else if(slot == 16) {
						//Navigate left
						ItemStack pageItem = inventory.getItem(0);
						if(pageItem.getAmount() - 1 > 0) {
							pageItem.setAmount(pageItem.getAmount() - 1);
						}
						this.updatePage(player);
					} else if(slot == 25) {
						//Navigate right
						ItemStack pageItem = inventory.getItem(0);
						if(Weapons.values().length > pageItem.getAmount() * 12) {
							pageItem.setAmount(pageItem.getAmount() + 1);
						}
						this.updatePage(player);
					}
					if(slot <= 53 && slot >= 0) {
						event.setCancelled(true);
					} else if(event.getClick() == ClickType.SHIFT_LEFT || event.getClick() == ClickType.SHIFT_RIGHT) {
						event.setCancelled(true);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onItemCraft(CraftItemEvent event) {
		if(event.getRecipe().getResult().getType().name().contains("SWORD")) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onChunkPopulate(ChunkPopulateEvent event) {
		for(BlockState tileEntity : event.getChunk().getTileEntities()) {
			System.out.println(tileEntity.getClass());
			if(tileEntity instanceof Chest) {
				Chest chest = (Chest) tileEntity;
				
				int x = tileEntity.getX();
				int y = tileEntity.getY();
				int z = tileEntity.getZ();
				
				for(int xx = x - 5; xx <= x + 5; xx++) {
					for(int yy = y - 5; yy <= y + 5; yy++) {
						for(int zz = z - 5; zz <= z + 5; zz++) {
							Block block = tileEntity.getWorld().getBlockAt(xx, yy, zz);
							if(block.getType() == Material.MOB_SPAWNER) {
								chest.getBlockInventory().addItem(Weapons.values()[new Random().nextInt(Weapons.values().length)].getItemStack());
								break;
							}
						}
					}
				}
			}
		}
	}
	
	private void updatePage(Player player) {
		UUID id = player.getUniqueId();
		Inventory inventory = this.anvilInventories.get(id);
		
		int page = inventory.getItem(0).getAmount();
		
		for(int i = 10; i <= 15; i++) {
			inventory.setItem(i, null);
		}
		for(int i = 19; i <= 24; i++) {
			inventory.setItem(i, null);
		}
		
		for(int i = (page - 1) * 12; i < Math.min(page * 12, Weapons.values().length); i++) {
			inventory.addItem(Weapons.values()[i].getItemStack());
		}
	}
	
	private void updateResourcesSet(Player player, Weapons weapon) {
		UUID id = player.getUniqueId();
		Inventory inventory = this.anvilInventories.get(id);
		
		inventory.setItem(39, null);
		inventory.setItem(40, null);
		inventory.setItem(41, null);

		if(weapon.getResources().getItem1() != null) {
			inventory.setItem(39, weapon.getResources().getItem1().clone());
		}
		if(weapon.getResources().getItem2() != null) {
			inventory.setItem(40, weapon.getResources().getItem2().clone());
		}
		if(weapon.getResources().getItem3() != null) {
			inventory.setItem(41, weapon.getResources().getItem3().clone());
		}
	}
	
	private Inventory generateNewAnvilInventory() {
		Inventory inventory = Bukkit.createInventory(null, 9 * 6, "Crafting");
		
		for(int i = 0; i < 9; i++) {
			inventory.setItem(i, this.getFillerItemStack());
		}
		for(int i = 27; i < 36; i++) {
			inventory.setItem(i, this.getFillerItemStack());
		}
		for(int i = 45; i < 54; i++) {
			inventory.setItem(i, this.getFillerItemStack());
		}
		inventory.setItem(9, this.getFillerItemStack());
		inventory.setItem(17, this.getFillerItemStack());
		inventory.setItem(18, this.getFillerItemStack());
		inventory.setItem(26, this.getFillerItemStack());
		inventory.setItem(36, this.getFillerItemStack());
		inventory.setItem(38, this.getFillerItemStack());
		inventory.setItem(42, this.getFillerItemStack());
		inventory.setItem(43, new ItemStack(Material.WORKBENCH));
		inventory.setItem(44, this.getFillerItemStack());
		inventory.setItem(16, this.getLeftItemStack());
		inventory.setItem(25, this.getRightItemStack());
		
		return inventory;
	}
	
	private ItemStack getLeftItemStack() {
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE);
		
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(ChatColor.GREEN + "GO LEFT");
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	private ItemStack getRightItemStack() {
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE);
		
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(ChatColor.GREEN + "GO RIGHT");
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	private ItemStack getFillerItemStack() {
		ItemStack item = new ItemStack(Material.WATER);
		
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(ChatColor.RED + "");
		item.setItemMeta(itemMeta);
		
		return item;
	}
}
