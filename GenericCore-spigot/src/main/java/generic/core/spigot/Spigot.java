package generic.core.spigot;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import generic.core.common.logger.CoreLogger;
import generic.core.spigot.listener.events.PluginMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class Spigot extends JavaPlugin implements PluginMessageListener {

    public static Spigot instance;
    public static CoreLogger log = new CoreLogger(Spigot.class, "Core");

    @Override
    public void onEnable() {
        setInstance(this);
        loadChannels();
    }

    @Override
    public void onLoad(){

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadChannels(){
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "GenericCore", this);
    }

    public static Spigot getInstance() {
        return instance;
    }

    public static void setInstance(Spigot instance) {
        Spigot.instance = instance;
    }

    public static CoreLogger getCoreLogger() {
        return log;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("GenericCore")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        PluginMessageEvent pluginMessage = new PluginMessageEvent(player, in.readUTF(), in.readUTF());
        Bukkit.getPluginManager().callEvent(pluginMessage);
    }
}
