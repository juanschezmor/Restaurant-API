package com.example.restaurante.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class OrdersController {

    @Autowired
    private OrdersRepository OrdersRepository;
    private ProductOrderRepository ProductOrderRepository;

    @GetMapping("/orders")
    public Iterable<Orders> getAllOrders(){
        return OrdersRepository.findAll();
    }

    @GetMapping("/order")
    public Orders getOrder(int id){
        return OrdersRepository.findById(id).get();
    }
    //Modificar un pedido
    @GetMapping("/update-order-state")
    public Orders updateOrder(int id, String state){
        Orders order = OrdersRepository.findById(id).get();
        order.setState(state);
        OrdersRepository.save(order);
        return order;
    }
    //Modificar la cantidad de un producto en un pedido
    @GetMapping("/update-product-order-quantity")
    public ProductOrder updateProductOrderQuantity(int id, int quantity){
        ProductOrder productOrder = ProductOrderRepository.findById(id).get();
        productOrder.setQuantity(quantity);
        ProductOrderRepository.save(productOrder);
        return productOrder;
    }

    //Ver todos los pedidos de un usuario
    @GetMapping("/user-orders")
    public Iterable<Orders> getUserOrders(int userId){
       ArrayList<Orders> orders = new ArrayList<>();

        for (Orders order:OrdersRepository.findAll()
             )
              {
            if (order.getUserId() == userId){
                orders.add(order);
            }

        }
        return orders;
    }

}
