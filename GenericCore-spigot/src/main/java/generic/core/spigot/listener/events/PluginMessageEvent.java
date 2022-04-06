package generic.core.spigot.listener.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PluginMessageEvent extends Event {

    private Player player;
    private String subchannel;
    private String arguments;
    private boolean hasCancelled;

    public PluginMessageEvent(Player player, String subchannel, String arguments){
        this.player = player;
        this.subchannel = subchannel;
        this.arguments = arguments;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public String getArguments(){
        return arguments;
    }

    public String getSubChannel(){
        return subchannel;
    }

    public void setCancelled(boolean cancelled){
        hasCancelled = cancelled;
    }

    public boolean isCancelled(){
        return hasCancelled;
    }

    public Player getPlayer(){
        return player;
    }
}
