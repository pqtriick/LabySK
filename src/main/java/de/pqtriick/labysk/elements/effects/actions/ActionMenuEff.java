package de.pqtriick.labysk.elements.effects.actions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.ActionMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class ActionMenuEff extends Effect {

    private int pattern;
    private Expression<String> name;
    private Expression<String> value;
    private Expression<String> type;
    private Expression<Player> player;
    private boolean addition;

    static {
        Skript.registerEffect(ActionMenuEff.class, "(1:(add)|2:(remove)) action with name %string% and value %string% as type %string% for %player%");
    }

    @Override
    protected void execute(Event event) {
        String displayname = name.getSingle(event);
        String displayValue = value.getSingle(event);
        String actionType = type.getSingle(event);
        Player p = player.getSingle(event);
        switch (pattern) {
            case 1 -> addition = true;
            case 2 -> addition = false;
        }
        if (addition) {
            ActionMenu.addAction(displayname, actionType.toUpperCase(), displayValue, p);
        } else {
            ActionMenu.removeAction(displayname, actionType.toUpperCase(), displayValue, p);
        }
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        pattern = parseResult.mark;
        name = (Expression<String>) expressions[0];
        value = (Expression<String>) expressions[1];
        type = (Expression<String>) expressions[2];
        player = (Expression<Player>) expressions[3];
        return true;
    }
}
