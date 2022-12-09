package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.PendingOrder;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String getOrdersPage(Model model) {
        List<Order> orders = this.orderService.findAll();
        model.addAttribute("orders", orders);
        return "userOrders";
    }

    @GetMapping("/add")
    public String postToOrdersPage(HttpSession session) {
        PendingOrder order = this.orderService.getPendingOrder();
        String username = (String) session.getAttribute("name");
        String address = (String) session.getAttribute("address");
        this.orderService.save(order.getBalloonColor(), order.getBalloonSize(), username, address);
        List<Order> orders = this.orderService.findAll();
        this.orderService.removePendingOrder();
        return "redirect:/orders";
    }


}
