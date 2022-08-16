package com.oskarbay.efactoringtest.service.oldService;

import com.oskarbay.efactoringtest.model.OrderEntity;

import java.util.List;

public interface OrderServiceOld {
    void createOrder(OrderEntity orderModel);
    List<OrderEntity> getAllOrders();
    OrderEntity getOrderById(String orderId);
    void updateOrderById(String orderId, OrderEntity orderModel);
    void deleteOrderById(String orderId);
}
