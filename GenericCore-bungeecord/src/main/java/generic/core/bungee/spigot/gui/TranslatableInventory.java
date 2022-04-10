package generic.core.bungee.spigot.gui;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;
import java.util.Map;

public class TranslatableInventory implements Inventory {

    private String title;
    private int size;
    private Map<Integer, Item> itens = new HashMap<>();

    public TranslatableInventory(String title, int size){
        this.title = title;
        this.size = size;
        for (int i = 0; i < size; i++) {
            itens.put(i, null);
        }
    }
    public void setItem(int slot, Item item){
        if(size >= slot && slot > 0){
            itens.replace(slot, item);
        }
    }
    public void addItem(Item item){
        for(Integer slot : itens.keySet()){
            if(itens.get(slot) == null){
                itens.replace(slot, item);
                break;
            }
        }
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setSize(int size){
        this.size = size;
    }

    @Override
    public Map<Integer, Item> getItens() {
        return itens;
    }

    @Override
    public String getTitle() {
        return title.replace("&", "§");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void destroy() {
        this.title = null;
        this.size = 0;
        this.itens = null;
    }

    @Override
    public void open(ProxiedPlayer player) {

        Inventory.super.open(player);
    }
}
