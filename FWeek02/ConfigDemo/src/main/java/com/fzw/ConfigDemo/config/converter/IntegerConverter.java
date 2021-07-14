package com.fzw.ConfigDemo.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public class IntegerConverter implements Converter<Integer> {
    @Override
    public Integer convert(String value) throws IllegalArgumentException, NullPointerException {
        return Integer.parseInt(value);
    }
}
