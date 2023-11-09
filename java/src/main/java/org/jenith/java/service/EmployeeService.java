package org.jenith.java.service;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.jenith.java.dao.CityDao;
import org.jenith.java.entity.Employee;
import org.jenith.java.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    CityRepository employeeRepository;


    //CityDao filloDao;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Map<String, String> readCSVFile() throws FilloException {
        return readDataFromCSVFile();
    }

    public Map<String, String> updateCSVFile() throws FilloException {
        return updateDataOnCSVFile();// filloDao.updateCSVFile();
    }


    private Map<String, String> readDataFromCSVFile() throws FilloException {
        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection("C:\\Data\\Test.xlsx");
        //String strQuery="Select * from Sheet1 where ID=100 and name='John'";
        String strQuery = "Select * from Sheet1 where name='John'";
        Recordset recordset = connection.executeQuery(strQuery);
        Map<String, String> filloData = new HashMap<>();
        while (recordset.next()) {
            System.out.println("JAI12::" + recordset.getField("name"));
            filloData.put(recordset.getField("id"), recordset.getField("name"));
        }

        recordset.close();
        connection.close();
        return filloData;
    }


    private Map<String, String> updateDataOnCSVFile() throws FilloException {
        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection("C:\\Data\\Test.xlsx");
        List<Integer> ids = new ArrayList<>();
        ids.add(100);
        ids.add(99);
        for(int i=0;i<=1;i++) {
            String strQuery = "Update Sheet1 Set column3='IND' where ID="+ids.get(i);
            connection.executeUpdate(strQuery);
        }
        String strSelectQuery = "Select * from Sheet1 where ID=100";
        Recordset recordset = connection.executeQuery(strSelectQuery);
        Map<String, String> filloData = new HashMap<>();
        while (recordset.next()) {
            System.out.println("JAI12::" + recordset.getField("column3"));
            filloData.put(recordset.getField("id"), recordset.getField("column3"));
        }

        recordset.close();
        connection.close();
        return filloData;
    }

    private Map<String, String> insertCSVFile() throws FilloException {
        return null;
    }
}
