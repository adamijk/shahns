package org.jenith.java.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//mark class as an Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//defining class name as Table name
@Table(name = "EMPLOYEE")
public class Employee {
    //mark id as primary key
    @Id
//defining id as column name
    @Column
    private int code;
    //defining name as column name
    @Column
    private String name;
    //defining age as column name
    @Column
    private String dept;
    //defining email as column name
    @Column
    private Double salary;
}