package com.fzw.ConfigDemo.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public class ClassConverter implements Converter<Class> {
    @Override
    public Class<?> convert(String value) throws IllegalArgumentException, NullPointerException {
        try {
            return Class.forName(value);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
