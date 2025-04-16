package fr.cyri.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class MessageUtils {
    public static void sendWelcomeMessage(Player player) {
        TextComponent message = new TextComponent(ChatColor.GRAY + "Bienvenue "
                + ChatColor.GREEN + player.getName()
                + ChatColor.GRAY + " sur le serveur survie !");

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, message);
    }

    public static String formatMessage(String author, String message) {
        return ChatColor.GREEN + author + ChatColor.RESET + ": " + message;
    }

    public static void sendDamageSourceMessage(Player player, EntityDamageEvent.DamageCause cause) {
        String message = "Vous avez été blessé par " + cause.toString().toLowerCase().replace("_", " ");
        player.sendMessage(ChatColor.RED + message);
    }
}