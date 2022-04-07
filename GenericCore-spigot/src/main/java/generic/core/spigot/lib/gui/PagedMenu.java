package generic.core.spigot.lib.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PagedMenu implements Menu{

    private Inventory inventory;
    private int size;
    private String title;
    private int atualSlot = 10;
    private Map<Integer, ItemStack> itens = new HashMap<>();

    public PagedMenu(String title, int size){
        this.title = title;
        this.size = size;
        this.inventory = Bukkit.createInventory(null, size, title);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void open(Player player) {

    }
    @Override
    public void addItem(ItemStack stack){

    }
}
