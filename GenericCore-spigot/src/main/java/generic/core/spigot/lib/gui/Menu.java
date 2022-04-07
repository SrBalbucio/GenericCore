package generic.core.spigot.lib.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface Menu {

    Inventory getInventory();
    Integer getSize();
    String getTitle();
    void addItem(ItemStack stack);
    void open(Player player);
}
