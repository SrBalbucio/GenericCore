package generic.core.bungee.spigot.gui;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.HashMap;

public class TranslatableItem implements Item {
    private Integer id;
    private Integer amount;
    private String name;
    private String path;
    private String[] lore;

    public TranslatableItem(String path, int amount, int id){
        this.path = path;
        this.amount = amount;
        this.id = id;
    }
    public void translate(ProxiedPlayer player){

    }
    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getLore() {
        return lore;
    }
}
