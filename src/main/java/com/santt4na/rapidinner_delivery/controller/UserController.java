package com.santt4na.rapidinner_delivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rapidinner_delivery.entities.Customer;
import com.santt4na.rapidinner_delivery.entities.DeliveryMan;
import com.santt4na.rapidinner_delivery.entities.User;
import com.santt4na.rapidinner_delivery.enums.Role;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

  @GetMapping("/hello")
  public String hello() {
    log.info("EndPoint '/hello' Accessed");
    return "Hello, Wellcome to Rapidinner.";
  }

  @GetMapping("/test")
  public String test() {

    User userCustomer = new User(
        "Jhon Customer",
        "jhon@Customer.com",
        "senha123",
        Role.ROLE_CUSTOMER);

    User userDeliveryMan = new User(
        "Jhon DeliveryMan",
        "jhon@DeliveryMan.com",
        "senha123",
        Role.ROLE_DELIVERYMAN);

    Customer customer = new Customer();
    customer.setPhone("11999998888");
    customer.setAddress("Local Host kk, 123");
    customer.setUser(userCustomer);

    DeliveryMan deliveryMan = new DeliveryMan();
    deliveryMan.setVehicle("Moto XYZ");
    deliveryMan.setAvailable(true);
    deliveryMan.setUser(userDeliveryMan);

    String msg = "Cusotmer: " + userCustomer.toString()
        + "DeliveryMan: " + deliveryMan.toString();

    log.info("EndPoint '/test' Accessed");
    return msg;
  }

}
