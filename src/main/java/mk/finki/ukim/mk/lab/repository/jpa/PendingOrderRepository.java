package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.PendingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingOrderRepository extends JpaRepository<PendingOrder, Long> {
    PendingOrder save(PendingOrder pendingOrder);
    void deleteAll();


}
