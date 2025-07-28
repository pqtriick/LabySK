package de.pqtriick.labysk.elements.effects.npc;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.LabySK;
import de.pqtriick.labysk.laby.laby4.npc.LabyNPC;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class NPCEmoteEff extends Effect {

    static {
        Skript.registerEffect(NPCEmoteEff.class, "play laby emote %integer% for npc with id %integer% for %player%");
    }

    private Expression<Integer> emote;
    private Expression<Integer> npc;
    private Expression<Player> player;
    @Override
    protected void execute(Event event) {
        Integer e = emote.getSingle(event);
        Integer n = npc.getSingle(event);
        Player p = player.getSingle(event);
        NPC npc = CitizensAPI.getNPCRegistry().getById(n);
        LabyNPC.playEmote(npc.getUniqueId(), e, p);
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return null;
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        if (!LabySK.getLabySK().isCitizensActive()) {
            Skript.error("Citizens is not installed on this server!", ErrorQuality.SEMANTIC_ERROR);
            return false;
        }
        emote = (Expression<Integer>) expressions[0];
        npc = (Expression<Integer>) expressions[1];
        player = (Expression<Player>) expressions[2];
        return true;
    }
}