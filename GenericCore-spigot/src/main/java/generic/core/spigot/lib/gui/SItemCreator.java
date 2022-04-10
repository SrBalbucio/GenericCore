package generic.core.spigot.lib.gui;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class SItemCreator {

    private ItemStack stack;

    public SItemCreator(Material m){
        this.stack = new ItemStack(m);
    }
    public SItemCreator(Material m, Integer amount){
        this.stack = new ItemStack(m, amount);
    }

    public SItemCreator create(String arguments){
        String[] config = arguments.split(";");
        stack.getItemMeta().setDisplayName(config[0]);
        stack.getItemMeta().setLore(Arrays.asList(config[1].split("--")));
        return this;
    }

    public SItemCreator translate(String path){
        return this;
    }

    public ItemStack get(){
        return stack;
    }
}
