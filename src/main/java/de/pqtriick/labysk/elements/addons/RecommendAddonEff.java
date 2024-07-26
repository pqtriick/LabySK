package de.pqtriick.labysk.elements.addons;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.addons.AddonRecommend;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Addon request")
@Description("Sends a request for player which shows which addons are optional or required to play\nAll addon uuids can be found here : https://dl.labymod.net/addons.json")
@Examples({"send addon with id \"2cc09032-995f-4b57-a2a1-f1399addbb21\" to be (\"required\"|\"optional\") to player"})

public class RecommendAddonEff extends Effect {

    static {
        Skript.registerEffect(RecommendAddonEff.class, "send addon with id %string% to be %string% to %player%");
    }

    private Expression<String> uuid;
    private Expression<String> state;
    private Expression<Player> player;

    @Override
    protected void execute(Event event) {
        String addonuuid = uuid.getSingle(event);
        String s = state.getSingle(event);
        Player p = player.getSingle(event);

        if (s.equalsIgnoreCase("optional")) {
            AddonRecommend.sendRecommendation(addonuuid, p, false);
        } else if (s.equalsIgnoreCase("required")) {
            AddonRecommend.sendRecommendation(addonuuid, p, true);
        }

    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        uuid = (Expression<String>) expressions[0];
        state = (Expression<String>) expressions[1];
        player = (Expression<Player>) expressions[2];
        return true;
    }
}
