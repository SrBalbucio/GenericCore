package generic.core.common.database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;

public class RedisDatabase implements Database{

    private Jedis jedis;
    private String host;
    private String password;
    private Integer port;

    public RedisDatabase(String[] config){
        host = config[2];
        port = Integer.parseInt(config[1]);
        password = config[0];
    }

    @Override
    public void connect() {
        jedis = new Jedis(host, port);
        jedis.auth(password);
    }

    @Override
    public void disconnect() {
        jedis.close();
        jedis = null;
    }

    @Override
    public void reconnect() {

    }

    @Override
    public Integer getInt(String path) {
        return 0;
    }

    @Override
    public String getString(String path) {
        return null;
    }

    @Override
    public Long getLong(String path) {
        return null;
    }

    @Override
    public Boolean getBoolean(String path) {
        return null;
    }

    @Override
    public Object get(String path) {
        return null;
    }

    @Override
    public void setInteger(String path, Integer i) {
        jedis.set(path, i.toString());
    }

    @Override
    public void setString(String path, String i) {

    }

    @Override
    public void set(String path, Object i) {

    }
}
