package generic.core.spigot.lib.gui;

import org.bukkit.inventory.Inventory;

public interface Menu {

    Inventory getInventory();
    Integer getSize();
    String getTitle();
}
