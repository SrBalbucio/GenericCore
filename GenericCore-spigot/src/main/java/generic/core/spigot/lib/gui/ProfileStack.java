package generic.core.spigot.lib.gui;

import org.bukkit.inventory.ItemStack;
import sun.java2d.cmm.Profile;

public class ProfileStack extends ItemStack {

    private Profile profile;
    private ItemStack item;

    public ProfileStack(Profile prof){
        this.profile = prof;
    }

    public ItemStack getItem(){
        return item;
    }
}
