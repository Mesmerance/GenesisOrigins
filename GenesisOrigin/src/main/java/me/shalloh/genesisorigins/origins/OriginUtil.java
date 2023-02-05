package me.shalloh.genesisorigins.origins;

import com.google.gson.Gson;
import me.shalloh.genesisorigins.GenesisOrigins;
import me.shalloh.genesisorigins.commands.Commands;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.UUID;

public class OriginUtil {

    //CRUD Create, Read, Update, Delete
private static ArrayList<Origin> origins = new ArrayList<>();
static String originname;
static Integer impact;
static UUID unique;

static Player player;

public static boolean fileExists;

public static Origin origin = new Origin(originname, impact, unique);

public static Origin CreateOrigin (String originname, Integer impacttype, UUID p) {
    origin.setOriginName(originname);
    origin.setImpactType(impacttype);
    origin.setPlayerUUID(p);
    player = Commands.getPlayer();
    origins.add(origin);

    try {
        saveOrigins();

    } catch(IOException e) {

    }
    return origin;

}

public static void DeleteOrigin(String id) {
    //linear search
    for (Origin origin : origins) {
        if (origin.getId().equalsIgnoreCase(id)) {
            origins.remove(origin);
            break;
        }
    }
    try {
        saveOrigins();

    } catch(IOException e) {

    }
}

 public static Origin FindOrigin(String id) {
    for(Origin origin : origins) {
        if(origin.getId().equalsIgnoreCase(id)) {
            return origin;
        }

    }
    return null;
    }

public static Origin UpdateOrigin(String id, Origin newOrigin) {
    for (Origin origin : origins) {
        if(origin.getId().equalsIgnoreCase(id)) {
            origin.setOriginName(newOrigin.getOriginName());
            origin.setImpactType(newOrigin.getImpactType());
            origin.setPlayerUUID(newOrigin.getPlayerUUID());

            try {
                saveOrigins();

            } catch(IOException e) {

            }
            return origin;
        }
    }
    return null;
}

public static void saveOrigins() throws IOException {
    Gson gson = new Gson();
    File file = new File(GenesisOrigins.getPlugin().getDataFolder().getAbsolutePath() + "/" + origin.getOriginName() + ".json");
        file.getParentFile().mkdir();
        file.createNewFile();
        Writer writer = new FileWriter(file, false);
        gson.toJson(origins, writer);
        writer.flush();
        writer.close();
        System.out.println("Origins saved.");
    }

    public static void loadOrigins() throws IOException {

}

}