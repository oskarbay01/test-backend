package com.oskarbay.efactoringtest.service;

import com.oskarbay.efactoringtest.model.OrderRequest;
import com.oskarbay.efactoringtest.model.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse updateOrder(OrderRequest orderRequest);
    OrderResponse getOrderById(String orderId);
    List<OrderResponse> getAllOrders();
    void deleteOrderById(String orderId);
}
