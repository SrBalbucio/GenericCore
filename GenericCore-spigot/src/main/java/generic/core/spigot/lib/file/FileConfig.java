package generic.core.spigot.lib.file;

import generic.core.common.lib.file.Config;
import generic.core.spigot.Spigot;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class FileConfig implements Config {

    private File file;
    private YamlConfiguration config;
    private InputStream stream;
    public FileConfig(File file){
        this.file = file;
        createNew();
        load();
    }
    public FileConfig(){}
    public FileConfig(File file, InputStream stream){
        this.file = file;
        this.stream = stream;
        if (!file.exists()) {
            File folder = new File(file.getParent());
            if (!folder.exists()) {
                folder.mkdir();
            }
            try {
                Files.copy(stream, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
                Spigot.getCoreLogger().erro(Level.WARNING, "Ocorreu um problema ao copiar o arquivo: §f"+file.getName());
            }
        }
        load();
    }


    private void createNew(){
        try {
            if (!file.exists()) {
                File folder = new File(file.getParent());
                if (!folder.exists()) {
                    folder.mkdir();
                }
                file.createNewFile();
            }
        } catch (Exception e){
            e.printStackTrace();
            Spigot.getCoreLogger().erro(Level.WARNING, "O arquivo §f"+file.getName()+" §4não foi criado com sucesso!");
        }
    }

    @Override
    public void load() {
        try{
            this.config = YamlConfiguration.loadConfiguration(file);
        } catch(Exception e){
            e.printStackTrace();
            Spigot.getCoreLogger().erro(Level.WARNING, "O arquivo §f"+file.getName()+" §4não foi carregado com sucesso!");
        }
    }

    @Override
    public void insert(String path, Object value) {
        this.config.set(path, value);
        save();
    }

    @Override
    public void insertString(String path, String value) {
        this.config.set(path, value);
        save();
    }

    @Override
    public void insertInt(String path, Integer value) {
        this.config.set(path, value);
        save();
    }

    @Override
    public void insertBoolean(String path, Boolean value) {
        this.config.set(path, value);
        save();
    }

    @Override
    public void insetList(String key, List<?> value) {
        this.config.set(key, value);
        save();
    }

    @Override
    public Object get(String path) {
        return config.get(path);
    }

    @Override
    public String getString(String path) {
        return config.getString(path);
    }

    @Override
    public Integer getInt(String path) {
        return config.getInt(path);
    }

    @Override
    public Boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    @Override
    public boolean contains(String path) {
        return config.contains(path);
    }

    @Override
    public List<?> getList(String path) {
        return config.getList(path);
    }

    @Override
    public Collection<String> getKeys() {
        return config.getKeys(false);
    }

    @Override
    public Map<String, ?> getPathKeys(String path) {
        if(!config.contains(path)) { return null; }
        Map<String, Object> paths = new HashMap<>();
        for(String key : config.getConfigurationSection(path).getKeys(false)){
            paths.put(key, config.getConfigurationSection(path).get(key));
        }
        return paths;
    }

    @Override
    public Config generate(File file) {
        return new FileConfig(file);
    }

    @Override
    public void save() {
        try {
            this.config.save(file);
        } catch (Exception e){
            e.printStackTrace();
            Spigot.getCoreLogger().erro(Level.WARNING, "O arquivo §f"+file.getName()+" §4não pode ser salvo!");
        }
    }
}
