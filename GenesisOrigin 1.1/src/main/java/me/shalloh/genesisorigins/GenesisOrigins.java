package me.shalloh.genesisorigins;

import me.shalloh.genesisorigins.commands.Commands;
import me.shalloh.genesisorigins.events.Events;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.event.KeyEvent;
import java.util.UUID;

public final class GenesisOrigins extends JavaPlugin implements Listener {

    //The UUID prefix geyser uses to differentiate between bedrock players *UNLESS GEYSER CHANGES THE CODE DO NOT CHANGE THIS
    public static String uuidPrefix = "00000000-0000-0000-0009";
    private static GenesisOrigins plugin;

    public static boolean ispressed = true;
    @Override
    public void onEnable() {
        Events events = new Events();
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println("Genesis Origins is enabled!");
        getServer().getPluginManager().registerEvents(events, this);
        getCommand("origin").setExecutor(new Commands());
        plugin = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Genesis Origins is disabled!");

    }

    public static boolean isBedrockPlayer(Player p) {
        UUID playeruuid = p.getUniqueId();
        String uuid = playeruuid.toString();
        if (uuid.contains(uuidPrefix)) {
            return true;
        } else {
            return false;
        }

    }
}