package es.fplumara.dam1.workshoptesting.core.util;

import java.util.HashMap;
import java.util.Map;

public class SingletonCache {
    private static final SingletonCache INSTANCE = new SingletonCache();
    private final Map<String, Object> map = new HashMap<>();

    private SingletonCache() {}

    public static SingletonCache getInstance() { return INSTANCE; }

    public void put(String key, Object value) { map.put(key, value); }
    public Object get(String key) { return map.get(key); }
}