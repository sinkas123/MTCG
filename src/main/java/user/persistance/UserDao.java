package user.persistance;

import user.model.User;
import java.util.ArrayList;
import java.util.List;


public class UserDao {

    private List<User> userData;

    public UserDao() {
        userData = new ArrayList<>();
        userData.add(new User(1, "Jenny"));
        userData.add(new User(2, "Serena"));
        userData.add(new User(3, "Timmy"));
    }

    // GET /weather/:id
    public User getUser(Integer ID) {
        User foundUser = userData.stream()
                .filter(user -> ID == user.getId())
                .findAny()
                .orElse(null);

        return foundUser;
    }

    // GET /weather
    public List<User> getUser() {
        return userData;
    }

    // POST /weather
    public void addUser(User user) {
        userData.add(user);
    }
}
