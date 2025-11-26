package de.pqtriick.labysk.elements.effects.badges;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.display.LabyBadge;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class CreateBadgeEff extends Effect {

    private Expression<Integer> id;
    private Expression<String> hexColor;
    private Expression<String> imageURL;

    static {
        Skript.registerEffect(CreateBadgeEff.class, "create badge with id %integer% color %string% and image %string%");
    }

    @Override
    protected void execute(Event event) {
        int i = id.getSingle(event);
        String hex = hexColor.getSingle(event);
        String image = imageURL.getSingle(event);
        LabyBadge.createNewBadge(i, hex, image);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        id = (Expression<Integer>) expressions[0];
        hexColor = (Expression<String>) expressions[1];
        imageURL = (Expression<String>) expressions[2];
        return true;
    }
}
