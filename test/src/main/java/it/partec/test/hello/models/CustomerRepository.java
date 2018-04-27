package it.partec.test.hello.models;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>{

    void delete(Customer customer);
}
