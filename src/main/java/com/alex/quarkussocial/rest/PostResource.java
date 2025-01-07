package com.alex.quarkussocial.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/users/{userId}/posts")
public class PostResource {

    @POST
    public Response savePost() {
        return  Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listPosts() {
        return Response.ok().build();
    }

}
