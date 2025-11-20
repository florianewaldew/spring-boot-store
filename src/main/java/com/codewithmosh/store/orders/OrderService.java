package com.codewithmosh.store.orders;

import com.codewithmosh.store.auth.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final OrderMapper orderMapper;

    public List<OrderDto> getCustomerOrders() {

        var currentUser = authService.getCurrentUser();
        var orders = orderRepository.getOrdersByCustomer(currentUser);
        return orders.stream()
                .map(orderMapper::toDto)
                .toList();
    }

    public OrderDto getOrder(Long orderId){
        var order = orderRepository.getOrderWithItems(orderId).orElseThrow(OrderNotFoundException::new);
        if(!order.isPlacedBy(authService.getCurrentUser())) {
            throw new AccessDeniedException("You don't have access to this order");
        }

        return orderMapper.toDto(order);
    }
}
