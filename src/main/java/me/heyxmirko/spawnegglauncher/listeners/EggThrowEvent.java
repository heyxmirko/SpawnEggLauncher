package me.heyxmirko.spawnegglauncher.listeners;

import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.tools.jlink.plugin.Plugin;
import me.heyxmirko.spawnegglauncher.SpawnEggLauncher;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;


public class EggThrowEvent implements Listener {



    SpawnEggLauncher plugin = (SpawnEggLauncher) Bukkit.getPluginManager().getPlugin("SpawnEggLauncher");

    private boolean isSpawnEgg(Material material) {
        return material.name().contains("_SPAWN_EGG");
    }

    private boolean isEgg(Material material) {
        if(material.name().contains("LEGGINGS") || material.name().contains("TURTLE_EGG")) return false;
        return material.name().contains("EGG");
    }

    private EntityType getSpawnEggEntityType(Material material) {
        String[] parts = material.name().split("_SPAWN_EGG");
        String entityName = parts[0];
        return EntityType.valueOf(entityName);
    }

    HashMap<Egg, EntityType> eggs = new HashMap<Egg, EntityType>();



    static Boolean isQueue = Boolean.FALSE;

    public static void setQueue(Boolean queue) {
        isQueue = queue;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction().isRightClick()) {
            ItemStack item = event.getItem();

            if(item != null) {
                if(isEgg(item.getType())) {

                    if(plugin.isLocationAllowed(event.getPlayer().getLocation())) {

                        if(isSpawnEgg(item.getType())) {
                            EntityType entityType = getSpawnEggEntityType(item.getType());
                            Player player = event.getPlayer();
                            Egg egg = player.launchProjectile(Egg.class);
                            egg.setItem(new ItemStack(item));
                            eggs.put(egg, getSpawnEggEntityType(item.getType()));
                            isQueue = Boolean.TRUE;
                            player.playSound(player.getLocation(), Sound.ENTITY_EGG_THROW, 1.0F, 1.0F);

                            ItemStack altItem = item;
                            altItem.setAmount(altItem.getAmount()-1);

                            if (event.getHand() == EquipmentSlot.OFF_HAND) {
                                player.getInventory().setItemInOffHand(altItem);
                            } else if (event.getHand() == EquipmentSlot.HAND) {
                                player.getInventory().setItemInMainHand(altItem);
                            }

                            event.setCancelled(true);
                        }

                    }
                    else {
                        event.setCancelled(true);
                        event.getPlayer().sendMessage(Component.text(ChatColor.RED + "You can't use spawn egg in this region!"));
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEggland(ProjectileHitEvent event) {
        if(event.getEntity() instanceof Egg && event.getEntity().getShooter() instanceof Player) {
            Egg egg = (Egg) event.getEntity();



            if(eggs.containsKey(egg)) {
                Location location = egg.getLocation();

                Entity spawnedEntity = egg.getWorld().spawnEntity(location, eggs.get(egg));
                //String str = eggs.get(egg).toString();
                //String capitalizedStr = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
                //spawnedEntity.setCustomName(((Player)event.getEntity().getShooter()).getName()+"'s "+capitalizedStr);
                //spawnedEntity.setCustomNameVisible(true);
            }
        }
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {
        if(event.getEntityType()==EntityType.CHICKEN && (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.DISPENSE_EGG|| event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.EGG)) {
            if(isQueue == Boolean.TRUE) {
                event.setCancelled(true);
                isQueue = Boolean.FALSE;
            }
        }
    }

}
