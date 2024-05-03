package de.pqtriick.labysk;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import de.pqtriick.labysk.laby.Protocol;
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

    private static LabySK labySK;
    private static SkriptAddon addon;

    @Override
    public void onEnable() {
        labySK = this;
        addon = Skript.registerAddon(this);
        getServer().getMessenger().registerIncomingPluginChannel(this, "labymod3:main", this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "labymod3:main");

        try {
            addon.loadClasses("de.pqtriick.labysk", "elements");
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, @NotNull byte[] message) {
        if (!channel.equals("labymod3:main")) {
            return;
        }

        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));

        ByteBuf buf = Unpooled.wrappedBuffer(message);
        String key = Protocol.readString(buf, Short.MAX_VALUE);
        String json = Protocol.readString(buf, Short.MAX_VALUE);

        // LabyMod user joins the server
        if(key.equals("INFO")) {
            // Handle the json message
        }

    }
}
