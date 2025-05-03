package com.chatdiscord;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String playerName = event.getPlayer().getName(); // Récupère le pseudo du joueur
        String message = event.getMessage(); // Récupère le message du joueur

        // Envoie le message à Discord avec le pseudo et l'avatar personnalisé
        DiscordWebhook.sendMessage(playerName, message);

            }
}
