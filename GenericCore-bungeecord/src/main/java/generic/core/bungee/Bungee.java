package generic.core.bungee;

import generic.core.bungee.database.DatabaseManager;
import generic.core.bungee.lib.file.FileConfig;
import generic.core.common.language.LanguageManager;
import generic.core.common.logger.CoreLogger;
import generic.core.common.plugin.GenericPlugin;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;
import java.util.logging.Level;


public final class Bungee extends Plugin implements GenericPlugin{

    private static CoreLogger log = new CoreLogger(Bungee.class, "Core");
    private static Bungee instance;
    public LanguageManager lang;
    public DatabaseManager database;

    @Override
    public void onEnable() {
        setInstance(this);
        database.connectAll();
        log.start(Level.INFO, "O plugin foi iniciado com sucesso!");
    }

    @Override
    public void onLoad(){
        lang = new LanguageManager(new File("plugins/GenericCore/Languages"), new FileConfig());
        database = new DatabaseManager(this);
    }

    @Override
    public void onDisable() {
        log.stop(Level.INFO, "O plugin foi desativado com sucesso!");
    }

    public static CoreLogger getCoreLogger() {
        return log;
    }

    public static Bungee get() {
        return instance;
    }

    public static void setInstance(Bungee instance) {
        Bungee.instance = instance;
    }

    @Override
    public String getName() {
        return "GenericCore";
    }

    @Override
    public Class getMain() {
        return this.getClass();
    }

    @Override
    public Integer getVersion() {
        return 1;
    }

    @Override
    public GenericPlugin.PluginType getType() {
            return GenericPlugin.PluginType.BUNGEE;
    }
}
