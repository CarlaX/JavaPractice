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
package com.fzw.mprestdemo.rest.rest.client;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fzw.mprestdemo.rest.rest.core.DefaultResponse;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * HTTP GET Method {@link Invocation}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
@Slf4j
class HttpPostInvocation implements Invocation {

    private final URI uri;

    private final URL url;

    private final MultivaluedMap<String, Object> headers;

    private Entity<?> entity;

    private final ObjectMapper objectMapper;

    HttpPostInvocation(URI uri, MultivaluedMap<String, Object> headers, Entity<?> body) {
        this.uri = uri;
        this.headers = headers;
        this.entity = body;
        this.objectMapper = new ObjectMapper();
        try {
            this.url = uri.toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Invocation property(String name, Object value) {
        return this;
    }

    @Override
    public Response invoke() {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(HttpMethod.POST);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            this.setRequestHeaders(connection);
            if (this.entity != null) {
                MediaType mediaType = this.entity.getMediaType();
                if (MediaType.APPLICATION_JSON_TYPE.equals(mediaType)) {
                    Object obj = this.entity.getEntity();
                    byte[] body = objectMapper.writeValueAsBytes(obj);
                    try (OutputStream outputStream = connection.getOutputStream();) {
                        outputStream.write(body);
                        outputStream.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    //...
                }
            }
            int statusCode = connection.getResponseCode();
            DefaultResponse response = new DefaultResponse();
            response.setConnection(connection);
            response.setStatus(statusCode);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setRequestHeaders(HttpURLConnection connection) {
        for (Map.Entry<String, List<Object>> entry : headers.entrySet()) {
            String headerName = entry.getKey();
            for (Object headerValue : entry.getValue()) {
                connection.setRequestProperty(headerName, headerValue.toString());
            }
        }
    }

    @Override
    public <T> T invoke(Class<T> responseType) {
        Response response = invoke();
        MediaType mediaType = response.getMediaType();
        if (MediaType.APPLICATION_JSON_TYPE.equals(mediaType)) {
            String entity = response.readEntity(String.class);
            try {
                return this.objectMapper.readValue(entity, responseType);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return response.readEntity(responseType);
    }

    @Override
    public <T> T invoke(GenericType<T> responseType) {
        Response response = invoke();
        MediaType mediaType = response.getMediaType();
        if (MediaType.APPLICATION_JSON_TYPE.equals(mediaType)) {
            String entity = response.readEntity(String.class);
            try {
                Class<?> rawType = responseType.getRawType();
                return this.objectMapper.readValue(entity, new TypeReference<>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return response.readEntity(responseType);
    }

    @Override
    public Future<Response> submit() {
        return null;
    }

    @Override
    public <T> Future<T> submit(Class<T> responseType) {
        return null;
    }

    @Override
    public <T> Future<T> submit(GenericType<T> responseType) {
        return null;
    }

    @Override
    public <T> Future<T> submit(InvocationCallback<T> callback) {
        return null;
    }
}
