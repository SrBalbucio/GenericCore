package generic.core.common.database;

import generic.core.common.exception.ConnectDatabase;

public interface Database {

    void connect();
    void disconnect();
    void reconnect();
    Integer getInt(String path);
    String getString(String path);
    Long getLong(String path);
    Boolean getBoolean(String path);
    Object get(String path);
    void setInteger(String path, Integer i);
    void setString(String path, String i);
    void set(String path, Object i);

}
