package generic.core.bungee;

import generic.core.bungee.database.DatabaseManager;
import generic.core.bungee.lib.language.Language;
import generic.core.bungee.lib.language.LanguageManager;
import generic.core.common.logger.CoreLogger;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;


public final class Bungee extends Plugin {

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
        lang = new LanguageManager();
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
}
