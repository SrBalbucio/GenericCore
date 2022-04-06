package generic.core.spigot.bungee;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BungeeCreator {

    public static void openInventory(Player player, String arguments){
        String[] info = arguments.split("-//-");
        String title = info[0];
        int size = Integer.parseInt(info[1]);
        Inventory inv = Bukkit.createInventory(null, size, title);
        for (int i = 2; i < info.length; i++) {
            String[] pitem = info[i].split("-+-");
            String[] item = pitem[1].split("$");
            ItemStack stack = new ItemStack(Material.getMaterial(item[2]), Integer.parseInt(item[1]));
            stack.getItemMeta().setDisplayName(item[0]);
            stack.getItemMeta().setLore(Arrays.asList(item[4].split("//")));
            inv.setItem(Integer.parseInt(pitem[0]), stack);
        }
        player.openInventory(inv);
    }
}
