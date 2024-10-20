package de.pqtriick.labysk.elements.expressions.addons;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.addons.DisableAddons;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class GetBlockedAddonsExpression extends SimpleExpression<String> {

    static {
        Skript.registerExpression(GetBlockedAddonsExpression.class, String.class, ExpressionType.SIMPLE, " list of blocked addons");
    }

    @Override
    protected @Nullable String[] get(Event event) {
        return DisableAddons.disabledAddons.stream().toArray(String[]::new);
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
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }
}
