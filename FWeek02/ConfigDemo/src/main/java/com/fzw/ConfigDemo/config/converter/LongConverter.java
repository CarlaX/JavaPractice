package com.fzw.ConfigDemo.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public class LongConverter implements Converter<Long> {
    @Override
    public Long convert(String value) throws IllegalArgumentException, NullPointerException {
        return Long.parseLong(value);
    }
}
