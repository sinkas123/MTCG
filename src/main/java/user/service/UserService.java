package user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import httpserver.http.ContentType;
import httpserver.http.HttpStatus;
import httpserver.server.Request;
import httpserver.server.Response;
import user.model.User;
import user.persistance.UnitOfWork;
import user.persistance.repo.UserRepoImpl;
import user.persistance.repo.UserRepository;


public class UserService extends AbstractService {

    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepoImpl(new UnitOfWork());
    }

    // GET /user(:id
    public Response getUser(String id)
    {
        System.out.println("get user for id: " + id);
        User user = userRepository.findById(Integer.parseInt(id));
        String json = null;
        try {
            json = this.getObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response(HttpStatus.OK, ContentType.JSON, json);
    }
    // GET /user
    public Response getUser() {
        return new Response(HttpStatus.NOT_IMPLEMENTED);
    }

    // POST /user
    public Response addUser(Request request) {
        return new Response(HttpStatus.NOT_IMPLEMENTED);
    }

    // GET /user
    public Response getUserPerRepository() {
        System.out.println("getUserPerRepository");
        User user = new User(1, "Emma", "Pass", 22);
        String json = null;
        try {
            json = this.getObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response(HttpStatus.OK, ContentType.JSON, json);
    }
}
