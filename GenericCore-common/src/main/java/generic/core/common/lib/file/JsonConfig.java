package generic.core.common.lib.file;

import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class JsonConfig implements Config{

    private File file;
    private JSONObject json;

    public JsonConfig(File file){
        this.file = file;
        createNew();
        load();
    }

    @Override
    public void load() {
        createNew();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            this.json = new JSONObject(builder.toString());
        } catch(Exception e) {
            e.printStackTrace();
            json = null;
        }
    }

    @Override
    public void insert(String path, Object value) {
        json.put(path, value);
        save();
    }

    @Override
    public void insertString(String path, String value) {
        json.put(path, value);
        save();
    }

    @Override
    public void insertInt(String path, Integer value) {
        json.put(path, value);
        save();
    }

    @Override
    public void insertBoolean(String path, Boolean value) {
        json.put(path, value);
        save();
    }

    @Override
    public void insetList(String key, List<?> value) {
        json.put(key, value);
        save();
    }

    @Override
    public Object get(String path) {
        return json.get(path);
    }

    @Override
    public String getString(String path) {
        return json.getString(path);
    }

    @Override
    public Integer getInt(String path) {
        return json.getInt(path);
    }

    @Override
    public Boolean getBoolean(String path) {
        return json.getBoolean(path);
    }

    @Override
    public boolean contains(String path) {
        return json.has(path);
    }

    @Override
    public List<?> getList(String path) {
        List<Object> list = new ArrayList<>();
        for(String a : json.getString(path).split("</list>")){
            list.add(a);
        }
        return list;
    }

    @Override
    public Collection<String> getKeys() {
        return json.keySet();
    }

    @Override
    public Map<String, ?> getPathKeys(String path) {
        Map<String, Object> paths = new HashMap<>();
        for(String key : json.keySet()){
            paths.put(key, json.get(key));
        }
        return paths;
    }

    @Override
    public void save() {
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(json.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
