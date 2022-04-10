package generic.core.bungee.lib.file;

import generic.core.bungee.Bungee;
import generic.core.common.lib.file.Config;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;

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

    private Configuration config;
    private File file;
    private InputStream stream;

    public FileConfig(File file) {
        this.file = file;
        createNew();
        load();
    }

    public FileConfig(){

    }
    public FileConfig(File file, InputStream resource){
        this.file = file;
        this.stream = resource;
        if (!file.exists()) {
            File folder = new File(file.getParent());
            if (!folder.exists()) {
                folder.mkdir();
            }
            try {
                Files.copy(resource, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
                Bungee.getCoreLogger().erro(Level.WARNING, "Ocorreu um problema ao copiar o arquivo: §f"+file.getName());
            }
        }
        load();
    }

    private void createNew(){
        try {
            if (!file.exists()) {
                File folder = new File(file.getPath());
                if (!folder.exists()) {
                    folder.mkdir();
                }
                file.createNewFile();
            }
        } catch (Exception e){
            e.printStackTrace();
            Bungee.getCoreLogger().erro(Level.WARNING, "O arquivo §f"+file.getName()+" §4não foi criado com sucesso!");
        }
    }

    @Override
    public void load() {
        try {
            this.config = YamlConfiguration.getProvider(YamlConfiguration.class).load(file);
        } catch(Exception e){
            e.printStackTrace();
            Bungee.getCoreLogger().erro(Level.WARNING, "O arquivo §f"+file.getName()+" §4não foi carregado com sucesso!");
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
    }

    @Override
    public Object get(String path) {
        return this.config.get(path);
    }

    @Override
    public String getString(String path) {
        return this.config.getString(path);
    }

    @Override
    public Integer getInt(String path) {
        return this.config.getInt(path);
    }

    @Override
    public Boolean getBoolean(String path) {
        return this.config.getBoolean(path);
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
        return config.getKeys();
    }

    @Override
    public Map<String, ?> getPathKeys(String path) {
        if(!config.contains(path)) { return null; }
        Map<String, Object> paths = new HashMap<>();
        for(String key : config.getSection(path).getKeys()){
            paths.put(key, config.getSection(path).get(key));
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
            YamlConfiguration.getProvider(YamlConfiguration.class).save(this.config, this.file);
        } catch (Exception e){
            e.printStackTrace();
            Bungee.getCoreLogger().erro(Level.WARNING, "O arquivo §f"+file.getName()+" §4não pode ser salvo!");
        }
    }
}
