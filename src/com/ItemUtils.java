package com;

import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {
    
    private ItemStack is;
    
    public ItemUtils(ItemStack is) {
        this.is = is;
    }
    
    public ItemUtils rename(String s) {
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(s);
        is.setItemMeta(im);
        return this;
    }
    
    public ItemUtils setLore(List<String> lore){
        ItemMeta m = is.getItemMeta();
        m.setLore(lore);
        is.setItemMeta(m);
        return this;
    }
    
    public ItemUtils addEnchantment(Enchantment e, int level) {
        is.addUnsafeEnchantment(e, level);
        return this;
    }
    
    public static void rename(ItemStack i, String s) {
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(s);
        i.setItemMeta(m);
    }
    
    public static void setLore(ItemStack i, List<String> lore) {
        ItemMeta m = i.getItemMeta();
        m.setLore(lore);
        i.setItemMeta(m);
    }
    
    public static void addEnchantment(ItemStack i, Enchantment e, int level) {
        i.addUnsafeEnchantment(e, level);
    }

}
