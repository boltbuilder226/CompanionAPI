package com;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIUtils {

    JavaPlugin plugin;
    Inventory inv;

    public GUIUtils(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public Inventory createGUI(HashMap<Integer, ItemStack> slots,
            InventoryType type) {

        Inventory inv = plugin.getServer().createInventory(null, type);

        for (Integer i : slots.keySet()) {

            inv.setItem(i, slots.get(i));

        }
        this.inv = inv;
        return inv;

    }
    
    public void openGUI(Player p) {
        p.openInventory(inv);
    }
    
    public static Inventory createGUI(JavaPlugin plugin,
            HashMap<Integer, ItemStack> slots, InventoryType type) {

        Inventory inv = plugin.getServer().createInventory(null, type);

        for (Integer i : slots.keySet()) {

            inv.setItem(i, slots.get(i));

        }

        return inv;

    }

    public static void openGUI(Player p, Inventory inv) {
        p.openInventory(inv);
    }

    public static void closeGUI(Player p) {
        p.closeInventory();
    }

}
