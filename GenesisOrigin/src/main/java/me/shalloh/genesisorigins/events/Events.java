package me.shalloh.genesisorigins.events;

import me.shalloh.genesisorigins.GenesisOrigins;
import me.shalloh.genesisorigins.origins.InventoryUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import static me.shalloh.genesisorigins.GenesisOrigins.isBedrockPlayer;

public class Events implements Listener {
    @EventHandler
    public boolean isBedrockPlayerOnJoin(PlayerJoinEvent e) {
        //Check if the player is on a bedrock client
        boolean check = isBedrockPlayer(e.getPlayer());
        if (check == true) {
            System.out.println("This is a bedrock Player!");
            return true;
        } else {
            System.out.println("This is NOT a bedrock player!");
            return false;

        }

    }

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "This is one of the rarest items");
        meta.setDisplayName(ChatColor.YELLOW + "Choose your Origin");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        item.setItemMeta(meta);
        e.getPlayer().getInventory().setItem(0, item);
    }

    @EventHandler
    public boolean onPlayerClick (PlayerInteractEvent e) {
       Action action = e.getAction();
       Configuration config = GenesisOrigins.getPlugin().getConfig();
       Inventory origins = Bukkit.createInventory(e.getPlayer(), 54, "Origins");
       ItemStack Skull = new ItemStack(Material.PLAYER_HEAD, 1);
       ItemMeta meta = Skull.getItemMeta();
       List<String> keys = new ArrayList<String>();
       origins.setItem(22, Skull);
            if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))  {
                if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "choose your origin")) {
                    try {
                        for (String key : config.getConfigurationSection("Origins").getKeys(false)) {
                            keys.add(key);
                        }
                        String inv = keys.get(0);
                        InventoryUtil.openInventory(e.getPlayer(), inv);
                    } catch (IndexOutOfBoundsException f) {
                        if(keys.size() == 0) {
                            e.getPlayer().sendMessage("No origins.");
                        }
                    }
                }
            } else {
                return false;
            }


       return true;

    }

    @EventHandler
    public void OriginsNextPage(InventoryClickEvent e) {
        Configuration config = GenesisOrigins.getPlugin().getConfig();
        //Getting the name of the current inventory.
        String invName = e.getView().getTitle();
        //getting the ID of the origin of the inventory we are currently looking at.
        Integer ID = config.getInt("Origins." + invName + "." + "ID");
        //Making a list of strings.
        List<String> keys = new ArrayList<String>();
        //Making a list of Integers.
        List<Integer> ids = new ArrayList<Integer>();
        //if the inventory we are getting is equal to the inventory that is supposed to be open as stated in InventoryUtil.
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().equals(InventoryUtil.inventory)) {
            //If the item we are clicking on has the name "Next"
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Next")) {
                ID += 1;
                int keyid;
                for (String Key : config.getConfigurationSection("Origins").getKeys(false)) {
                   keys.add(Key);
                    }
                int index = keys.indexOf(invName);
                index += 1;
                if(index >= keys.size()) {
                    e.setCancelled(true);
                } else {
                    String nextinv = keys.get(index);
                    InventoryUtil.openInventory(p, nextinv);
                }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Previous")) {
                int keyid;
                for (String Key : config.getConfigurationSection("Origins").getKeys(false)) {
                    keys.add(Key);
                }
                int index = keys.indexOf(invName);
                if(index > 0) {
                    index -= 1;
                    String nextinv = keys.get(index);
                    InventoryUtil.openInventory(p, nextinv);

                } else if (index == 0){
                    e.setCancelled(true);
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Cancel")) {
                p.closeInventory();
            }

            }
            }
        }