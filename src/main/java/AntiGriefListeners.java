import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AntiGriefListeners implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);

        if (event.getPlayer().getGameMode() == GameMode.CREATIVE && event.getPlayer().hasPermission("hub.admin")) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onEntitySpawnEvent(EntitySpawnEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDamageEvent(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onStarvationEvent(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onTNTIgniteEvent(BlockIgniteEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        event.setJoinMessage("");
    }

    @EventHandler
    public void onDisconnectEvent(PlayerQuitEvent event) {
        event.setQuitMessage("");
    }

    @EventHandler
    public void noUproot(PlayerInteractEvent event) {
        if(event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.FARMLAND)
            event.setCancelled(true);
    }
}
