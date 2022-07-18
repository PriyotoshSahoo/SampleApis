package com.example.testspringboot.restservices;

import com.example.testspringboot.entities.Subscription;
import com.example.testspringboot.restrepository.RepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServices implements HelloInterface {

  @Autowired
  private RepoInterface repo;


  @Override
  public Subscription fetchSubscriberDetails(int accountNumber) {

    return repo.findById(accountNumber).get();
  }

  @Override
  public Subscription createSubscriberDetails(Subscription sub) {
    return repo.save(sub);
  }

  @Override
  public Subscription updateSubscriberDetails(Subscription updateSub) {
    return repo.save(updateSub);
  }

  @Override
  public void deleteSubscriberDetails(int accountNumber) {
    repo.deleteById(accountNumber);
  }


}
