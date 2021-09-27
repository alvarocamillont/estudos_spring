package com.example.coffee_book.controllers;

import com.example.coffee_book.models.Coffee;
import com.example.coffee_book.repositories.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {

    private final CoffeeRepository coffeeRepository;

    public RestApiDemoController(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;

    }

    @GetMapping
    Iterable<Coffee> getCoffees(){
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        return coffeeRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id,@RequestBody Coffee coffee){
        HttpStatus status = coffeeRepository.existsById(id) ? HttpStatus.OK:HttpStatus.CREATED;
        return new ResponseEntity<>(coffeeRepository.save(coffee), status);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id ){
        coffeeRepository.deleteById(id);
    }

}


