package com.oskarbay.efactoringtest.service.oldService;

import com.oskarbay.efactoringtest.model.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
@Service
public class OrderServiceImplOld implements OrderServiceOld {

    private static final HashMap<String, OrderEntity> orderModelHashMap = new HashMap<>();
/*
    static {
        OrderEntity orderModel1 = new OrderEntity(UUID.randomUUID().toString(), "TV", 1, "улица Абая", "565656");
        OrderEntity orderModel2 = new OrderEntity(UUID.randomUUID().toString(), "SmartPhone", 2, "улица Мира", "787878");
        OrderEntity orderModel3 = new OrderEntity(UUID.randomUUID().toString(), "Laptop", 4, "улица Маркова", "123123");
        orderModelHashMap.put(orderModel1.getOrderId(), orderModel1);
        orderModelHashMap.put(orderModel2.getOrderId(), orderModel2);
        orderModelHashMap.put(orderModel3.getOrderId(), orderModel3);
    }*/

    @Override
    public void createOrder(OrderEntity orderModel) {
        orderModel.setOrderId(UUID.randomUUID().toString());
        orderModelHashMap.put(orderModel.getOrderId(), orderModel);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return new ArrayList<>(orderModelHashMap.values());
    }

    @Override
    public OrderEntity getOrderById(String orderId) {
        return orderModelHashMap.get(orderId);
    }

    @Override
    public void updateOrderById(String orderId, OrderEntity orderModel) {
        orderModel.setOrderId(orderId);
        orderModelHashMap.put(orderId, orderModel);
    }

    @Override
    public void deleteOrderById(String orderId) {
        orderModelHashMap.remove(orderId);
    }
}
