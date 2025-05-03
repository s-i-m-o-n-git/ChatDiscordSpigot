# ChatDiscord
![Minecraft](https://img.shields.io/badge/Minecraft-1.12.2-green?style=for-the-badge&logo=minecraft)
![Spigot](https://img.shields.io/badge/Spigot-API-important?style=for-the-badge&logo=java)
![Discord](https://img.shields.io/badge/Discord-Webhook-7289DA?style=for-the-badge&logo=discord&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
![Build](https://img.shields.io/badge/Build-Success-brightgreen?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-8+-orange?style=for-the-badge&logo=java&logoColor=white)
![Contributions](https://img.shields.io/badge/Contributions-Welcome-brightgreen?style=for-the-badge)

## Description
**ChatDiscord** est un plugin Minecraft qui permet de synchroniser les messages du chat en jeu avec un salon Discord via un webhook. Les joueurs peuvent envoyer des messages qui apparaîtront dans Discord avec leur pseudo et un avatar personnalisé basé sur leur skin Minecraft.

---

## Fonctionnalités
- **Synchronisation du chat Minecraft vers Discord** : 
  Les messages des joueurs sont envoyés directement à un salon Discord via un webhook.
- **Avatar personnalisé** : 
  Affiche l'avatar du joueur dans Discord basé sur son skin Minecraft.
- **Configuration simple** : 
  Configurez rapidement l'URL du webhook Discord via un fichier `config.yml`.

---

## Installation for RELEASE
1. Téléchargez le fichier `.jar` du plugin.
2. Placez le fichier `.jar` dans le dossier `plugins` de votre serveur Minecraft.
3. Redémarrez le serveur ou rechargez les plugins avec la commande `/reload`.

## Compilation
1. Cloner le repertoire
2. Ouvrer le avec un IDE
3. Compiler le projet en rajoutant bien le plugin.yml dans la racine du .jar ainsi que spigot-1.12.2.jar en lib

---

## Configuration
Lors du premier démarrage, un fichier `config.yml` est généré dans le dossier `plugins/ChatDiscord`. 

### Exemple de fichier `config.yml` :
```yaml
webhook: "https://discord.com/api/webhooks/..."
```

- Remplacez `https://discord.com/api/webhooks/...` par l'URL de votre webhook Discord.
- Sauvegardez le fichier.
- Rechargez le plugin avec la commande `/reload`.

---

## Commandes
| Commande            | Description                            | Permission requise |
|---------------------|----------------------------------------|--------------------|
| `/showchatwebhook`  | Affiche l'URL du webhook configuré.    | OP                 |

---



---

## Développement
Ce plugin a été développé avec **Spigot API 1.12.2**.

### Structure du projet
- **Main** : Gère l'activation et la désactivation du plugin.
- **OnStart** : Initialise la configuration et vérifie les paramètres.
- **ChatListener** : Écoute les messages du chat Minecraft.
- **ShowWebhook** : Affiche l'URL du webhook via une commande.
- **DiscordWebhook** : Gère l'envoi des messages au webhook Discord.

---

## Prochaines améliorations
- Ajout de la synchronisation bidirectionnelle (Discord vers Minecraft).
- Support pour plusieurs webhooks.
- Commandes supplémentaires pour reconfigurer le webhook en jeu.

---

## Auteur
Plugin développé par **sim62149**.

---


