package com.santt4na.rapidinner_delivery.service;

import org.springframework.stereotype.Service;

import com.santt4na.rapidinner_delivery.dtos.rolesDTO.CustomerDTO;
import com.santt4na.rapidinner_delivery.dtos.rolesDTO.DeliveryManDTO;
import com.santt4na.rapidinner_delivery.dtos.rolesDTO.MerchantDTO;
import com.santt4na.rapidinner_delivery.dtos.rolesDTO.UserDTO;
import com.santt4na.rapidinner_delivery.model.roles.Admin;
import com.santt4na.rapidinner_delivery.model.roles.Customer;
import com.santt4na.rapidinner_delivery.model.roles.DeliveryMan;
import com.santt4na.rapidinner_delivery.model.roles.Merchant;
import com.santt4na.rapidinner_delivery.model.roles.User;
import com.santt4na.rapidinner_delivery.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User createUser(UserDTO userDTO) {

    User newUser = switch (userDTO.getRole()) {
      case ROLE_CUSTOMER -> new Customer();
      case ROLE_MERCHANT -> new Merchant();
      case ROLE_DELIVERYMAN -> new DeliveryMan();
      case ROLE_ADMIN -> new Admin();
    };

    newUser.setEmail(userDTO.getEmail());
    newUser.setPassword(userDTO.getPassword());
    newUser.setName(userDTO.getName());
    newUser.setPhone(userDTO.getPhone());

    if (userDTO instanceof MerchantDTO merchantDTO) {
      Merchant merchant = (Merchant) newUser;
      merchant.setCnpj(merchantDTO.getCnpj());
    }

    if (userDTO instanceof CustomerDTO customerDTO) {
      Customer customer = (Customer) newUser;
      customer.setCpf(customerDTO.getCpf());
    }

    if (userDTO instanceof DeliveryManDTO deliveryManDTO) {
      DeliveryMan deliveryMan = (DeliveryMan) newUser;
      deliveryMan.setCnh(deliveryManDTO.getCnh());
    }

    return userRepository.save(newUser);
  }
}