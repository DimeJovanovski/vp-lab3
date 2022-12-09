package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryOrderRepository {

    private final InMemoryUserRepository userRepository;

    public InMemoryOrderRepository(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Order> findAll() {
        return DataHolder.orders;
    }

    public Optional<Order> findById(Long id) {
        return DataHolder.orders.stream().filter(r -> r.getOrderId().equals(id)).findFirst();
    }

    public Optional<Order> save(String color, String size, String username, String address) {
        User user = this.userRepository.findByUsername(username).get();
        Order order = new Order(color, size, user);
        DataHolder.orders.removeIf(r -> r.getBalloonColor().equals(color));
        DataHolder.orders.add(order);
        return Optional.of(order);
    }

    public Order addPendingOrder(String balloonColor, String balloonSize, String username, String address) {
        User user = this.userRepository.findByUsername(username).get();
        Order order = new Order(balloonColor, balloonSize, user);
        DataHolder.pedingOrder = order;
        return order;
    }

    public void removePendingOrder() {
        DataHolder.pedingOrder=null;
    }

    public Order getPendingOrder() {
        return DataHolder.pedingOrder;
    }
}
