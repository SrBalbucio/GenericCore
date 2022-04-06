package generic.core.bungee.lib.language;

import generic.core.bungee.lib.file.FileConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Language {

    private FileConfig config;
    private String name;
    private String prefix;

    public Language(FileConfig config) {
        this.config = config;
        this.name = config.getString("language.name");
        this.prefix = config.getString("language.prefix");
    }

    public void update(Map<String, String> de){
        for(String key : de.keySet()){
            if(!config.contains(key)){
                config.insert(key, de.get(key));
            }
        }
    }

    public String get(String path){
        return config.getString(path);
    }

    public Object getObj(String path){
        if(config.getString(path).contains("</list>")){
            List<String> lista = new ArrayList<>();
            for(String k : config.getString(path).split("</list>")){
                lista.add(k);
            }
            return lista;
        }

        return config.get(path);
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }
}
