package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.User;

import java.util.Optional;

public interface UserService {
    User save(String username);

    Optional<User> findByUsername(String username);

    void remove(String username);
}
