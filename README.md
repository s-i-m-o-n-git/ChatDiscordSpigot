# ChatDiscord
![Minecraft](https://img.shields.io/badge/Minecraft-1.12.2-green?style=for-the-badge&logo=minecraft)
![Spigot](https://img.shields.io/badge/Spigot-API-important?style=for-the-badge&logo=java)
![Discord](https://img.shields.io/badge/Discord-Webhook-7289DA?style=for-the-badge&logo=discord&logoColor=white)
![Discord](https://img.shields.io/badge/Discord-Bot-7289DA?style=for-the-badge&logo=discord&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
![Build](https://img.shields.io/badge/Build-Success-brightgreen?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-8+-orange?style=for-the-badge&logo=java&logoColor=white)
![Contributions](https://img.shields.io/badge/Contributions-Welcome-brightgreen?style=for-the-badge)


Un plugin Minecraft (Spigot/Paper) qui synchronise le chat Minecraft avec Discord en utilisant un Webhook et un bot Discord via JDA.

## ✨ Fonctionnalités

* 📡 Envoie les messages du chat Minecraft vers un Webhook Discord.
* 🔁 Affiche les messages d’un salon Discord dans le chat Minecraft.
* 📡 Envoie les messages du salon Dsicord vers le chat Minecraft.
* 🔔 Notifications de connexion/déconnexion des joueurs.
* 🔔 Notifications quand le serveur se démarre et s'arréte.
* 🔧 Création automatique du fichier `config.yml`.
* 🛠️ Commande `/showchatwebhook` pour afficher le Webhook actuel (réservée aux opérateurs).

---

## 📁 Installation

1. Télécharge le fichier `.jar` compilé du plugin (voir plus bas si tu dois le compiler toi-même). ( ou dans les releases v2 )
2. Place-le dans le dossier `plugins/` de ton serveur Minecraft Spigot ou Paper.
3. Redémarre le serveur.
4. Configure le fichier `config.yml` généré dans `plugins/ChatDiscord/`.

---

## 🔧 Configuration (`config.yml`)

```yaml
webhook: "https://discord.com/api/webhooks/..."
token: "TON_TOKEN_BOT_DISCORD"
server_id: "ID_DU_SERVEUR_DISCORD"
channel_id: "ID_DU_CHANNEL_DISCORD"
```

### Description des champs

* **webhook** : URL du Webhook Discord pour recevoir les messages de Minecraft.
* **token** : Token du bot Discord (nécessaire pour que le bot puisse lire les messages Discord).
* **server\_id** : ID de ton serveur Discord.
* **channel\_id** : ID du salon Discord où le bot lit les messages.

---

## 🧑‍💻 Compilation du plugin (IntelliJ IDEA)

### ✅ Prérequis

* Java JDK 8 ou supérieur
* IntelliJ IDEA
* Spigot (`spigot-1.12.2.jar`)
* [JDA 5.5.0](https://github.com/DV8FromTheWorld/JDA/releases) avec dépendances ( ou autre si vous modifez )

### 📆 Structure du projet

Place les fichiers `.jar` suivants dans un dossier `lib/` à la racine du projet ( comme dans le repo github ) :

```
/lib/
  ├— spigot-1.12.2.jar
  └— JDA-5.5.0-withDependencies.jar
```

### ⚙️ Configuration de l'artifact (via IntelliJ)

Dans IntelliJ IDEA :

1. Va dans **File > Project Structure > Artifacts**.
2. Clique sur le `+` et sélectionne **JAR > From modules with dependencies**.
3. Nomme l'artifact : `ChatDiscord:jar`.
4. Coche **Include in project build**.
5. Dans la structure de l'artifact, ajoute :

   * Output module: `ChatDiscord`
   * `lib/spigot-1.12.2.jar` → extrait dans le `.jar`
   * `lib/JDA-5.5.0-withDependencies.jar` → extrait dans le `.jar`
   * `plugin.yml` → copié dans la racine du `.jar`
6. Spécifie l’output path (exemple) ( si besoin ) :

   ```
   $PROJECT_DIR$/out/artifacts/ChatDiscord_jar
   ```

Voici un extrait XML de la configuration d’artifact générée automatiquement par IntelliJ :

```xml
<component name="ArtifactManager">
  <artifact type="jar" name="ChatDiscord:jar">
    <output-path>$PROJECT_DIR$/out/artifacts/ChatDiscord_jar</output-path>
    <root id="archive" name="ChatDiscord.jar">
      <element id="module-output" name="ChatDiscord" />
      <element id="extracted-dir" path="$PROJECT_DIR$/lib/spigot-1.12.2.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$PROJECT_DIR$/lib/JDA-5.5.0-withDependencies.jar" path-in-jar="/" />
      <element id="file-copy" path="$PROJECT_DIR$/plugin.yml" />
    </root>
  </artifact>
</component>
```

Une fois configuré :

* Compile via **Build > Build Artifacts > ChatDiscord**\*\*:jar\*\*\*\* > Build\*\*.
* Ton `.jar` final sera dans `out/artifacts/ChatDiscord_jar/ChatDiscord.jar`.

---

## 🕹️ Commandes

| Commande           | Description                           | Permission    |
| ------------------ | ------------------------------------- | ------------- |
| `/showchatwebhook` | Affiche l'URL du webhook dans le chat | OP uniquement |

---

## 📌 Remarques importantes

* Ton bot Discord doit avoir les **Intentions activées** sur le portail développeur (MESSAGE\_CONTENT).
* Le plugin ne dépend d'aucune base de données.
* Le système est autonome avec JDA et les Webhooks Discord.

---

## 🧑‍💻 Auteur

Développé par **Simon**
Reversé, maintenu et amélioré depuis des fichiers `.class`.

---

## 📄 Licence

Ce projet est open-source. Tu peux le modifier ou le redistribuer librement. Un crédit est toujours apprécié 😊


