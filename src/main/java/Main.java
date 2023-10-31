import httpserver.server.Server;
import httpserver.utils.Router;
import user.controller.EchoController;
import user.controller.UserController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(10001, configureRouter());
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Router configureRouter()
    {
        Router router = new Router();
        /*  router.addService("/weather", new WeatherController());*/
        router.addService("/echo", new EchoController());
        router.addService("/tw", new UserController());

        return router;
    }
}
