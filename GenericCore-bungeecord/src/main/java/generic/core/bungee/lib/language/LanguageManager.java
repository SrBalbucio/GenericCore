package generic.core.bungee.lib.language;

import generic.core.bungee.Bungee;
import generic.core.bungee.lib.file.FileConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class LanguageManager {

    static Map<String, String> copyAsDefault = new HashMap<>();
    static List<Translatable> translatables = new ArrayList<>();
    static List<Language> languages = new ArrayList<>();

    public LanguageManager(){
        Bungee.getCoreLogger().start(Level.INFO, "§bSistema de Linguagens §ainiciado com sucesso!");
        load();
    }

    private void load(){
        File folder = new File("Languages");
        folder.mkdir();
        File[] listFiles = folder.listFiles();
        for(int i = 0; i < listFiles.length; i++) {
            if(listFiles[i].isFile()) {
                File file = new File("Languages", listFiles[i].getName());
                FileConfig config = new FileConfig(file);
                if(!config.contains("language.name")){ return; }
                languages.add(new Language(config));
                Bungee.getCoreLogger().start(Level.INFO, "§aA linguagem §e"+config.getString("language.name")+" §afoi carregada com sucesso!");
            }
        }
    }

    public static void addTranslatable(Translatable t){
        if(translatables.contains(t)) { return; }
        translatables.add(t);
        for(String key : t.getDefault().keySet()){
            if(!copyAsDefault.containsKey(key)) {
                copyAsDefault.put(key, t.getDefault().get(key));
            }
        }
        reload();
    }

    public static void reload(){
        for (Language l : languages){
            l.update(copyAsDefault);
        }
    }

    public static Language getLanguageByName(String name){
        for(Language l : languages){
            if(l.getName().equals(name)){
                return l;
            }
        }
        return null;
    }

    public static Language getLanguageByPrefix(String prefix){
        for(Language l : languages){
            if(l.getPrefix().equals(prefix)){
                return l;
            }
        }
        return null;
    }
}
