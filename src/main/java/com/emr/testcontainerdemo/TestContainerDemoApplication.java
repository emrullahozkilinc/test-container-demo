package com.emr.testcontainerdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestContainerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestContainerDemoApplication.class, args);
    }

}

@Entity
@Data
class Customer {
    @Id Long id;
    String name;
}

interface CustomerRepository extends CrudRepository<Customer, Long> {}

@RequiredArgsConstructor
@RestController
class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}

