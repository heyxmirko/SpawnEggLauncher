package me.heyxmirko.spawnegglauncher;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import me.heyxmirko.spawnegglauncher.commands.EggGrenade;
import me.heyxmirko.spawnegglauncher.listeners.EggGrenadeEvent;
import me.heyxmirko.spawnegglauncher.listeners.EggThrowEvent;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnEggLauncher extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Plugin has been loaded!");
        registerCommands();
        registerListeners();
    }

    public boolean isLocationAllowed(Location location) {
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
        WorldGuardPlugin worldGuard = (WorldGuardPlugin) plugin;

        RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regionManager = regionContainer.get(BukkitAdapter.adapt(location.getWorld()));
        ProtectedRegion warzoneRegion = regionManager.getRegion("warzone");

        if(location.getWorld().getName().equals("world_events")) return false;

        return warzoneRegion != null && !warzoneRegion.contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }


    private void registerCommands() {
        getCommand("egg").setExecutor(new EggGrenade());
        getLogger().info("Registered Commands!");
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new EggThrowEvent(), this);
        getServer().getPluginManager().registerEvents(new EggGrenadeEvent(this), this);
        getLogger().info("Registered Listeners!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin has been unloaded!");
    }
}
