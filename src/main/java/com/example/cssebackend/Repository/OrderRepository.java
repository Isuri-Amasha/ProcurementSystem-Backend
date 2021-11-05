package com.example.cssebackend.Repository;

import com.example.cssebackend.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByVendorId (String vendorId);

    List<Order> findByVendorName (String vendorName);
}
