package me.shalloh.genesisorigins;

import me.shalloh.genesisorigins.commands.Commands;
import me.shalloh.genesisorigins.commands.Origins;
import me.shalloh.genesisorigins.events.Events;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.common.value.qual.IntRange;
import org.geysermc.api.Geyser;
import org.geysermc.api.util.BedrockPlatform;
import org.geysermc.api.util.InputMode;
import org.geysermc.api.util.UiProfile;
import org.geysermc.cumulus.form.Form;
import org.geysermc.cumulus.form.util.FormBuilder;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;
import org.geysermc.floodgate.api.unsafe.Unsafe;
import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;
import org.geysermc.geyser.api.extension.ExtensionManager;
import org.geysermc.geyser.api.network.BedrockListener;
import org.geysermc.geyser.api.network.RemoteServer;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public final class GenesisOrigins extends JavaPlugin implements Listener {

    //The UUID prefix geyser uses to differentiate between bedrock players *UNLESS GEYSER CHANGES THE CODE DO NOT CHANGE THIS
    public static String uuidPrefix = "00000000-0000-0000-0009";
    private static GenesisOrigins plugin;
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

    public static GenesisOrigins getPlugin() {
        return plugin;
    }
}