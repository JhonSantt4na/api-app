package com.santt4na.rapidinner_delivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rapidinner_delivery.enums.Role;
import com.santt4na.rapidinner_delivery.model.identity.Customer;
import com.santt4na.rapidinner_delivery.model.identity.DeliveryMan;
import com.santt4na.rapidinner_delivery.model.identity.User;

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
    customer.setUser(userCustomer);

    DeliveryMan deliveryMan = new DeliveryMan();
    deliveryMan.setAvailable(true);
    deliveryMan.setUser(userDeliveryMan);

    String msg = "Cusotmer: " + userCustomer.toString()
        + "DeliveryMan: " + deliveryMan.toString();

    log.info("EndPoint '/test' Accessed");
    return msg;
  }
}
