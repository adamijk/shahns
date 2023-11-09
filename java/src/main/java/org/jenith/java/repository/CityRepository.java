package org.jenith.java.repository;

import org.jenith.java.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<Employee, Integer> {

}