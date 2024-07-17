package de.pqtriick.labysk.laby.laby4.display;

import net.labymod.serverapi.core.model.display.EconomyDisplay;
import net.labymod.serverapi.server.bukkit.LabyModPlayer;
import net.labymod.serverapi.server.bukkit.LabyModProtocolService;
import org.bukkit.entity.Player;

public class Economy {

    public static void send(Player player, int cash, int bank) {
        LabyModPlayer labyPlayer = LabyModProtocolService.get().getPlayer(player.getUniqueId());
        EconomyDisplay cashDisplay = labyPlayer.cashEconomy();
        EconomyDisplay bankDisplay = labyPlayer.bankEconomy();
        bankDisplay.visible(true);
        cashDisplay.visible(true);

        cashDisplay.balance(cashDisplay.getBalance() + cash);
        bankDisplay.balance(bankDisplay.getBalance() + bank);

        labyPlayer.sendEconomy(cashDisplay);
        labyPlayer.sendEconomy(bankDisplay);
    }
}
