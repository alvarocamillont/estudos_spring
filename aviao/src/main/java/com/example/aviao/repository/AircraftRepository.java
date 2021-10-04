package com.example.aviao.repository;

import com.example.aviao.domain.Aircraft;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft,Long> {
}
