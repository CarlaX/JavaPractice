package com.fzw.ConfigDemo.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

import java.nio.charset.StandardCharsets;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public class CharConverter implements Converter<Character> {
    @Override
    public Character convert(String value) throws IllegalArgumentException, NullPointerException {
        return value.charAt(0);
    }
}
