package generic.core.common.plugin;

public interface GenericPlugin {

    String getName();
    Class getMain();
    Integer getVersion();
    PluginType getType();

    enum PluginType{
        SPIGOT, BUNGEE, COMMON, MAGMA
    }
}
