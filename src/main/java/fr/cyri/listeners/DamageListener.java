package fr.cyri.listeners;

import fr.cyri.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if (event.getEntity() instanceof Player player) {
            EntityDamageEvent.DamageCause cause = event.getCause();

            MessageUtils.sendDamageSourceMessage(player, cause);
        }

    }
}
