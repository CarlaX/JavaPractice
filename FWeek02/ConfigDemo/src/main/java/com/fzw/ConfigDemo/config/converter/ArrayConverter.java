package com.fzw.ConfigDemo.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public class ArrayConverter implements Converter<String[]> {

    private static final String DELIMITER = ",";

    @Override
    public String[] convert(String value) throws IllegalArgumentException, NullPointerException {
        return value.split(",");
    }
}
