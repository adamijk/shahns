package org.jenith.java.dao;

import com.codoid.products.exception.FilloException;
import org.jenith.java.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Map;


public interface CityDao {
    public Employee getCityById(Integer cityId);

    public Map<String, String> readCSVFile() throws FilloException;

    public Map<String, String> updateCSVFile() throws FilloException;

    public Map<String, String> insertCSVFile() throws FilloException;
}

