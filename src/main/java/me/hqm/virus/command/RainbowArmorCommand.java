package me.hqm.virus.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class RainbowArmorCommand implements CommandExecutor {

    private static ItemStack[] GAY_ARMOR = new ItemStack[4];

    static {
        GAY_ARMOR[0] = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta hatMeta = GAY_ARMOR[0].getItemMeta();
        hatMeta.setDisplayName("Gay Helmet");
        hatMeta.setLore(Collections.singletonList("This hat is gay as f*ck."));
        GAY_ARMOR[0].setItemMeta(hatMeta);

        GAY_ARMOR[1] = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta chestMeta = GAY_ARMOR[1].getItemMeta();
        chestMeta.setDisplayName("Gay Chestplate");
        chestMeta.setLore(Collections.singletonList("This chestplate is as gay as it gets."));
        GAY_ARMOR[1].setItemMeta(chestMeta);

        GAY_ARMOR[2] = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta legMeta = GAY_ARMOR[2].getItemMeta();
        legMeta.setDisplayName("Gay Leggings");
        legMeta.setLore(Collections.singletonList("These pants are mega-gay."));
        GAY_ARMOR[2].setItemMeta(legMeta);

        GAY_ARMOR[3] = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta footMeta = GAY_ARMOR[3].getItemMeta();
        footMeta.setDisplayName("Gay Bootsies");
        footMeta.setLore(Collections.singletonList("You can't wear these and not be gay."));
        GAY_ARMOR[3].setItemMeta(footMeta);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("rainbowarmor")) {
            if (sender.hasPermission("hqm.rainbowarmor") && sender instanceof Player) {
                Player player = (Player) sender;
                Inventory inventory = player.getInventory();
                inventory.addItem(GAY_ARMOR[0], GAY_ARMOR[1], GAY_ARMOR[2], GAY_ARMOR[3]);
                sender.sendMessage(ChatColor.YELLOW + "Gay armor added to inventory.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to do that.");
                return true;
            }
        }
        return false;
    }
}
