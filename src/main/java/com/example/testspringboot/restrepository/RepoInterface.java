package com.example.testspringboot.restrepository;

import com.example.testspringboot.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoInterface extends JpaRepository<Subscription, Integer> {


}
