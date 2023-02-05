package me.shalloh.genesisorigins.origins;

import me.shalloh.genesisorigins.GenesisOrigins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class InventoryUtil {

    private static ArrayList<Inventory> inventories = new ArrayList<>();

    static String inventoryname;
    static Integer impacttype;
    static String Head;

    public static Inventory inventory;

    public static void createInventory(Player player, String inventoryname, Integer impacttype) {
        Configuration config = GenesisOrigins.getPlugin().getConfig();
        if (config.contains("Origins." + inventoryname)) {
           player.sendMessage("Inventory with that ID already exists!");
           return;
        } else {
            config.set("Origins." + inventoryname + "." + "Impact Type", impacttype);
        config.set("Origins." + inventoryname + "." + "Head", ChatColor.RED + "Player_Skull");
        GenesisOrigins.getPlugin().saveConfig();
        player.sendMessage("It Worked!");
    }
    }

    public static void openInventory(Player player, String originname) {
        Configuration config = GenesisOrigins.getPlugin().getConfig();
        impacttype = config.getInt("Origins." + originname + "." + "Impact Type");
        Head = config.getString("Origins." + originname + "." + "Head");
        inventoryname = originname;
        ItemStack next = new ItemStack(Material.ARROW);
        ItemStack previous = new ItemStack(Material.ARROW);
        ItemStack cancel = new ItemStack(Material.BARRIER);
        ItemStack playerhead = new ItemStack(Material.getMaterial(Head));
        ItemStack noabilities = new ItemStack(Material.PAPER);
        ItemMeta abilitiesmeta = noabilities.getItemMeta();
        ItemMeta playerheadmeta = playerhead.getItemMeta();
        abilitiesmeta.setDisplayName("No Ability");
        playerheadmeta.setDisplayName(originname);
noabilities.setItemMeta(abilitiesmeta);
playerhead.setItemMeta(playerheadmeta);
        ItemMeta nextmeta = next.getItemMeta();
        nextmeta.setDisplayName("Next");
        ItemMeta cancelmeta = cancel.getItemMeta();
        cancelmeta.setDisplayName("Cancel");
        ItemMeta previousmeta = previous.getItemMeta();
        previousmeta.setDisplayName("Previous");
        next.setItemMeta(nextmeta);
        previous.setItemMeta(previousmeta);
        cancel.setItemMeta(cancelmeta);
        if(config.contains("Origins." + originname)) {
            if(impacttype == 0) {
                Inventory noimpact = Bukkit.createInventory(player, 54, originname);
                ItemStack noconcrete = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
                ItemMeta nometa = noconcrete.getItemMeta();
                ItemStack nopanes = new ItemStack((Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta nopanesmeta = nopanes.getItemMeta();
                nometa.setDisplayName(ChatColor.GRAY + "No Impact");
                nopanesmeta.setDisplayName(ChatColor.GRAY + "No Impact");
                ArrayList<String> lore = new ArrayList<>();
                lore.add("This origin does nothing!");
                nometa.setLore(lore);
                nopanesmeta.setLore(lore);
                noconcrete.setItemMeta(nometa);
                nopanes.setItemMeta(nopanesmeta);
                nopanesmeta.setLore(lore);
                noimpact.setItem(0, nopanes);
                noimpact.setItem(1, nopanes);
                noimpact.setItem(2, nopanes);
                noimpact.setItem(3, nopanes);
                noimpact.setItem(4, nopanes);
                noimpact.setItem(5, nopanes);
                noimpact.setItem(6, nopanes);
                noimpact.setItem(7, nopanes);
                noimpact.setItem(8, nopanes);
                noimpact.setItem(9, nopanes);
                noimpact.setItem(17, nopanes);
                noimpact.setItem(18, nopanes);
                noimpact.setItem(26, nopanes);
                noimpact.setItem(27, nopanes);
                noimpact.setItem(35, nopanes);
                noimpact.setItem(36, nopanes);
                noimpact.setItem(44, nopanes);
                noimpact.setItem(45, nopanes);
                noimpact.setItem(46, nopanes);
                noimpact.setItem(47, nopanes);
                noimpact.setItem(51, nopanes);
                noimpact.setItem(52, nopanes);
                noimpact.setItem(53, nopanes);
                noimpact.setItem(14, noconcrete);
                noimpact.setItem(15, noconcrete);
                noimpact.setItem(16, noconcrete);
                noimpact.setItem(48, previous);
                noimpact.setItem(50, next);
                noimpact.setItem(49, cancel);
                noimpact.setItem(29, noabilities);
                noimpact.setItem(30, noabilities);
                noimpact.setItem(31, noabilities);
                noimpact.setItem(32, noabilities);
                noimpact.setItem(33, noabilities);
                noimpact.setItem(38, noabilities);
                noimpact.setItem(39, noabilities);
                noimpact.setItem(40, noabilities);
                noimpact.setItem(41, noabilities);
                noimpact.setItem(42, noabilities);
                noimpact.setItem(22, playerhead);
                player.openInventory(noimpact);
                inventory = noimpact;
            }
            else if (impacttype == 1) {
                Inventory lowimpact = Bukkit.createInventory(player, 54, originname);
                ItemStack lowconcrete = new ItemStack(Material.GREEN_CONCRETE);
                ItemMeta  lowmeta = lowconcrete.getItemMeta();
                ItemStack lowpanes = new ItemStack((Material.GREEN_STAINED_GLASS_PANE));
                ItemMeta lowpanesmeta = lowpanes.getItemMeta();
                lowmeta.setDisplayName(ChatColor.GREEN + "Low Impact");
                lowpanesmeta.setDisplayName(ChatColor.GREEN + "Low Impact");
                lowconcrete.setItemMeta(lowmeta);
                lowpanes.setItemMeta(lowpanesmeta);
                lowimpact.setItem(0, lowpanes);
                lowimpact.setItem(1, lowpanes);
                lowimpact.setItem(2, lowpanes);
                lowimpact.setItem(3, lowpanes);
                lowimpact.setItem(4, lowpanes);
                lowimpact.setItem(5, lowpanes);
                lowimpact.setItem(6, lowpanes);
                lowimpact.setItem(7, lowpanes);
                lowimpact.setItem(8, lowpanes);
                lowimpact.setItem(9, lowpanes);
                lowimpact.setItem(29, noabilities);
                lowimpact.setItem(30, noabilities);
                lowimpact.setItem(31, noabilities);
                lowimpact.setItem(32, noabilities);
                lowimpact.setItem(33, noabilities);
                lowimpact.setItem(38, noabilities);
                lowimpact.setItem(39, noabilities);
                lowimpact.setItem(40, noabilities);
                lowimpact.setItem(41, noabilities);
                lowimpact.setItem(42, noabilities);
                lowimpact.setItem(17, lowpanes);
                lowimpact.setItem(18, lowpanes);
                lowimpact.setItem(26, lowpanes);
                lowimpact.setItem(27, lowpanes);
                lowimpact.setItem(35, lowpanes);
                lowimpact.setItem(36, lowpanes);
                lowimpact.setItem(44, lowpanes);
                lowimpact.setItem(45, lowpanes);
                lowimpact.setItem(46, lowpanes);
                lowimpact.setItem(47, lowpanes);
                lowimpact.setItem(51, lowpanes);
                lowimpact.setItem(52, lowpanes);
                lowimpact.setItem(53, lowpanes);
                lowimpact.setItem(14, lowconcrete);
                lowimpact.setItem(15, lowconcrete);
                lowimpact.setItem(16, lowconcrete);
                lowimpact.setItem(48, previous);
                lowimpact.setItem(50, next);
                lowimpact.setItem(49, cancel);
                lowimpact.setItem(49, cancel);
                lowimpact.setItem(22, playerhead);
                player.openInventory(lowimpact);
                inventory = lowimpact;
            } else if (impacttype == 2) {
                Inventory medImpact = Bukkit.createInventory(player, 54, originname);
                ItemStack medconcrete = new ItemStack(Material.ORANGE_CONCRETE);
                ItemMeta medmeta = medconcrete.getItemMeta();
                ItemStack medpanes = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                ItemMeta medpanesmeta = medpanes.getItemMeta();
                medmeta.setDisplayName(ChatColor.GOLD + "Medium Impact");
                medpanesmeta.setDisplayName(ChatColor.GOLD + "Medium Impact");
                medconcrete.setItemMeta(medmeta);
                medpanes.setItemMeta(medpanesmeta);
                medImpact.setItem(0, medpanes);
                medImpact.setItem(1, medpanes);
                medImpact.setItem(2, medpanes);
                medImpact.setItem(3, medpanes);
                medImpact.setItem(4, medpanes);
                medImpact.setItem(5, medpanes);
                medImpact.setItem(6, medpanes);
                medImpact.setItem(7, medpanes);
                medImpact.setItem(8, medpanes);
                medImpact.setItem(9, medpanes);
                medImpact.setItem(29, noabilities);
                medImpact.setItem(30, noabilities);
                medImpact.setItem(31, noabilities);
                medImpact.setItem(32, noabilities);
                medImpact.setItem(33, noabilities);
                medImpact.setItem(38, noabilities);
                medImpact.setItem(39, noabilities);
                medImpact.setItem(40, noabilities);
                medImpact.setItem(41, noabilities);
                medImpact.setItem(42, noabilities);
                medImpact.setItem(17, medpanes);
                medImpact.setItem(18, medpanes);
                medImpact.setItem(26, medpanes);
                medImpact.setItem(27, medpanes);
                medImpact.setItem(35, medpanes);
                medImpact.setItem(36, medpanes);
                medImpact.setItem(44, medpanes);
                medImpact.setItem(45, medpanes);
                medImpact.setItem(46, medpanes);
                medImpact.setItem(47, medpanes);
                medImpact.setItem(51, medpanes);
                medImpact.setItem(52, medpanes);
                medImpact.setItem(53, medpanes);
                medImpact.setItem(14, medconcrete);
                medImpact.setItem(15, medconcrete);
                medImpact.setItem(16, medconcrete);
                medImpact.setItem(48, previous);
                medImpact.setItem(50, next);
                medImpact.setItem(49, cancel);
                medImpact.setItem(49, cancel);
                medImpact.setItem(22, playerhead);
                player.openInventory(medImpact);
                inventory = medImpact;
            } else if (impacttype == 3) {
                Inventory highImpact = Bukkit.createInventory(player, 54, originname);
                ItemStack highconcrete = new ItemStack(Material.RED_CONCRETE);
                ItemMeta highmeta = highconcrete.getItemMeta();
                ItemStack highpanes = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta highpanesmeta = highpanes.getItemMeta();
                highmeta.setDisplayName(ChatColor.RED + "High Impact");
                highpanesmeta.setDisplayName(ChatColor.RED + "High Impact");
                highconcrete.setItemMeta(highmeta);
                highpanes.setItemMeta(highpanesmeta);
                highImpact.setItem(0, highpanes);
                highImpact.setItem(1, highpanes);
                highImpact.setItem(2, highpanes);
                highImpact.setItem(3, highpanes);
                highImpact.setItem(4, highpanes);
                highImpact.setItem(5, highpanes);
                highImpact.setItem(6, highpanes);
                highImpact.setItem(7, highpanes);
                highImpact.setItem(8, highpanes);
                highImpact.setItem(9, highpanes);
                highImpact.setItem(29, noabilities);
                highImpact.setItem(30, noabilities);
                highImpact.setItem(31, noabilities);
                highImpact.setItem(32, noabilities);
                highImpact.setItem(33, noabilities);
                highImpact.setItem(38, noabilities);
                highImpact.setItem(39, noabilities);
                highImpact.setItem(40, noabilities);
                highImpact.setItem(41, noabilities);
                highImpact.setItem(42, noabilities);
                highImpact.setItem(17, highpanes);
                highImpact.setItem(18, highpanes);
                highImpact.setItem(26, highpanes);
                highImpact.setItem(27, highpanes);
                highImpact.setItem(35, highpanes);
                highImpact.setItem(36, highpanes);
                highImpact.setItem(44, highpanes);
                highImpact.setItem(45, highpanes);
                highImpact.setItem(46, highpanes);
                highImpact.setItem(47, highpanes);
                highImpact.setItem(51, highpanes);
                highImpact.setItem(52, highpanes);
                highImpact.setItem(53, highpanes);
                highImpact.setItem(14, highconcrete);
                highImpact.setItem(15, highconcrete);
                highImpact.setItem(16, highconcrete);
                highImpact.setItem(48, previous);
                highImpact.setItem(50, next);
                highImpact.setItem(49, cancel);
                highImpact.setItem(49, cancel);
                highImpact.setItem(22, playerhead);
                player.openInventory(highImpact);
                inventory = highImpact;
            } else {
                player.sendMessage("Impact type error.");
            }
        }else {
            player.sendMessage("No such origin exists!");
        }


    }

    public static int getID(String origin) {
        Configuration config = GenesisOrigins.getPlugin().getConfig();
        int ID = config.getInt("Origins." + origin + "." + "ID");
        return ID;
    }
}
