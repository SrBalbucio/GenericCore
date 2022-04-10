package generic.core.common.lib.file;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Config {

    void load();
    void insert(String path, Object value);
    void insertString(String path, String value);
    void insertInt(String path, Integer value);
    void insertBoolean(String path, Boolean value);
    void insetList(String key, List<?> value);
    Object get(String path);
    String getString(String path);
    Integer getInt(String path);
    Boolean getBoolean(String path);
    boolean contains(String path);
    List<?> getList(String path);
    Collection<String> getKeys();
    Map<String, ?> getPathKeys(String path);
    Config generate(File file);

    void save();
}
