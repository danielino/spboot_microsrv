package it.partec.test.hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.partec.test.hello.models.Customer;
import it.partec.test.hello.models.CustomerRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomersController {

    @Autowired
    private CustomerRepository repository;

    /**
     * get all customers
     * @return
     */
    @RequestMapping("/customers")
    List<Customer> list(){
        new Exception("test");
        return repository.findAll();

    }

    /**
     * create customer
     * @param name
     * @param description
     * @return
     */
    @RequestMapping(value="/customers/create", method=RequestMethod.POST)
    Customer create(@RequestParam(value="name") String name,
        @RequestParam(value="description") String description)
    {

        Customer customer = new Customer(name, description);
        return repository.save(customer);
    }

    /**
     * delete customer by id
     * @param id
     */
    @RequestMapping(value="/customers/delete", method=RequestMethod.POST)
    void delete(@RequestParam(value="id") String id) {
        Optional customer = repository.findById(id);
        repository.deleteById(id);
    }
}
