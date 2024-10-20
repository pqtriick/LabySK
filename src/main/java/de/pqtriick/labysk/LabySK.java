package de.pqtriick.labysk;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import de.pqtriick.labysk.listener.Quit;
import de.pqtriick.labysk.util.Metrics;
import de.pqtriick.labysk.util.TimeHandler;
import de.pqtriick.labysk.util.update.VersionCheck;
import de.pqtriick.labysk.util.update.VersionInform;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LabySK extends JavaPlugin {

    public static final Component PREFIX = MiniMessage.miniMessage().deserialize("<gradient:#FCD05C:#E43A96>LabySK");
    public static boolean hasUpdate;
    private static LabySK labySK;
    private static SkriptAddon addon;
    private static final int id = 21800;

    @Override
    public void onEnable() {
        labySK = this;
        addon = Skript.registerAddon(this);
        checkUpdate();
        LabyModProtocolService.initialize(this);
        Metrics metrics = new Metrics(this, id);
        TimeHandler.handle();
        Bukkit.getPluginManager().registerEvents(new VersionInform(), this);
        try {
            addon.loadClasses("de.pqtriick.labysk", "elements");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bukkit.getPluginManager().registerEvents(new Quit(), this );
        Bukkit.getLogger().info("[LabySK] LabySK Loaded successfully");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LabySK getLabySK() {
        return labySK;
    }

    public static SkriptAddon getAddon() {
        return addon;
    }


    public boolean checkUpdate() {
        new VersionCheck(this, 116590).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                hasUpdate = false;
            } else {
                hasUpdate = true;
            }
        });
        return hasUpdate;
    }
}
