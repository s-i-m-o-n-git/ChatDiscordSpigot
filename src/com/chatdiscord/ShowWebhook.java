package com.chatdiscord;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ShowWebhook implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("showchatwebhook")) {
            // Vérifie si l'expéditeur de la commande est un joueur et s'il est OP
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (!player.isOp()) {
                    player.sendMessage("Vous devez être opérateur pour exécuter cette commande.");
                    return false;
                }
            }

            // Récupère la configuration depuis l'instance du plugin
            FileConfiguration config = Main.getInstance().getConfig();
            String webhook = config.getString("webhook", "Non configuré !");
            commandSender.sendMessage("Webhook actuel : " + webhook); // Utilise commandSender ici
            return true;
        }
        return false;
    }
}
