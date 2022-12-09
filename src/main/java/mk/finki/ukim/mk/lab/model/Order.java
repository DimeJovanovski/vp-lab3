package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shop_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;
    String balloonColor;
    String balloonSize;
    @ManyToOne(cascade=CascadeType.ALL)
    User user;

    public Order(String balloonColor, String balloonSize, User user) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.user = user;
    }

    public Order() {
    }
}
