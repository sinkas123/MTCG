package user.controller;

import httpserver.http.ContentType;
import httpserver.http.HttpStatus;
import httpserver.http.Method;
import httpserver.server.Request;
import httpserver.server.Response;
import httpserver.server.RestController;
//import at.fhtw.sampleapp.service.WeatherService;
import user.service.UserService;

public class UserController implements RestController {
    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @Override
    public Response handleRequest(Request request) {
        if (request.getMethod() == Method.GET &&
                request.getPathParts().size() > 1) {
            return this.userService.getUser(request.getPathParts().get(1));
        } else if (request.getMethod() == Method.GET) {
            return this.userService.getUserPerRepository();
        } else if (request.getMethod() == Method.POST) {
            return this.userService.addUser(request);
        }

        return new Response(
                HttpStatus.BAD_REQUEST,
                ContentType.JSON,
                "[]"
        );
    }
}

