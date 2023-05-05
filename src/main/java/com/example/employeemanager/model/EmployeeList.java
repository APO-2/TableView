package com.example.employeemanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private static EmployeeList instance;

    private ObservableList<Employee> employees;

    public EmployeeList() {
        employees = FXCollections.observableArrayList();
    }

    public static synchronized EmployeeList getInstance() {
        if (instance == null) {
            instance = new EmployeeList();
        }
        return instance;
    }

    public ObservableList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(int index, Employee employee) {
        employees.set(index, employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }
}
