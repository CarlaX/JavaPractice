package com.fzw.ConfigDemo.config;

import com.fzw.ConfigDemo.config.converter.*;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.Converter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public abstract class BaseConfigSource implements ConfigSource {

    private final Map<Class<?>, Converter<?>> converterMap;

    public BaseConfigSource() {
        this.converterMap = new HashMap<>();
        this.converterMap.put(String.class, new StringConverter());
        this.converterMap.put(Integer.class, new IntegerConverter());
        this.converterMap.put(Long.class, new LongConverter());
        this.converterMap.put(Short.class, new ShortConverter());
        this.converterMap.put(Double.class, new DoubleConverter());
        this.converterMap.put(Float.class, new FloatConverter());
        this.converterMap.put(Byte.class, new ByteConverter());
        this.converterMap.put(Class.class, new ClassConverter());
        this.converterMap.put(Character.class, new CharConverter());
        this.converterMap.put(String[].class, new ArrayConverter());
    }

    protected Converter<?> getConverter(Class<?> clazz) {
        return this.converterMap.get(clazz);
    }

    public <S> boolean addConverter(Class<S> clazz, Converter<S> converter) {
        if (this.converterMap.containsKey(clazz)) {
            return false;
        }
        this.converterMap.put(clazz, converter);
        return true;
    }

    public boolean clearConverter(Class<?> clazz) {
        if (!this.converterMap.containsKey(clazz)) {
            return false;
        }
        this.converterMap.remove(clazz);
        return true;
    }

    public abstract String getString(String key);

    public abstract int getInt(String key);

    public abstract long getLong(String key);

    public abstract short getShort(String key);

    public abstract float getFloat(String key);

    public abstract double getDouble(String key);

    public abstract char getChar(String key);

    public abstract byte getByte(String key);

    public abstract String[] getArray(String key);

    public abstract Class<?> getClazz(String key);


}
