package com.example.employeemanager.controller;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeeController {

    @FXML
    private TextField nameEmployeeTF;

    @FXML
    private TextField ageEmployeeTF;

    private EmployeeList employeeList;

    public void setEmployeeList(EmployeeList employeeList){
        this.employeeList = employeeList;
    }

    @FXML
    public void onAddEmployee(ActionEvent event) {
        String name = nameEmployeeTF.getText();
        String salary = ageEmployeeTF.getText();
        try {
            int ageInteger = Integer.parseInt(salary);
            Employee employee = new Employee(name, ageInteger);
            employeeList.addEmployee(employee);

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al agregar empleado");
            alert.setContentText("El salario debe ser un número válido.");
            alert.showAndWait();
        }
    }

    @FXML
    public void onClose(ActionEvent event) {
        Stage stage = (Stage) nameEmployeeTF.getScene().getWindow();
        stage.close();
    }
}
