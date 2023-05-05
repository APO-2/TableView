package com.example.employeemanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeList {

    private ObservableList<Employee> employees;

    public EmployeeList() {
        employees = FXCollections.observableArrayList();
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
