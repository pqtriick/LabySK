package de.pqtriick.labysk.util.update;

import de.pqtriick.labysk.LabySK;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class VersionCheck {

    private final JavaPlugin plugin;
    private final int id;

    public VersionCheck(JavaPlugin plugin, int id) {
        this.plugin = plugin;
        this.id = id;
    }

    public void getVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(LabySK.getLabySK(), () -> {
            try {
                InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + id).openStream();
                Scanner scanner = new Scanner(inputStream);
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (Exception e) {
                LabySK.getLabySK().getLogger().info("Could not fetch plugin update information");
            }
        });
    }
}
