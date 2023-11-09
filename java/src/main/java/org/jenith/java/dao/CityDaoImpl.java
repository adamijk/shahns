package org.jenith.java.dao;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.jenith.java.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class CityDaoImpl implements CityDao {
    public Employee getCityById(Integer cityId) {
        return new Employee();
    }

    @Override
    public Map<String, String> readCSVFile() throws FilloException {
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

    @Override
    public Map<String, String> updateCSVFile() throws FilloException {
        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection("C:\\Data\\Test.xlsx");
        String strQuery = "Update Sheet1 Set column3='US' where ID in (100,99)";

        connection.executeUpdate(strQuery);
        String strSelectQuery = "Select * from Sheet1 where  ID in (100,99)";
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

    @Override
    public Map<String, String> insertCSVFile() throws FilloException {
        return null;
    }
}
