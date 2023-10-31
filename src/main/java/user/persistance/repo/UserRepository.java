package user.persistance.repo;

import user.model.User;

import java.util.Collection;

public interface UserRepository {
    User findById(int id);
    Collection<User> findAllUser();
}
