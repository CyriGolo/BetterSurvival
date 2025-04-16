package fr.cyri.commands;

import fr.cyri.managers.HomeManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private final HomeManager homeManager;

    public SetHomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Cette commande ne peut être utilisée que par un joueur !");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Commande: /sethome <nom>");
            return false;
        }

        String homeName = args[0];
        Location location = player.getLocation();

        homeManager.setHome(player, homeName, location);

        player.sendMessage(ChatColor.GREEN + "Home '" + homeName + "' défini avec succès !");
        return true;
    }
}