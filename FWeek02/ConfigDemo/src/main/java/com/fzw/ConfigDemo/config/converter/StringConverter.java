package com.fzw.ConfigDemo.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public class StringConverter implements Converter<String> {
    @Override
    public String convert(String value) throws IllegalArgumentException, NullPointerException {
        return value;
    }
}
