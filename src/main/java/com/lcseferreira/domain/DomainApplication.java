package com.lcseferreira.domain;

import com.lcseferreira.domain.entities.Client;
import com.lcseferreira.domain.entities.Order;
import com.lcseferreira.domain.entities.OrderItem;
import com.lcseferreira.domain.entities.Product;
import com.lcseferreira.domain.entities.enums.OrderStatus;
import com.lcseferreira.domain.repositories.ClientRepository;
import com.lcseferreira.domain.repositories.OrderItemRepository;
import com.lcseferreira.domain.repositories.OrderRepository;
import com.lcseferreira.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
public class DomainApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public static void main(String[] args) {
        SpringApplication.run(DomainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Client c1 = new Client(null, "Lucas Ferreira", "lucas@email.com");

        clientRepository.save(c1);

		Product p1 = new Product(null, "TV", 2000.0);
		Product p2 = new Product(null, "PlayStation 5", 5200.0);
		Product p3 = new Product(null, "Notebook i7", 4900.0);

		productRepository.saveAll(Arrays.asList(p1, p2, p3));

        Order o1 = new Order(null, Instant.parse("2021-04-18T11:25:10Z"), OrderStatus.PAID, c1);
        Order o2 = new Order(null, Instant.parse("2021-04-20T13:30:00Z"), OrderStatus.WAITING, c1);

        orderRepository.saveAll(Arrays.asList(o1, o2));

        OrderItem orderItem1 = new OrderItem(null, 1, 2000.0, p1, o1);
        OrderItem orderItem2 = new OrderItem(null, 2, 5200.0, p2, o1);

        OrderItem orderItem3 = new OrderItem(null, 2, 5200.0, p2, o2);
        OrderItem orderItem4 = new OrderItem(null, 2, 4900.0, p3, o2);

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
    }
}
