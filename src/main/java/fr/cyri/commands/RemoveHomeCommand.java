package fr.cyri.commands;

import fr.cyri.managers.HomeManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveHomeCommand implements CommandExecutor {
    private final HomeManager homeManager;

    public RemoveHomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Cette commande ne peut être utilisée que par un joueur !");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Commande: /removehome <nom>");
            return false;
        }

        String homeName = args[0];

        homeManager.removeHome(player, homeName);

        player.sendMessage(ChatColor.GREEN + "Home '" + homeName + "' supprimé avec succès !");
        return true;
    }
}
