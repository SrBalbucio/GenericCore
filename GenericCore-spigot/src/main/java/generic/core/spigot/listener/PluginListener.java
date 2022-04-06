package generic.core.spigot.listener;

import generic.core.spigot.bungee.BungeeCreator;
import generic.core.spigot.listener.events.PluginMessageEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PluginListener implements Listener {

    @EventHandler
    public void onMessage(PluginMessageEvent evt){
        String channel = evt.getSubChannel();
        String arguments = evt.getArguments();
        Player player = evt.getPlayer();
        if(channel.equalsIgnoreCase("InventoryCreator")){
            BungeeCreator.openInventory(player, arguments);
            return;
        }
    }
}
