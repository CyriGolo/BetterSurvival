package fr.cyri;

import fr.cyri.commands.HomeCommand;
import fr.cyri.commands.HomesCommand;
import fr.cyri.commands.RemoveHomeCommand;
import fr.cyri.commands.SetHomeCommand;
import fr.cyri.listeners.ChatListener;
import fr.cyri.listeners.DamageListener;
import fr.cyri.listeners.JoinListener;
import fr.cyri.managers.HomeManager;
import fr.cyri.tasks.ItemSpawnTask;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BetterSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("BetterSurvival has been enabled!");

        World world = getServer().getWorld("world");

        HomeManager homeManager = new HomeManager();

        // Commands
        Objects.requireNonNull(getCommand("sethome")).setExecutor(new SetHomeCommand(homeManager));
        Objects.requireNonNull(getCommand("home")).setExecutor(new HomeCommand(homeManager));
        Objects.requireNonNull(getCommand("homes")).setExecutor(new HomesCommand(homeManager));
        Objects.requireNonNull(getCommand("removehome")).setExecutor(new RemoveHomeCommand(homeManager));

        // Listeners
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);

        // Tasks
        new ItemSpawnTask(world, new Location(world, 0, 80, 0), Material.DIAMOND).runTaskTimer(this, 0L, 100L);
    }

    @Override
    public void onDisable() {
        getLogger().info("BetterSurvival has been disabled!");
    }
}
