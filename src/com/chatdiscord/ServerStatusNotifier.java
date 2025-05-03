package com.chatdiscord;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerStatusNotifier extends JavaPlugin {

    @Override
    public void onEnable() {
        // Envoie un message à Discord lorsque le plugin est activé
        DiscordWebhook.sendMessage("Serveur", "<:plus:1368294153586343936> **| Le serveur vient de démarrer !**");
    }

    @Override
    public void onDisable() {
        // Envoie un message à Discord lorsque le plugin est désactivé
        DiscordWebhook.sendMessage("Serveur", "<:moins:1368294154907685025> **| Le serveur est en train de s'éteindre...**");
    }
}
