package study.dev.spring.order.service;

import study.dev.spring.order.Order;

public interface OrderService {
    //주문 생성
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
