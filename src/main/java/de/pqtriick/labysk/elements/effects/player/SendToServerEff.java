package de.pqtriick.labysk.elements.effects.player;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.player.SendToServer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Send player to server")
@Description("Sends the player to any other minecraft server")
@Examples({"send player to server \"hypixel.net\" titled \"Example\" (\"with\"|\"without\") preview"})

public class SendToServerEff extends Effect {

    static {
        Skript.registerEffect(SendToServerEff.class, "send %player% to server %string% titled %string%");
    }

    Expression<Player> player;
    Expression<String> address;
    Expression<String> title;

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        String ip = address.getSingle(event);
        String text = title.getSingle(event);
        SendToServer.send(p, ip, text);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        address = (Expression<String>) expressions[1];
        title = (Expression<String>) expressions[2];
        return true;
    }
}
