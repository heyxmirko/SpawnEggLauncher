package me.heyxmirko.spawnegglauncher.listeners;

import me.heyxmirko.spawnegglauncher.SpawnEggLauncher;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.scheduler.BukkitTask;
import me.heyxmirko.spawnegglauncher.listeners.EggThrowEvent;

public class EggGrenadeEvent implements Listener {


    private final SpawnEggLauncher plugin;

    public EggGrenadeEvent(SpawnEggLauncher spawnEggLauncher) {
        this.plugin = spawnEggLauncher;
    }



    @EventHandler
    private void onEggThrow(PlayerEggThrowEvent event) {
        Egg egg = event.getEgg();

        if(egg.getItem().getItemMeta().hasCustomModelData()) {
            if(egg.getItem().getItemMeta().getCustomModelData() == 405236) {
                EggThrowEvent.setQueue(Boolean.TRUE);
                egg.getWorld().playSound(egg.getLocation(), Sound.ENTITY_TNT_PRIMED, 1f, 0.7f);

                BukkitTask smokeTask =  Bukkit.getScheduler().runTaskTimer(plugin, () -> egg.getWorld().spawnParticle(Particle.SMOKE_LARGE, event.getEgg().getLocation(), 1, 0.0, 0.2, 0.0, 0.1), 0L, 5L);
                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        smokeTask.cancel();
                        egg.getWorld().createExplosion(egg.getLocation(), 4f, true);
                    }
                }, 60L);
            }



            if(egg.getItem().getItemMeta().getCustomModelData() == 999999) {
                EggThrowEvent.setQueue(Boolean.TRUE);

                Entity rabbit = egg.getWorld().spawnEntity(egg.getLocation(), EntityType.RABBIT);
                ((Rabbit) rabbit).setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);
                egg.getWorld().playSound(egg.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1F, 2F);
            }



            if(egg.getItem().getItemMeta().getCustomModelData() == 999998) {
                EggThrowEvent.setQueue(Boolean.TRUE);

                egg.getWorld().spawnEntity(egg.getLocation(), EntityType.ILLUSIONER);
                egg.getWorld().playSound(egg.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 10F, 0F);
            }



            if(egg.getItem().getItemMeta().getCustomModelData() == 999997) {
                EggThrowEvent.setQueue(Boolean.TRUE);

                Creeper creeper = (Creeper) egg.getWorld().spawnEntity(egg.getLocation(), EntityType.CREEPER);
                creeper.setPowered(true);
                egg.getWorld().playSound(egg.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 10F, 2F);
            }



            if(egg.getItem().getItemMeta().getCustomModelData() == 999996) {
                EggThrowEvent.setQueue(Boolean.TRUE);


                SkeletonHorse horse = (SkeletonHorse) egg.getWorld().spawnEntity(egg.getLocation(), EntityType.SKELETON_HORSE);
                horse.setTrapped(true);
                horse.setAgeLock(true);
            }


            if(egg.getItem().getItemMeta().getCustomModelData() == 999995) {
                EggThrowEvent.setQueue(Boolean.TRUE);

                egg.getWorld().spawnEntity(egg.getLocation(), EntityType.GIANT);
                egg.getWorld().playSound(egg.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, 10F, 0F);

            }


            if(egg.getItem().getItemMeta().getCustomModelData() == 999994) {
                EggThrowEvent.setQueue(Boolean.TRUE);

                Slime slime = (Slime) egg.getWorld().spawnEntity(egg.getLocation(), EntityType.SLIME);
                slime.setSize(15);
                egg.getWorld().playSound(egg.getLocation(), Sound.ENTITY_SLIME_SQUISH, 10F, 0F);

            }
        }

    }
}
