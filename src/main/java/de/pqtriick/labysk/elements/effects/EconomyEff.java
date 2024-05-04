package de.pqtriick.labysk.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.EconomyDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Set Economy Display")
@Description("Sets the Cash and Bank Display in the top right corner of the screen with a smooth transition.")
@Examples({"set cash display to 20 and bank display to 100 for player"})
public class EconomyEff extends Effect {

    static {
        Skript.registerEffect(EconomyEff.class, "set cash display to %integer% and bank display to %integer% for %player%");
    }

    private Expression<Integer> cash;
    private Expression<Integer> bank;
    private Expression<Player> player;
    @Override
    protected void execute(Event event) {
        int c = cash.getSingle(event);
        int b = bank.getSingle(event);
        Player p = player.getSingle(event);
        EconomyDisplay.setBalanceDisplay(p, c, b);

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        cash = (Expression<Integer>) expressions[0];
        bank = (Expression<Integer>) expressions[1];
        player = (Expression<Player>) expressions[2];
        return true;
    }
}
