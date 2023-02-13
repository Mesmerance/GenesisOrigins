package me.shalloh.genesisorigins.commands;

import me.shalloh.genesisorigins.GenesisOrigins;
import me.shalloh.genesisorigins.origins.InventoryUtil;
import me.shalloh.genesisorigins.origins.OriginUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Commands implements CommandExecutor {
    public static Player player;
    public static Player getPlayer() {
        return player;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) throws ArrayIndexOutOfBoundsException {
        Player p = (Player) sender;
        Configuration config = GenesisOrigins.getPlugin(GenesisOrigins.class).getConfig();
        player = p;
        //Origin Command
        if (command.getName().equalsIgnoreCase("origin")) {

            if (sender instanceof Player) {
                //If the player does not provide any arguments
                if (args.length == 0) {
                    p.sendMessage("You did not specify any arguments!");
                } else if (args[0].equalsIgnoreCase("create")) {
                    if(args.length == 3) {
                        try {
                            String originname = args[1];
                            Integer impacttype = Integer.parseInt(args[2]);
                            String number = Integer.toString(Integer.parseInt(args[2]));
                            config.set("Origins." + originname + "." + "Impact Type", impacttype);
                            config.set("Origins." + originname + "." + "Head", "PLAYER_HEAD");
                            ItemStack item = new ItemStack(Material.PLAYER_HEAD);
                            GenesisOrigins.getPlugin(GenesisOrigins.class).saveConfig();
                            if (originname.contains(number)) {
                                p.sendMessage("Contains Number");
                            } else {
                                p.sendMessage("You used a letter for the name!");
                            }
                        } catch (NumberFormatException e) {
                            p.sendMessage("Format Exception.");
                        }
                    } else  {
                        p.sendMessage("Invalid Arguments.");
                    }
                } else if (args[0].equalsIgnoreCase("delete")) {
                    if(args.length == 2) {
                        String originname = args[1];
                        if(config.contains("Origins." + originname)) {
                            config.set("Origins." + originname, null);
                            p.sendMessage("Origin Deleted.");
                        } else {
                            p.sendMessage("No such origin exists!");

                        }
                    } else {
                        p.sendMessage("Invalid Arguments.");
                    }
                }  else if (args[0].equalsIgnoreCase("list")) {
                    List<String> keys = new ArrayList<String>();
                    for (String key : config.getConfigurationSection("Origins").getKeys(false)) {
                        keys.add(key);
                    }
                    p.sendMessage("Available Origins:\n"  + keys.toString());
                } else if (args[0].equalsIgnoreCase("reset")) {
                    config.set("Origins", null);
                    config.set("Origins.Human.Impact Type", 0);
                    config.set("Origins.Human.Head", "PLAYER_HEAD");
                    config.set("Origins.Elytrian.Impact Type", 1);
                    config.set("Origins.Elytrian.Head", "ELYTRA");
                    config.set("Origins.Avian.Impact Type", 1);
                    config.set("Origins.Avian.Head", "FEATHER");
                    config.set("Origins.Arachnid.Impact Type", 1);
                    config.set("Origins.Arachnid.Head", "COBWEB");
                    config.set("Origins.Shulk.Impact Type", 1);
                    config.set("Origins.Shulk.Head", "SHULKER_SHELL");
                    config.set("Origins.Enderian.Impact Type", 2);
                    config.set("Origins.Enderian.Head", "ENDER_PEARL");
                    config.set("Origins.Feline.Impact Type", 2);
                    config.set("Origins.Merling.Impact Type", 3);
                    config.set("Origins.Merling.Head", "TROPICAL_FISH");
                    config.set("Origins.Phantom.Impact Type", 3);
                    config.set("Origins.Phantom.Head", "PHANTOM_MEMBRANE");
                    config.set("Origins.Blazeborne.Impact Type", 3);
                    config.set("Origins.Blazeborne.Head", "BLAZE_POWDER");
                    GenesisOrigins.getPlugin(GenesisOrigins.class).saveConfig();
                    p.sendMessage("Origins config reset.");
                }
                }
                }


            return true;
        }

        }

