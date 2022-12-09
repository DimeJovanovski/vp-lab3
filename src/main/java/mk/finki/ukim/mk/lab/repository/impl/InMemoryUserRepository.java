package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryUserRepository {
    public Optional<User> save(String username) {
        User user = new User(username);
        DataHolder.users.removeIf(r -> r.getUsername().equals(username));
        DataHolder.users.add(user);
        return Optional.of(user);
    }

    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream().filter(r -> r.getUsername().equals(username)).findFirst();
    }

    public void remove(String username) {
        DataHolder.users.removeIf(r -> r.getUsername().equals(username));
    }
}
