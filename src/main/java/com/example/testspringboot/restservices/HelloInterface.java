package com.example.testspringboot.restservices;

import com.example.testspringboot.entities.Subscription;

public interface HelloInterface {

  Subscription fetchSubscriberDetails(int accountNumber);

  Subscription createSubscriberDetails(Subscription sub);

  Subscription updateSubscriberDetails(Subscription sub);

  void deleteSubscriberDetails(int accountNumber);


}
