package com.chatdiscord;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class OnStart {

    private final JavaPlugin plugin;

    // Constructeur prenant l'instance du plugin
    public OnStart(JavaPlugin plugin) {
        this.plugin = plugin;
        initializeConfig(); // Appelle l'initialisation de la configuration
    }

    // Initialise la configuration
    private void initializeConfig() {
        // Vérifie si le dossier du plugin existe, sinon le crée
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists() && dataFolder.mkdir()) {
            plugin.getLogger().info("Dossier du plugin créé !");
        }

        // Vérifie si le fichier config.yml existe, sinon le crée dynamiquement
        File configFile = new File(dataFolder, "config.yml");
        if (!configFile.exists()) {
            try (PrintWriter writer = new PrintWriter(configFile)) {
                writer.println("webhook: \"\"");
                writer.println("token: \"\"");
                writer.println("server_id: \"\"");
                writer.println("channel_id: \"\"");
                plugin.getLogger().info("Le fichier config.yml a été créé !");
            } catch (IOException e) {
                plugin.getLogger().severe("Impossible de créer le fichier config.yml !");
                e.printStackTrace();
            }
        }

        // Charge la configuration
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();

        // Ajoute les champs manquants si besoin
        boolean save = false;
        if (!config.contains("webhook")) {
            config.set("webhook", "");
            save = true;
        }
        if (!config.contains("token")) {
            config.set("token", "");
            save = true;
        }
        if (!config.contains("server_id")) {
            config.set("server_id", "");
            save = true;
        }
        if (!config.contains("channel_id")) {
            config.set("channel_id", "");
            save = true;
        }
        if (save) {
            plugin.saveConfig();
            plugin.getLogger().info("Champs manquants ajoutés dans la configuration.");
        }

        // Affiche les infos utiles dans la console
        plugin.getLogger().info("Webhook actuel : " + config.getString("webhook"));
        plugin.getLogger().info("Token Discord : " + (config.getString("token").isEmpty() ? "(non défini)" : "(défini)"));
        plugin.getLogger().info("Server ID : " + config.getString("server_id"));
        plugin.getLogger().info("Channel ID : " + config.getString("channel_id"));
    }

    // Récupère le webhook depuis la configuration
    public String getWebhook() {
        return plugin.getConfig().getString("webhook", "");
    }

    // Met à jour le webhook dans la configuration
    public void setWebhook(String webhook) {
        FileConfiguration config = plugin.getConfig();
        config.set("webhook", webhook);
        plugin.saveConfig();
        plugin.getLogger().info("Webhook mis à jour : " + webhook);
    }
}
