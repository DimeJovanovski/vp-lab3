package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.PendingOrder;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.jpa.OrderRepository;
import mk.finki.ukim.mk.lab.repository.jpa.PendingOrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PendingOrderRepository pendingOrderRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            PendingOrderRepository pendingOrderRepository) {
        this.orderRepository = orderRepository;
        this.pendingOrderRepository = pendingOrderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public Order save(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        User user = new User(clientName);
        Order order = new Order(balloonColor, balloonSize, user);
        return this.orderRepository.save(order);
    }

    @Override
    public PendingOrder addPendingOrder(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        User user = new User(clientName);
        PendingOrder pendingOrder = new PendingOrder(balloonColor, balloonSize, user);
        return this.pendingOrderRepository.save(pendingOrder);
    }

    @Override
    public PendingOrder getPendingOrder() {
        return this.pendingOrderRepository.findAll().get(0);
    }

    @Override
    public void removePendingOrder() {
        this.pendingOrderRepository.deleteAll();
    }
}
