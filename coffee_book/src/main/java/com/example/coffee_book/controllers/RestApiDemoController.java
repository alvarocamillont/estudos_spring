package com.example.coffee_book.controllers;

import com.example.coffee_book.models.Coffee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestApiDemoController {
    private static final String path = "/coffees";
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController(){
        coffees.addAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Trê Pontas")
        ));
    }

    @RequestMapping(value=path,method = RequestMethod.GET)
    Iterable<Coffee> getCoffees(){
        return coffees;
    }

    @GetMapping(path+"/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        for (Coffee c:coffees){
            if(c.getId().equals(id)){
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    @PostMapping(path)
    Coffee postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping(path+"/{id}")
    Coffee putCoffee(@PathVariable String id,@RequestBody Coffee coffee){
        int coffeeIndex = -1;
        for (Coffee c:coffees){
            if (c.getId().equals(id)){
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex,coffee);
            }
        }

        return (coffeeIndex == -1) ? postCoffee(coffee):coffee;
    }

    @DeleteMapping(path+"/{id}")
    void deletCoffee(@PathVariable String id ){
       coffees.removeIf(c->c.getId().equals(id));
    }

}


