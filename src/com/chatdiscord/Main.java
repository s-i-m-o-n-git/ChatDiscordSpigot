package com.chatdiscord;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    private DiscordBot discordBot;

    @Override
    public void onEnable() {
        instance = this;

        // Initialisation du bot Discord
        discordBot = new DiscordBot(this);

        // ✅ Message de démarrage envoyé à Discord
        DiscordWebhook.sendMessage("Serveur", "<:plus:1368294153586343936> **| Le serveur vient de démarrer !**");

        getLogger().info("Le plugin ChatDiscord a été activé !");

        // Initialisation de la config
        OnStart configManager = new OnStart(this);

        // Enregistrement des événements et commandes
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(), this);
        getCommand("showchatwebhook").setExecutor(new ShowWebhook());
    }

    @Override
    public void onDisable() {
        // ✅ Message d’arrêt envoyé à Discord
        DiscordWebhook.sendMessage("Serveur", "<:moins:1368294154907685025> **| Le serveur est en train de s'éteindre...**");

        if (discordBot != null) {
            discordBot.shutdown();
        }

        getLogger().info("Le plugin ChatDiscord a été désactivé.");
    }
}
