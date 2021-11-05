package com.example.cssebackend.Controller;

import com.example.cssebackend.Model.Order;
import com.example.cssebackend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addNewOrder(@RequestBody Order order){
        try {
            orderService.addOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllOrders(){
        try {
            List<Order> orders = orderService.getAllOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable String id){
        try {
            return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> createOrderId(){
        try {
            return new ResponseEntity<>(orderService.createOrderId(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/pendingOrders")
    public ResponseEntity<?> getPendingOrders(){
        try {
            List<Order> orders = orderService.getPendingOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/approvedOrders")
    public ResponseEntity<?> getApprovedOrders(){
        try {
            List<Order> orders = orderService.getApprovedOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/automaticallyApprovedOrders")
    public ResponseEntity<?> getAutomaticallyApprovedOrders(){
        try {
            List<Order> orders = orderService.getAutomaticallyApprovedOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rejectedOrders")
    public ResponseEntity<?> getRejectedOrders(){
        try {
            List<Order> orders = orderService.getRejectedOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<?> approveOrder(@PathVariable String id){
        try {
            orderService.approveOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/reject/{id}")
    public ResponseEntity<?> rejectOrder(@PathVariable String id){
        try {
            orderService.rejectOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/delivered/{id}")
    public ResponseEntity<?> confirmDelivery(@PathVariable String id){
        try {
            orderService.confirmDelivery(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/paidOrders")
    public ResponseEntity<?> getPaidOrders(){
        try {
            List<Order> orders = orderService.getPaidOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/notPaidOrders")
    public ResponseEntity<?> getNotPaidOrders(){
        try {
            List<Order> orders = orderService.getNotPaidOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/deliveredOrders")
    public ResponseEntity<?> getDeliveredOrders(){
        try {
            List<Order> orders = orderService.getDeliveredOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/notDeliveredOrders")
    public ResponseEntity<?> getNotDeliveredOrders(){
        try {
            List<Order> orders = orderService.getNotDeliveredOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/getByUserId/{vendorId}")
//    public ResponseEntity<?> getAllOrdersByUserId(@PathVariable String vendorId){
//        try {
//            List<Order> orders = orderService.getOrdersByUserId(vendorId);
//            return new ResponseEntity<>(orders, HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("/getByUserId/{vendorId}")
    public ResponseEntity<List<Order>> getAllOrdersByUserId(@PathVariable String vendorId) {

        return new ResponseEntity<>(orderService.getOrdersByUserId(vendorId), HttpStatus.OK);

    }

//    @GetMapping("/getByUserId/{vendorName}")
//public ResponseEntity<List<Order>> getAllOrdersByUserName(@PathVariable String vendorName) {
//    return new ResponseEntity<>(orderService.getOrdersByUserName(vendorName), HttpStatus.OK);
//}

    @GetMapping("/approvedOrdersByUserId/{vendorId}")
    public ResponseEntity<?> getApprovedOrdersByUserId(@PathVariable String vendorId){
        try {
            List<Order> orders = orderService.getApprovedOrdersByUserId(vendorId);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rejectedOrdersByUserId/{vendorId}")
    public ResponseEntity<?> getRejectedOrdersByUserId(@PathVariable String vendorId){
        try {
            List<Order> orders = orderService.getRejectedOrdersByUserId(vendorId);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/pendingOrdersByUserId/{vendorId}")
    public ResponseEntity<?> getPendingOrdersByUserId(@PathVariable String vendorId){
        try {
            List<Order> orders = orderService.getPendingOrdersByUserId(vendorId);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/automaticallyApprovedOrdersByUserId/{vendorId}")
    public ResponseEntity<?> getAutomaticallyApprovedOrdersByUserId(@PathVariable String vendorId){
        try {
            List<Order> orders = orderService.getAutomaticallyApprovedOrdersByUserId(vendorId);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/deliveredOrdersByUserId/{vendorId}")
    public ResponseEntity<?> getDeliveredOrdersByUserId(@PathVariable String vendorId){
        try {
            List<Order> orders = orderService.getDeliveredOrdersByUserId(vendorId);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/inProgressOrdersByUserId/{vendorId}")
    public ResponseEntity<?> getInProgressOrdersByUserId(@PathVariable String vendorId){
        try {
            List<Order> orders = orderService.getInProgressOrdersByUserId(vendorId);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




    @GetMapping("/pendingApprovalDelivery")
    public ResponseEntity<?> getPendingApprovalDelivery(){
        try {
            List<Order> orders = orderService.getPendingApprovalDelivery();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/pendingApprovalPayment")
    public ResponseEntity<?> getPendingApprovalPayment(){
        try {
            List<Order> orders = orderService.getPendingApprovalPayment();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
