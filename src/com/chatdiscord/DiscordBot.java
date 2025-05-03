package com.chatdiscord;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Bukkit;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {

    private final Main plugin;
    private JDA jda;

    public DiscordBot(Main plugin) {
        this.plugin = plugin;
        startBot();
    }

    private void startBot() {
        String token = plugin.getConfig().getString("token");
        if (token == null || token.isEmpty()) {
            plugin.getLogger().warning("Token Discord non défini !");
            return;
        }

        jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(this)
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String configuredChannelId = plugin.getConfig().getString("channel_id");
        if (configuredChannelId == null || !event.getChannel().getId().equals(configuredChannelId)) return;

        String author = event.getMember() != null && event.getMember().getNickname() != null
                ? event.getMember().getNickname()
                : event.getAuthor().getName();
        String rawContent = event.getMessage().getContentRaw();

        // Debug : Log l'événement complet
       // System.out.println("Message complet reçu: " + event.getMessage());
      //  System.out.println("Contenu brut : " + rawContent);

        if (rawContent.isEmpty()) {
            // Si aucun texte n'est trouvé, regarde si c'est un Embed ou une image
            if (!event.getMessage().getEmbeds().isEmpty()) {
                System.out.println("Message contient un embed");
            }
            if (!event.getMessage().getAttachments().isEmpty()) {
                System.out.println("Message contient des fichiers : " + event.getMessage().getAttachments());
            }
        }

        // Envoie le contenu du message ou une information utile
        Bukkit.getScheduler().runTask(plugin, () -> {
            Bukkit.broadcastMessage("§9[DISCORD] §f" + author + " - " + (rawContent.isEmpty() ? "[Message sans texte]" : rawContent));
        });
    }

    public void shutdown() {
        if (jda != null) {
            jda.shutdown();
        }
    }

    public JDA getJda() {
        return jda;
    }
}
