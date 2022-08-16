package com.oskarbay.efactoringtest.http;

import com.oskarbay.efactoringtest.model.OrderRequest;
import com.oskarbay.efactoringtest.model.OrderResponse;
import com.oskarbay.efactoringtest.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PutMapping
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @PutMapping
    public OrderResponse updateOrder(@RequestParam String orderId,
                                     @RequestBody OrderRequest orderRequest) {
        orderRequest.setOrderId(orderId);
        return orderService.updateOrder(orderRequest);
    }

    @GetMapping
    public OrderResponse getOrderById(@RequestParam String orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/all")
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
    }

    @DeleteMapping
    public void deleteOrderById(@RequestParam String orderId){
        orderService.deleteOrderById(orderId);
    }
}
