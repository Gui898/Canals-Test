package com.example.canals.service;

import com.example.canals.DTO.OrderProdDTO;
import com.example.canals.DTO.OrderRequest;
import com.example.canals.exceptions.PaymentFailedException;
import com.example.canals.exceptions.ProductNotFoundException;
import com.example.canals.exceptions.ServerException;
import com.example.canals.exceptions.OrderNotFoundException;
import com.example.canals.models.*;
import com.example.canals.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final ProductService productService;
    private WarehouseService warehouseService;

    @Transactional
    public Order createOrder(OrderRequest request){

        try{
            List<OrderProd> listProducts = new ArrayList<>();

            Address address = new Address(
                    request.shippingAddress().country(),
                    request.shippingAddress().state(),
                    request.shippingAddress().city(),
                    request.shippingAddress().street(),
                    request.shippingAddress().residenceNumber(),
                    request.shippingAddress().apartment());

            BigDecimal totalValue = new BigDecimal(0);

            Order order = new Order();
            order.setCustomer(request.customer());

            for(OrderProdDTO item : request.productsList()){

                int quantity = item.quantity();

                Product product = productService.getProduct(item.productId());
                OrderProd orderProd = new OrderProd(product, quantity);

                BigDecimal val = product.getValueProduct().multiply(BigDecimal.valueOf(quantity));

                totalValue = totalValue.add(val);

                listProducts.add(orderProd);
            }

            boolean verify_payment = paymentService.processPayment(request.paymentInfo(), totalValue);

            if(verify_payment){
                order.setStatus(OrderStatus.PAID);
            }else{
                order.setStatus(OrderStatus.PAYMENT_FAILED);
                throw new PaymentFailedException("Payment failed!");
            }

            order.setAddress(address);
            order.setProductList(listProducts);

            return order;
        }catch (NoSuchElementException e){
            throw new ProductNotFoundException("Product not found!");
        }
    }

    public List<Order> getOrders(){
        try{
            return orderRepository.findAll();
        }catch (DataAccessException e){
            throw new ServerException("Something went wrong...");
        }
    }

    public Order getOrder(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

    }

}
