package de.pqtriick.labysk.elements.effects.npc;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;
import de.pqtriick.labysk.LabySK;
import de.pqtriick.labysk.laby.laby4.npc.LabyNPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class NPCEff extends Effect {

    static {
        Skript.registerEffect(NPCEff.class, "create npc with name %string% with skin of %string% with id %integer% at %player%");
    }

    private Expression<String> name;
    private Expression<String> skin;
    private Expression<Integer> id;
    private Expression<Player> player;
    @Override
    protected void execute(Event event) {
        String n = name.getSingle(event);
        String s = skin.getSingle(event);
        Integer i = id.getSingle(event);
        Player p = player.getSingle(event);
        LabyNPC.createNPC(n,p.getLocation(), s, i);

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
        name = (Expression<String>) expressions[0];
        skin = (Expression<String>) expressions[1];
        id = (Expression<Integer>) expressions[2];
        player = (Expression<Player>) expressions[3];
        return true;
    }
}
