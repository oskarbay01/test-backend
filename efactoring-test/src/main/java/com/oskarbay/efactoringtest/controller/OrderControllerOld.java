package com.oskarbay.efactoringtest.controller;

import com.oskarbay.efactoringtest.model.OrderEntity;
import com.oskarbay.efactoringtest.service.oldService.OrderServiceOld;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/old/order")
@RequiredArgsConstructor
public class OrderControllerOld {

    private final OrderServiceOld orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderEntity orderModel) {
        orderService.createOrder(orderModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public OrderEntity getOrderById(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrderId(@PathVariable String orderId,
                                                @RequestBody OrderEntity orderModel) {
        orderService.updateOrderById(orderId,orderModel);
        return new ResponseEntity<String>("Successfully update",HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable String orderId) {
        orderService.deleteOrderById(orderId);
        return new ResponseEntity<String>("Succesfully deleted",HttpStatus.OK);
    }
}
