package com.chatdiscord;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeaveListener implements Listener {

    // Lorsque un joueur rejoint le serveur
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName(); // Récupère le pseudo du joueur

        // Envoie un message à Discord avec l'emoji "plus" et le nom du joueur
        // Exemple : DiscordWebhook.sendMessage(emoji, message)
        DiscordWebhook.sendMessage(playerName, "<:plus:1368294153586343936> **| " + playerName + " a rejoint le serveur**");
    }

    // Lorsque un joueur quitte le serveur
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName(); // Récupère le pseudo du joueur

        // Envoie un message à Discord avec l'emoji "moins" et le nom du joueur
        // Exemple : DiscordWebhook.sendMessage(emoji, message)
        DiscordWebhook.sendMessage(playerName, "<:moins:1368294154907685025> **| "+  playerName + " a quitté le serveur**");
    }
}
