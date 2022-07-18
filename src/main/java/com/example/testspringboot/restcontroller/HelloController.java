package com.example.testspringboot.restcontroller;

import com.example.testspringboot.entities.Subscription;
import com.example.testspringboot.restservices.HelloServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("ALL")
@RestController
public class HelloController {

  @Autowired
  HelloServices services;

  @Operation(summary = "Get details of a customer")
  @GetMapping(value = "/customer/{accountNumber}", produces = "application/json")
  public Subscription getSubscriber(@PathVariable int accountNumber) {

    Subscription subscriber = null;
    try {
      if (accountNumber > 0) {
        subscriber = services.fetchSubscriberDetails(accountNumber);
      } else {
        throw new Exception("mobileNumber is empty");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return subscriber;
  }

  @Operation(summary = "Create a new customer")
  @PostMapping("/customer/createSubscription")
  public Subscription createSubscriber(@RequestBody Subscription subscrip) {

    Subscription sube = null;
    try {
      if (subscrip != null) {
        sube = services.createSubscriberDetails(subscrip);
      } else {
        throw new Exception("Request is empty or null");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sube;
  }


  @Operation(summary = "Update a customer")
  @PutMapping("/customer/updateSubscription")
  public ResponseEntity updateSubscriber(@RequestBody Subscription subscrip) {

    Subscription sube = null;
    ResponseEntity reply = null;
    try {
      if (subscrip != null && subscrip.getAccountNumber() > 0) {
        sube = services.updateSubscriberDetails(subscrip);
        reply = new ResponseEntity<>(HttpStatus.OK);
      } else {
        reply = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return reply;
  }

  @Operation(summary = "Delete a customer")
  @DeleteMapping("/customer/deletesubscription")
  public ResponseEntity deleteSubscriber(@PathVariable int accountNumber) {

    Subscription sube = null;
    ResponseEntity reply = null;
    try {
      if (accountNumber > 0) {
        services.deleteSubscriberDetails(accountNumber);
        reply = new ResponseEntity<>(HttpStatus.OK);
      } else {
        reply = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return reply;
  }

  @Operation(summary = "Test Response Entity")
  @GetMapping(value = "/service/{mobileNumber}", produces = "application/xml")
  public ResponseEntity fetchSubscriber(@PathVariable String mobileNumber) {

    ResponseEntity response = null;
    try {
      if (mobileNumber != null && !mobileNumber.isEmpty()) {
        response = new ResponseEntity<>(HttpStatus.OK);
      }
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    return response;
  }

  @Operation(summary = "test responsecodes")
  @GetMapping(value = "/param/{mobileNumber}", produces = "application/json")
  public ResponseEntity checkSubscriber(@PathVariable String mobileNumber) {

    ResponseEntity response = null;
    try {
      if (mobileNumber != null && !mobileNumber.isEmpty()) {
        response = new ResponseEntity<>(HttpStatus.OK);
      }
    } catch (Exception e) {
      response = new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    return response;
  }


}
