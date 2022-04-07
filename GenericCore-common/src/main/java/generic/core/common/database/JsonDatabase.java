package generic.core.common.database;

import generic.core.common.lib.file.JsonConfig;

import java.io.File;

public class JsonDatabase implements Database{

    private JsonConfig db;

    public JsonDatabase(String[] config){

    }


    @Override
    public void connect() {
        db = new JsonConfig(new File("plugins/GenericCore/database/json-database.yml"));
    }

    @Override
    public void disconnect() {
        db.save();
    }

    @Override
    public void reconnect() {
        db.save();
        db.load();
    }

    @Override
    public Integer getInt(String path) {
        return db.getInt(path);
    }

    @Override
    public String getString(String path) {
        return db.getString(path);
    }

    @Override
    public Long getLong(String path) {
        return (Long) db.get(path);
    }

    @Override
    public Boolean getBoolean(String path) {
        return db.getBoolean(path);
    }

    @Override
    public Object get(String path) {
        return db.get(path);
    }

    @Override
    public void setInteger(String path, Integer i) {
        db.insertInt(path, i);
    }

    @Override
    public void setString(String path, String i) {
        db.insertString(path, i);
    }

    @Override
    public void set(String path, Object i) {
        db.insert(path, i);
    }
}
