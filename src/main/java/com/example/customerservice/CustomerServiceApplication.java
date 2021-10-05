package com.example.customerservice;

import com.example.customerservice.dao.CustomerRepository;
import com.example.customerservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        restConfiguration.exposeIdsFor(Customer.class);
        customerRepository.save(new Customer(null,"SalahEddine","salahEddine@gmail.com"));
        customerRepository.save(new Customer(null,"Mohammed","Mohammed@gmail.com"));
        customerRepository.save(new Customer(null,"Youssef","Youssef@gmail.com"));

        customerRepository.findAll().forEach(c->{
            System.out.println(c.toString());
        });
    }
}
