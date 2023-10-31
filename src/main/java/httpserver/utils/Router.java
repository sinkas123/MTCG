package httpserver.utils;

import user.controller.UserController;
import httpserver.server.RestController;


import java.util.HashMap;
import java.util.Map;

public class Router {
    private Map<String, RestController> serviceRegistry = new HashMap<>();

    public Router() {

        addService("/user", new UserController());


    }
    public void addService(String route, RestController service)
    {

        this.serviceRegistry.put(route, service);
    }


    public void removeService(String route)
    {
        this.serviceRegistry.remove(route);
    }

    public RestController resolve(String route)
    {
        return this.serviceRegistry.get(route);
    }
}
