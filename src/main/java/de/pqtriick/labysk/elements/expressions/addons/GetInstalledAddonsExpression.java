package de.pqtriick.labysk.elements.expressions.addons;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.addons.InstalledAddons;
import de.pqtriick.labysk.laby.laby4.player.LabyPlayer;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class GetInstalledAddonsExpression extends SimpleExpression<String> {

    static {
        Skript.registerExpression(GetInstalledAddonsExpression.class, String.class, ExpressionType.COMBINED, "labymod addons of %player%");
    }

    private Expression<Player> player;

    @Override
    protected @Nullable String[] get(Event event) {
        Player p = player.getSingle(event);
        LabyModPlayer labyModPlayer = LabyPlayer.getPlayer(p);
        if (labyModPlayer == null) return new String[0];
        return InstalledAddons.installedAddons.get(p.getUniqueId()).stream().toArray(String[]::new);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expressions[0];
        return true;
    }
}
