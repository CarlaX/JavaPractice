package com.fzw.ConfigDemo.config;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public class ServletRequestConfigSource extends BaseConfigSource {

    private final HttpServletRequest request;

    public ServletRequestConfigSource(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Set<String> getPropertyNames() {
        return this.request.getParameterMap().keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return request.getParameter(propertyName);
    }

    @Override
    public String getName() {
        return this.request.getRequestURI();
    }

    @Override
    public String getString(String key) {
        return this.nullCheck(this.convert(String.class, key));
    }

    @Override
    public int getInt(String key) {
        return this.nullCheck(this.convert(Integer.class, key));
    }

    @Override
    public long getLong(String key) {
        return this.nullCheck(this.convert(Long.class, key));
    }

    @Override
    public short getShort(String key) {
        return this.nullCheck(this.convert(Short.class, key));
    }

    @Override
    public float getFloat(String key) {
        return this.nullCheck(this.convert(Float.class, key));
    }

    @Override
    public double getDouble(String key) {
        return this.nullCheck(this.convert(Double.class, key));
    }

    @Override
    public char getChar(String key) {
        return this.nullCheck(this.convert(Character.class, key));
    }

    @Override
    public byte getByte(String key) {
        return this.nullCheck(this.convert(Byte.class, key));
    }


    @Override
    public String[] getArray(String key) {
        return this.nullCheck(this.convert(String[].class, key));
    }

    @Override
    public Class<?> getClazz(String key) {
        return this.nullCheck(this.convert(Class.class, key));
    }

    @SuppressWarnings("unchecked")
    private <T> T convert(Class<T> clazz, String key) {
        String[] values = this.request.getParameterMap().get(key);
        if (values == null || values.length <= 0) {
            return null;
        }
        String value = values[0];
        if (clazz.isArray()) {
            return (T) super.getConverter(String[].class).convert(value);
        } else {
            return (T) super.getConverter(clazz).convert(value);
        }
    }

    private <T> T nullCheck(T object) {
        if (object == null) {
            throw new RuntimeException("属性为空");
        }
        return object;
    }

}
