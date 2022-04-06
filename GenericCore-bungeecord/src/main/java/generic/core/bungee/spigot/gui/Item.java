package generic.core.bungee.spigot.gui;

public interface Item {

    Integer getID();
    Integer getAmount();
    String getName();
    String[] getLore();

    default String getMessage(){
        String lored = "";
        for(String l : getLore()){
            lored = lored + "//" + l;
        }
        return getName()+"$"+getAmount()+"$"+getID()+"$"+lored;
    }
}
