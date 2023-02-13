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

public static void saveOrigins() throws IOException {
    Gson gson = new Gson();
    File file = new File(GenesisOrigins.getPlugin(GenesisOrigins.class).getDataFolder().getAbsolutePath() + "/" + origin.getOriginName() + ".json");
        file.getParentFile().mkdir();
        file.createNewFile();
        Writer writer = new FileWriter(file, false);
        gson.toJson(origins, writer);
        writer.flush();
        writer.close();
        System.out.println("Origins saved.");
    }


}