package com.fzw.mprestdemo.rest.rest;

import com.fzw.mprestdemo.rest.rest.client.DefaultVariantListBuilder;
import com.fzw.mprestdemo.rest.rest.core.DefaultResponseBuilder;
import com.fzw.mprestdemo.rest.rest.core.DefaultUriBuilder;

import javax.ws.rs.core.*;
import javax.ws.rs.ext.RuntimeDelegate;

public class DefaultRuntimeDelegate extends RuntimeDelegate {

    @Override
    public UriBuilder createUriBuilder() {
        return new DefaultUriBuilder();
    }

    @Override
    public Response.ResponseBuilder createResponseBuilder() {
        return new DefaultResponseBuilder();
    }

    @Override
    public Variant.VariantListBuilder createVariantListBuilder() {
        return new DefaultVariantListBuilder();
    }

    @Override
    public <T> T createEndpoint(Application application, Class<T> endpointType) throws IllegalArgumentException, UnsupportedOperationException {
        return null;
    }

    @Override
    public <T> HeaderDelegate<T> createHeaderDelegate(Class<T> type) throws IllegalArgumentException {
        if (type.equals(MediaType.class)) {
            return new HeaderDelegate<T>() {
                @Override
                public T fromString(String value) {
                    String[] split = value.split("/");
                    return (T) new MediaType(split[0], split[1]);
                }

                @Override
                public String toString(T value) {
                    MediaType mediaType = (MediaType) value;
                    return mediaType.getType() + "/" + mediaType.getSubtype();
                }
            };
        }
        return null;
    }

    @Override
    public Link.Builder createLinkBuilder() {
        return null;
    }
}
