package user.persistance;

import user.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private List<User> userData;

    public UserDao() {
        userData = new ArrayList<>();
        // Assuming 'password' is a placeholder for actual hashed passwords
        // and 'coins' is an integer value representing a currency amount.
        userData.add(new User(1, "Eden", "hashed_password1", 30));
        userData.add(new User(2, "Serena", "hashed_password2", 50));
        userData.add(new User(3, "Timmy", "hashed_password3", 20));
    }

    // GET /user/:id
    public User getUser(Integer id) {
        return userData.stream()
                .filter(user -> id.equals(user.getId()))
                .findAny()
                .orElse(null);
    }

    // GET /user
    public List<User> getAllUsers() {
        return new ArrayList<>(userData);
    }

    // POST /user
    public void addUser(User user) {
        userData.add(user);
    }
}
