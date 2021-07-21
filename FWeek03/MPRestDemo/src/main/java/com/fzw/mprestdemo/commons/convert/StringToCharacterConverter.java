/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fzw.mprestdemo.commons.convert;


import static org.apache.commons.lang.StringUtils.length;

/**
 * The class to convert {@link String} to {@link Character}
 *
 * @since 1.0.0
 */
public class StringToCharacterConverter implements StringConverter<Character> {

    @Override
    public Character convert(String source) {
        int length = length(source);
        if (length == 0) {
            return null;
        }
        if (length > 1) {
            throw new IllegalArgumentException("The source String is more than one character!");
        }
        return source.charAt(0);
    }

    @Override
    public int getPriority() {
        return NORMAL_PRIORITY + 8;
    }
}
