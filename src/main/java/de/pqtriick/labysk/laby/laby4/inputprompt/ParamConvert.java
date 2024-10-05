package de.pqtriick.labysk.laby.laby4.inputprompt;

import net.labymod.serverapi.api.model.component.ServerAPITextColor;
import net.labymod.serverapi.api.model.component.ServerAPITextDecoration;

public class ParamConvert {

    public static ServerAPITextDecoration conv(String deco) {
        ServerAPITextDecoration decoration = null;
        switch (deco) {
            case "OBFUSCATED":
                decoration = ServerAPITextDecoration.OBFUSCATED;
                break;
            case "BOLD":
                decoration = ServerAPITextDecoration.BOLD;
                break;
            case "STRIKETHROUGH":
                decoration = ServerAPITextDecoration.STRIKETHROUGH;
                break;
            case "UNDERLINED":
                decoration = ServerAPITextDecoration.UNDERLINED;
                break;
            case "ITALIC":
                decoration = ServerAPITextDecoration.ITALIC;
                break;
        }
        return decoration;
    }
}
