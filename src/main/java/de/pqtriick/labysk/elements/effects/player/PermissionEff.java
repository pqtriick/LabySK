package de.pqtriick.labysk.elements.effects.player;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class PermissionEff extends Effect {

    private int pattern;
    private Expression<Player> player;

    static {
        Skript.registerEffect(PermissionEff.class, "(1:(allow)|2:(deny)) laby autotext for %player%");
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        LabyModPlayer labyModPlayer = LabyPlayer.getPlayer(p);
        if (labyModPlayer == null) return;
        switch (pattern) {
            case 1:
                LabyPlayer.sendPermission(labyModPlayer, true);
                break;
            case 2:
                LabyPlayer.sendPermission(labyModPlayer, false);
                break;
        }

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        pattern = parseResult.mark;
        player = (Expression<Player>) expressions[0];
        return true;
    }
}