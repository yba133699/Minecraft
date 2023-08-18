package ch.yannic.survivalplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onPlayerDamageEvent(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
        if (GodCommand.getGodMode().contains(p)) {
            e.setCancelled(true);
        }
    }

}
