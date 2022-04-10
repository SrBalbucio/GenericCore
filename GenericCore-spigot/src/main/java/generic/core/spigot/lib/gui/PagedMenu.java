package generic.core.spigot.lib.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class PagedMenu implements Menu{

    private Inventory inventory;
    private String title;
    private int atualSlot = 10;
    private int page = 1;
    private int init = 1;
    private int finalize = 21;
    private int itemCount = 1;
    private List<ItemStack> itens = new ArrayList<>();


    public PagedMenu(String title){
        this.title = title;
        this.inventory = Bukkit.createInventory(null, 9*6, title);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public Integer getSize() {
        return 9*6;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void open(Player player) {
        inventory.clear();
        prepareItens();
        player.openInventory(inventory);
    }
    @Override
    public void addItem(ItemStack stack){
        itens.add(stack);
    }

    private void prepareItens(){
        atualSlot = 10;
        finalize = 21 * page;
        init = finalize - 21;
        itemCount = 0;
        for(ItemStack stack : itens) {
            if(itemCount == finalize){ break; }
            if(itemCount < init) { return; }
            if (Arrays.asList(17, 18, 26, 27).contains(atualSlot)) {
                atualSlot += 2;
            }
            inventory.setItem(atualSlot, stack);
        }
        inventory.setItem(47, new SItemCreator(Material.ARROW, 1).create("").get());
        inventory.setItem(51, new SItemCreator(Material.ARROW, 1).create("").get());
    }

    @EventHandler
    public void onClick(InventoryClickEvent evt){
        if(evt.getClickedInventory() == this.inventory){

        }
    }

}
