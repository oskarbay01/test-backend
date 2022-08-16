package com.oskarbay.efactoringtest.repository;

import com.oskarbay.efactoringtest.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> getOrderEntityByName(String name);

    OrderEntity getOrderEntityByOrderId(String orderId);

    List<OrderEntity> getOrderEntityBy();

    @Transactional
    void deleteOrderEntityByOrderId(String orderId);

}
