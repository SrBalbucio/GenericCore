package generic.core.bungee.listener;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PostLoginEvent evt){
        ProxiedPlayer player = evt.getPlayer();
    }

    @EventHandler
    public void onQuit(PlayerDisconnectEvent evt){
        ProxiedPlayer player = evt.getPlayer();
    }

}
