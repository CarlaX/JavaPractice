package com.fzw.mprestdemo.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author fzw
 * @description
 * @date 2021-07-21
 **/
@Path("/actuator")
public interface ActuatorService {

    @GET
    @Path("/")
    public Map actuator();

    @GET
    @Path("/env")
    public Map env();

    @POST
    @Path("/shutdown")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Map shutdown();
}
