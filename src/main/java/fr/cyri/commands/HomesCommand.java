package fr.cyri.commands;

import fr.cyri.managers.HomeManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class HomesCommand implements CommandExecutor {
    private final HomeManager homeManager;

    public HomesCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Cette commande ne peut être utilisée que par un joueur !");
            return true;
        }

        Map<String, Location> homes = homeManager.getHomes(player);

        if (homes.isEmpty()) {
            player.sendMessage(ChatColor.RED + "Vous n'avez pas de homes définis !");
            return true;
        }

        player.sendMessage(ChatColor.GREEN + "Vos homes :");
        for (String homeName : homes.keySet()) {
            player.sendMessage(ChatColor.YELLOW + "- " + homeName);
        }

        return true;
    }
}
