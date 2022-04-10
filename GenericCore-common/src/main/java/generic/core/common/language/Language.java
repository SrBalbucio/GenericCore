package generic.core.common.language;

import generic.core.common.lib.file.Config;

public class Language {

    private Config config;
    private String name;
    private String prefix;

    public Language(Config config){
        this.config = config;
        this.prefix = config.getString("language.prefix");
        this.name = config.getString("language.name");
    }
}
