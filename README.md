<img src = https://i.imgur.com/6r6rHUF.png>

# LabySK

LabySk is a SkriptAddon which allows you to use the LabyMod Server API with simple Skript Syntax.
Sadly the ServerAPI has limited features for LabyMod 4, however there are some which still work with this version.

# Info

To use this plugin you need the following dependencies:

- <a href = https://github.com/SkriptLang>Skript
- <a href = https://github.com/LabyMod/labymod-server-api>LabyMod Server API
- <a href = https://github.com/dmulloy2/ProtocolLib>ProtocolLib

## Important Note
This plugin was developed for the version 1.20.4 and was tested with Paper and LabyMod Version 4.2

# Features

Here you can find the current supported features including syntax

| Name | Syntax | Description |
| ---- | ------ | ----------- |
| Playing Gamemode | ```make player send playing gamemode with name "&3MyServer.net"``` | Shows the playing gamemode to all Labymod friends in the top right corner if activated in the profile settings
| Recommend Addon | ```send addon with id "id" to be ("required"/"optional") to player``` | Sends a request for the player which shows optional or required addons. Only published addons! (List of addons: https://dl.labymod.net/addons.json) |
| Send to server | ```send player to server "hypixel.net" titled "Server Switch!" ("with"/"without") preview``` | Sends the player to anohter minecraft server |
| Send Server Banner | ```send server banner "link" to player``` | Sends the server banner to the player which is displayed over the tablist |
| Set Subtitle | ```set the subtitle of player to "&cHello" with size 1.2``` | Sets the subtitle to the given text. Accepted sizes: 0.8-1.6
| Remove Subtitle | ```remove subtitle of player``` | Removes the subtitle of the player



# Bugs

If you find any bugs you can create an issue in the issues tab in this repository.
I will try my best and fix it asap.
