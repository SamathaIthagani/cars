package com.example.cars.repository;

import com.example.cars.domain.Brand;
import com.example.cars.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c JOIN c.brand b WHERE b.name = :name")
    List<Car> findCarsByBrand(@Param("name") String name);
}