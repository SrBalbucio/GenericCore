package generic.core.spigot.lib.gui;

import generic.core.common.profile.profile.Profile;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class ProfileStack extends ItemStack {

    private Profile profile;

    public ProfileStack(Profile profile){
        super(Material.SKULL_ITEM);
        SkullMeta meta = (SkullMeta) super.getItemMeta();
        meta.setOwner(profile.getName());
        super.setItemMeta(meta);
        this.profile = profile;
    }

    public Profile getProfile(){
        return profile;
    }
    public ItemStack getItem(){
        return this;
    }
}
