package generic.core.common.database;

import redis.clients.jedis.JedisPooled;

public class RedisDatabase implements Database{

    private JedisPooled jedis;
    private String host;
    private Integer port;

    public RedisDatabase(String[] config){
        host = config[1];
        port = Integer.parseInt(config[0]);
    }

    @Override
    public void connect() {
        jedis = new JedisPooled(host, port);
    }

    @Override
    public void disconnect() {
        jedis.getPool().destroy();
        jedis = null;
    }

    @Override
    public void reconnect() {

    }

    @Override
    public Integer getInt(String path) {
        return jedis.;
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
