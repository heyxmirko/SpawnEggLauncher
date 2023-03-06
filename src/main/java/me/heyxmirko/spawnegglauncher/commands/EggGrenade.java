package me.heyxmirko.spawnegglauncher.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EggGrenade implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,String[] args) {
        if(!(sender instanceof Player)) return false;
        if(!sender.isOp()) return false;

        if(args[0].equals("grenade")) {
            ItemStack eggGrenade = new ItemStack(Material.EGG);
            ItemMeta itemMeta = eggGrenade.getItemMeta();

            itemMeta.displayName(Component.text("Egg Grenade").color(TextColor.color(40, 52, 36)).decorate(TextDecoration.BOLD));

            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY+"This egg grenade will create a fiery");
            lore.add(ChatColor.GOLD+"explosion "+ ChatColor.GRAY+"upon impact, causing significant");
            lore.add(ChatColor.GRAY+"damage to nearby entities.");
            lore.add(ChatColor.RED + "Use with caution!");
            itemMeta.setLore(lore);

            itemMeta.setCustomModelData(405236);

            eggGrenade.setItemMeta(itemMeta);

            Player player = (Player) sender;
            player.getInventory().addItem(eggGrenade);
        }

        if(args[0].equals("list")) {
            sender.sendMessage(Component.text(ChatColor.GOLD+"---> "+ChatColor.RED+ChatColor.BOLD+"LIST OF EGGS" +ChatColor.GOLD+" <---"));
            sender.sendMessage(Component.text(ChatColor.AQUA+"grenade"));
            sender.sendMessage(Component.text(ChatColor.AQUA+"killer_bunny"));
            sender.sendMessage(Component.text(ChatColor.AQUA+"illusioner"));
            sender.sendMessage(Component.text(ChatColor.AQUA+"charged_creeper"));
            sender.sendMessage(Component.text(ChatColor.AQUA+"skeleton_trap"));
            sender.sendMessage(Component.text(ChatColor.AQUA+"giant_zombie"));
            sender.sendMessage(Component.text(ChatColor.AQUA+"giant_slime"));
            sender.sendMessage(Component.text(ChatColor.GOLD+"-----------------------"));
        }

        if(args[0].equals("killer_bunny")) {
            ItemStack killerBunnyEgg = new ItemStack(Material.EGG);
            ItemMeta eggMeta = killerBunnyEgg.getItemMeta();
            eggMeta.displayName(Component.text("The Killer Bunny").color(TextColor.color(250, 0, 0)).decorate(TextDecoration.BOLD));
            eggMeta.setCustomModelData(999999);

            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GOLD+"Warning: "+ ChatColor.GRAY+"contents may be dangerous.");
            lore.add(ChatColor.RED+"The Killer Bunny is not your average bunny!");
            eggMeta.setLore(lore);

            killerBunnyEgg.setItemMeta(eggMeta);

            Player player = (Player) sender;
            player.getInventory().addItem(killerBunnyEgg);
        }

        if(args[0].equals("illusioner")) {
            ItemStack egg = new ItemStack(Material.EGG);
            ItemMeta eggMeta = egg.getItemMeta();

            eggMeta.displayName(Component.text("Illusioner").color(TextColor.color(16, 164, 243)).decorate(TextDecoration.BOLD));
            eggMeta.setCustomModelData(999998);

            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.RED+"Handle with care!");
            lore.add(ChatColor.GRAY+"This egg contains an Illusioner,");
            lore.add(ChatColor.GRAY+"a master of deception and trickery.");
            eggMeta.setLore(lore);

            egg.setItemMeta(eggMeta);

            Player player = (Player) sender;
            player.getInventory().addItem(egg);
        }

        if(args[0].equals("charged_creeper")) {
            ItemStack egg = new ItemStack(Material.EGG);
            ItemMeta eggMeta = egg.getItemMeta();

            eggMeta.displayName(Component.text("Charged Creeper").color(TextColor.color(19, 220, 16)).decorate(TextDecoration.BOLD));
            eggMeta.setCustomModelData(999997);

            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GOLD+"The ultimate weapon in your arsenal");
            lore.add(ChatColor.GRAY+"the charged creeper egg,");
            lore.add(ChatColor.GRAY+"holds explosive potential.");
            eggMeta.setLore(lore);

            egg.setItemMeta(eggMeta);

            Player player = (Player) sender;
            player.getInventory().addItem(egg);
        }


        if(args[0].equals("skeleton_trap")) {
            ItemStack egg = new ItemStack(Material.EGG);
            ItemMeta eggMeta = egg.getItemMeta();

            eggMeta.displayName(Component.text("Skeleton Trap").color(TextColor.color(62, 247, 179)).decorate(TextDecoration.BOLD));
            eggMeta.setCustomModelData(999996);

            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY+"With this egg, you can summon a deadly");
            lore.add(ChatColor.GRAY+"Skeleton Trap to wreak havoc on your enemies.");
            lore.add(ChatColor.RED+"But be careful - its power is not to be taken lightly.");
            eggMeta.setLore(lore);

            egg.setItemMeta(eggMeta);

            Player player = (Player) sender;
            player.getInventory().addItem(egg);
        }


        if(args[0].equals("giant_zombie")) {
            ItemStack egg = new ItemStack(Material.EGG);
            ItemMeta eggMeta = egg.getItemMeta();

            eggMeta.displayName(Component.text("Giant Zombie").color(TextColor.color(66, 189, 6)).decorate(TextDecoration.BOLD));
            eggMeta.setCustomModelData(999995);

            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY+"This egg is said to hold the power to");
            lore.add(ChatColor.GRAY+"spawn a monster of epic proportions.");
            lore.add(ChatColor.GRAY+"Are you ready to take on a Giant Zombie?");
            eggMeta.setLore(lore);

            egg.setItemMeta(eggMeta);

            Player player = (Player) sender;
            player.getInventory().addItem(egg);
        }

        if(args[0].equals("giant_slime")) {
            ItemStack egg = new ItemStack(Material.EGG);
            ItemMeta eggMeta = egg.getItemMeta();

            eggMeta.displayName(Component.text("Giant Slime").color(TextColor.color(106, 247, 5)).decorate(TextDecoration.BOLD));
            eggMeta.setCustomModelData(999994);

            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY+"The slimiest egg you'll ever see.");
            lore.add(ChatColor.GRAY+"Hatch it into a behemoth of bouncing, slimy goodness.");
            eggMeta.setLore(lore);

            egg.setItemMeta(eggMeta);

            Player player = (Player) sender;
            player.getInventory().addItem(egg);
        }




        else {
            sender.sendMessage(Component.text(ChatColor.RED+"/egg [egg_name]"));
        }


        return false;

    }
}
