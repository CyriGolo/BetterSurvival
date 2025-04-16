package fr.cyri.tasks;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ItemSpawnTask extends BukkitRunnable {

    private final World world;
    private final Location location;
    private final Material itemStack;

    public ItemSpawnTask(World world, Location location, Material itemStack) {
        this.world = world;
        this.location = location;
        this.itemStack = itemStack;
    }

    @Override
    public void run() {
        ItemStack item = new ItemStack(itemStack);

        world.dropItem(location, item);
    }
}
