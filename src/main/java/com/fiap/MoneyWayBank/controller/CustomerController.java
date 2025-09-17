package com.fiap.MoneyWayBank.controller;


import com.fiap.MoneyWayBank.model.Customer;
import com.fiap.MoneyWayBank.repository.CustomerRepository;
import com.fiap.MoneyWayBank.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> index(){
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer get(@PathVariable Long id ){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public List<Customer> indexCpf(@PathVariable String cpf){
        return customerService.buscarPorCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy (@PathVariable Long id){
        customerRepository.delete(customerService.getCustomerById(id));
    }

    @PutMapping("{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customerUpdated){
        customerService.getCustomerById(id);
        customerUpdated.setId(id);
        return customerRepository.save(customerUpdated);
    }
}
