package generic.core.bungee.spigot.gui;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import generic.core.bungee.listener.events.InventoryOpenedEvent;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.*;

public interface Inventory {

    Map<Integer, Item> getItens();
    String getTitle();
    int getSize();
    void destroy();

    default void open(ProxiedPlayer player){
        for(Item item : getItens().values()){
            if(item instanceof TranslatableItem){
                ((TranslatableItem) item).translate(player);
            }
        }
        InventoryOpenedEvent event = new InventoryOpenedEvent(this, player);
        ProxyServer.getInstance().getPluginManager().callEvent(event);
        if(event.isCancelled()) { return; }
        String inv = getTitle() + "-//-"+getSize();
        Map<Integer, Item> itens = getItens();
        for(Integer i : itens.keySet()){
            inv = inv+"-//-"+i+"-+-"+itens.get(i).getMessage();
        }
        ByteArrayDataOutput data = ByteStreams.newDataOutput();
        data.writeUTF("InventoryCreator");
        data.writeUTF(inv);
        player.sendData("GenericCore", data.toByteArray());
    }
}
