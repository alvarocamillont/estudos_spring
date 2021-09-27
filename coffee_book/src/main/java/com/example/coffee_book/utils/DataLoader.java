package com.example.coffee_book.utils;

import com.example.coffee_book.models.Coffee;
import com.example.coffee_book.repositories.CoffeeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {

    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository){
        this.coffeeRepository =coffeeRepository;
    }

    @PostConstruct
    private void loadData(){
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Trê Pontas")
        ));
    }
}
