package com.fzw.ConfigDemo.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * @author fzw
 * @description
 * @date 2021-07-14
 **/
public class FloatConverter implements Converter<Float> {
    @Override
    public Float convert(String value) throws IllegalArgumentException, NullPointerException {
        return Float.parseFloat(value);
    }
}
