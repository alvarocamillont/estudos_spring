package com.example.coffee_book.repositories;

import com.example.coffee_book.models.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee,String> {
}
