package generic.core.spigot.database;

import generic.core.common.database.Database;
import generic.core.common.database.DatabaseType;
import generic.core.spigot.Spigot;
import generic.core.spigot.lib.file.FileConfig;

import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;

public class DatabaseManager {

    public Spigot spigot;
    private FileConfig config;
    public Database connection;
    public Database backup;
    public boolean connected;
    public boolean inited;

    public DatabaseManager(Spigot spigot){
        this.spigot = spigot;
        config = new FileConfig(new File("plugins/GenericCore", "bungee-database.yml"), spigot.getResource("bungee-database.yml"));
        Spigot.getCoreLogger().start(Level.INFO, "§bConfiguração do Database §acarregada com sucesso!");
        inited = true;
        try {
            String dtbString = config.getString("database").toLowerCase(Locale.ROOT);
            DatabaseType dtbType = DatabaseType.valueOf(config.getString("database").toUpperCase(Locale.ROOT));

            String args = null;

            Map<String, ?> keys = config.getPathKeys("dbconfig." + dtbString);

            for (String k : keys.keySet()) {
                if (args == null) {
                    args =  keys.get(k).toString();
                } else {
                    args = args + ":" + keys.get(k).toString();
                }
            }

            Spigot.getCoreLogger().start(Level.INFO, "§aO §bDatabase §aselecionado foi: §e"+dtbString);
            connection = dtbType.getConnection(args.split(":"));
        } catch (Exception e){
            inited = false;
            e.printStackTrace();
            Spigot.getCoreLogger().erro(Level.SEVERE, "O Loading do Database apresentou erros severos! Reconfigure e tente novamente!");
        }

        try {
            String dtbString = config.getString("backup").toLowerCase(Locale.ROOT);
            DatabaseType dtbType = DatabaseType.valueOf(config.getString("backup").toUpperCase(Locale.ROOT));
            if(dtbType.isValidBackupType()){
                backup = dtbType.getConnection(null);
            }
            Spigot.getCoreLogger().start(Level.INFO, "§aO §bDatabase Backup §aselecionado foi: §e"+dtbString);
        } catch (Exception e){
            inited = false;
            e.printStackTrace();
            Spigot.getCoreLogger().erro(Level.SEVERE, "O Loading do Database Backup apresentou erros severos! Reconfigure e tente novamente!");
        }
    }

    public void connectAll(){
        if(inited != true) { return; }
        backup.connect();
        connection.connect();
    }
}
