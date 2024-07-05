package de.pqtriick.labysk.elements.effects.npc;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.laby.laby4.npc.LabyNPC;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class NPCRandomEmoteEff extends Effect {

    static {
        Skript.registerEffect(NPCRandomEmoteEff.class, "play random laby emote for npc with id %integer% for %player%");
    }

    private Expression<Integer> npc;
    private Expression<Player> player;
    @Override
    protected void execute(Event event) {
        Integer n = npc.getSingle(event);
        Player p = player.getSingle(event);
        NPC npc = CitizensAPI.getNPCRegistry().getById(n);
        LabyNPC.playRandomEmote(npc.getUniqueId(), p);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        npc = (Expression<Integer>) expressions[0];
        player = (Expression<Player>) expressions[1];
        return true;
    }
}