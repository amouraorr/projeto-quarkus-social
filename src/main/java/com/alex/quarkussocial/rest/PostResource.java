package com.alex.quarkussocial.rest;

import com.alex.quarkussocial.domain.model.Post;
import com.alex.quarkussocial.domain.model.User;
import com.alex.quarkussocial.domain.repository.PostRepository;
import com.alex.quarkussocial.domain.repository.UserRepository;
import com.alex.quarkussocial.rest.dto.CreatedPostRequest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/users/{userId}/posts")
public class PostResource {

    private UserRepository userRepository;
    private PostRepository repository;

    @Inject
    public PostResource(UserRepository userRepository, PostRepository repository) {
        this.userRepository = userRepository;
        this.repository = repository;
    }

    @POST
    @Transactional
    public Response savePost(@PathParam("userId") Long userId, CreatedPostRequest request) {
        User user = userRepository.findById(userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Post post = new Post();
        post.setText(request.getText());
        post.setUser(user);

        repository.persist(post);

        return  Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listPosts(@PathParam("userId") Long userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }

}
