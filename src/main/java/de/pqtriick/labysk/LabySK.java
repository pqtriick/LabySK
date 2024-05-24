package de.pqtriick.labysk;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import de.pqtriick.labysk.laby.CheckForLaby;
import de.pqtriick.labysk.laby.Protocol;
import de.pqtriick.labysk.listener.Quit;
import de.pqtriick.labysk.util.Metrics;
import de.pqtriick.labysk.util.update.VersionCheck;
import de.pqtriick.labysk.util.update.VersionInform;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public final class LabySK extends JavaPlugin implements PluginMessageListener {

    public static final String PREFIX = "§cLabySK";
    public static boolean hasUpdate;
    private static LabySK labySK;
    private static SkriptAddon addon;
    private static final int id = 21800;

    @Override
    public void onEnable() {
        labySK = this;
        addon = Skript.registerAddon(this);
        checkUpdate();
        Metrics metrics = new Metrics(this, id);
        Bukkit.getPluginManager().registerEvents(new VersionInform(), this);

        try {
            addon.loadClasses("de.pqtriick.labysk", "elements");
            Bukkit.getPluginManager().registerEvents(new Quit(), this );
            Bukkit.getLogger().info("[LabySK] LabySK Loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }


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


    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, @NotNull byte[] message) {
        if (!channel.equals("labymod3:main")) {

        }

        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));

        ByteBuf buf = Unpooled.wrappedBuffer(message);
        String key = Protocol.readString(buf, Short.MAX_VALUE);
        String json = Protocol.readString(buf, Short.MAX_VALUE);

        // LabyMod user joins the server
        if(key.equals("INFO")) {
            if (!CheckForLaby.labyPlayers.contains(player)) {
                CheckForLaby.labyPlayers.add(player);
            }
        }

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
