package de.pqtriick.labysk.elements.effects.inputPrompt;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.inputprompt.LabyInputPrompt;
import de.pqtriick.labysk.laby.laby4.inputprompt.ParamConvert;
import net.labymod.serverapi.api.model.component.ServerAPITextColor;
import net.labymod.serverapi.api.model.component.ServerAPITextDecoration;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class CreateInputEff extends Effect {

    static {
        Skript.registerEffect(CreateInputEff.class, "create new input prompt with id %string% named %string% with colorname %string%, decoration  %string% and placeholder %string% with default value %string% and maximum length %integer%");
    }

    private Expression<String> id;
    private Expression<String> name;
    private Expression<String> color;
    private Expression<String> deco;
    private Expression<String> placeHolder;
    private Expression<String> defaultValue;
    private Expression<Integer> length;



    @Override
    protected void execute(Event event) {
        String i = id.getSingle(event);
        String n = name.getSingle(event);
        ServerAPITextColor c = ServerAPITextColor.getByName(color.getSingle(event).toUpperCase());
        ServerAPITextDecoration d = ParamConvert.conv(deco.getSingle(event).toUpperCase());
        String p = placeHolder.getSingle(event);
        String v = defaultValue.getSingle(event);
        Integer l = length.getSingle(event);

        LabyInputPrompt.createPrompt(i, n, c, d, p, v, l);

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        id = (Expression<String>) expressions[0];
        name = (Expression<String>) expressions[1];
        color = (Expression<String>) expressions[2];
        deco = (Expression<String>) expressions[3];
        placeHolder = (Expression<String>) expressions[4];
        defaultValue = (Expression<String>) expressions[5];
        length = (Expression<Integer>) expressions[6];
        return true;
    }
}
