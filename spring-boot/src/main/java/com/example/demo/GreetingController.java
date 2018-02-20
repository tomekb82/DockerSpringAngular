package com.example.demo;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello oo, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/save")
    public String process() {
        repository.save(new Customer("Jack", "Smith"));
        repository.save(new Customer("Adam", "Johnson"));
        repository.save(new Customer("Kim", "Smith"));
        repository.save(new Customer("David", "Williams"));
        repository.save(new Customer("Peter", "Davis"));
        return "Done";
    }

    @Transactional(readOnly = true)
    @RequestMapping("/findall")
    public String findAllByStream() {
        List<String> mapstream = Collections.emptyList();

        try (Stream<Customer> stream = repository.findAllCustomers()) {
            mapstream = stream.map(customer -> customer.toString()).collect(Collectors.toList());
        }

        return mapstream.toString();
    }

    @Transactional(readOnly = true)
    @RequestMapping("/findalllastname")
    public String findAllLastNameByStream() {
        List<String> mapstream = Collections.emptyList();;

        try (Stream<String> stream = repository.findAllandShowLastName()) {
            mapstream = stream.collect(Collectors.toList());
        }

        return mapstream.toString();
    }

    @Transactional(readOnly = true)
    @RequestMapping("/findbylastname")
    public String fetchDataByLastNameWithStream(@RequestParam("lastname") String lastName) {
        List<String> mapstream = Collections.emptyList();

        try (Stream<Customer> stream = repository.findByLastName(lastName)) {
            mapstream = stream.map(customer -> customer.toString()).collect(Collectors.toList());
        }

        return mapstream.toString();
    }
}
