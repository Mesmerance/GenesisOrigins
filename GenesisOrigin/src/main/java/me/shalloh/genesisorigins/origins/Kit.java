package me.shalloh.genesisorigins.origins;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class Kit {

    private ArrayList<ItemStack> kit = new ArrayList<>();
    private UUID KitID;

    public Kit (UUID kitID) {
        this.KitID = kitID;
    }
}
