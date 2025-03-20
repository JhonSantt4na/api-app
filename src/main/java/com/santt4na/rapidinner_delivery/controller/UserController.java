package com.santt4na.rapidinner_delivery.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santt4na.rapidinner_delivery.dtos.rolesDTO.UserDTO;
import com.santt4na.rapidinner_delivery.model.roles.User;
import com.santt4na.rapidinner_delivery.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/create")
  public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
    try {
      User createdUser = userService.createUser(userDTO);
      return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

}