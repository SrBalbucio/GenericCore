package generic.core.bungee.listener.events;

import generic.core.bungee.spigot.gui.Inventory;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Event;

public class InventoryOpenedEvent extends Event {
    private Inventory inventory;
    private ProxiedPlayer player;

    private boolean isCancelled;

    public InventoryOpenedEvent(Inventory inv, ProxiedPlayer player){
        this.inventory = inv;
        this.player = player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ProxiedPlayer getPlayer() {
        return player;
    }

    public void setPlayer(ProxiedPlayer player) {
        this.player = player;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
