package generic.core.common.language;

import generic.core.common.lib.file.Config;
import generic.core.common.logger.CoreLogger;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanguageManager {

    private File folder;
    private Config c;
    private List<Language> languages = new ArrayList<>();

    public LanguageManager(File folder, Config config){
        this.folder = folder;
        this.c = config;
        load();
    }

    public void load() {
        try {
            folder.mkdirs();
            File[] listFiles = folder.listFiles();
            if (listFiles.length == 0) {
                File file = new File(folder, "BrazilianPortuguese.yml");
                if (!file.exists()) {
                    Files.copy(this.getClass().getResourceAsStream("/BrazilianPortuguese.yml"), file.toPath());
                }
            }
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    File file = new File(folder, listFiles[i].getName());
                    Config config = c.generate(file);

                    if (!config.contains("language.name")) {
                        return;
                    }

                    languages.add(new Language(config));
                    CoreLogger.out("§aA linguagem §e" + config.getString("language.name") + " §afoi carregada com sucesso!");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
