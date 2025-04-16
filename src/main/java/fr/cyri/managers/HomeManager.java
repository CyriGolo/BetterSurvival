package fr.cyri.managers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HomeManager {
    private final Map<UUID, Map<String, Location>> playerHomes;

    public HomeManager() {
        this.playerHomes = new HashMap<>();
    }

    public void setHome(Player player, String homeName, Location location) {
        UUID playerUUID = player.getUniqueId();

        if (!playerHomes.containsKey(playerUUID)) {
            playerHomes.put(playerUUID, new HashMap<>());
        }

        playerHomes.get(playerUUID).put(homeName, location);
    }

    public Location getHome(Player player, String homeName) {
        UUID playerUUID = player.getUniqueId();

        if (!playerHomes.containsKey(playerUUID)) {
            return null;
        }

        return playerHomes.get(playerUUID).get(homeName);
    }

    public boolean doesNotHaveHome(Player player, String homeName) {
        UUID playerUUID = player.getUniqueId();

        return playerHomes.containsKey(playerUUID) && playerHomes.get(playerUUID).containsKey(homeName);
    }

    public void removeHome(Player player, String homeName) {
        UUID playerUUID = player.getUniqueId();

        if (playerHomes.containsKey(playerUUID)) {
            playerHomes.get(playerUUID).remove(homeName);
        }
    }

    public Map<String, Location> getHomes(Player player) {
        UUID playerUUID = player.getUniqueId();

        if (!playerHomes.containsKey(playerUUID)) {
            return new HashMap<>();
        }

        return playerHomes.get(playerUUID);
    }
}
