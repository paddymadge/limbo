import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new AntiGriefListeners(), this);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getTo().getBlockY() < 0) {
            event.getPlayer().teleport(new Location(Bukkit.getWorld("world"), 0.483, 35, 0.624));
        }
    }
}
