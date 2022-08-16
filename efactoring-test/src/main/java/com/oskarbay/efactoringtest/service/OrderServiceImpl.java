package com.oskarbay.efactoringtest.service;

import com.oskarbay.efactoringtest.model.OrderEntity;
import com.oskarbay.efactoringtest.model.OrderRequest;
import com.oskarbay.efactoringtest.model.OrderResponse;
import com.oskarbay.efactoringtest.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        orderRequest.setOrderId(UUID.randomUUID().toString());
        OrderEntity orderEntity = modelMapper.map(orderRequest, OrderEntity.class);
        orderRepo.save(orderEntity);
        return modelMapper.map(orderEntity, OrderResponse.class);
    }

    @Override
    public OrderResponse updateOrder(OrderRequest orderRequest) {
        OrderEntity orderEntity = modelMapper.map(orderRequest, OrderEntity.class);
        OrderEntity dbEntity = orderRepo.getOrderEntityByOrderId(orderRequest.getOrderId());
        orderEntity.setId(dbEntity.getId());
        orderRepo.save(orderEntity);
        return modelMapper.map(orderEntity, OrderResponse.class);
    }

    @Override
    public OrderResponse getOrderById(String orderId) {
        OrderEntity orderEntity = orderRepo.getOrderEntityByOrderId(orderId);
        return modelMapper.map(orderEntity, OrderResponse.class);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepo.getOrderEntityBy().stream()
                .map(order -> modelMapper.map(order, OrderResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrderById(String orderId) {
        orderRepo.deleteOrderEntityByOrderId(orderId);
    }
}
