package com.example.employeemanager.controller;

import com.example.employeemanager.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeeController {

    @FXML
    private TextField nameEmployeeTF;

    @FXML
    private TextField salaryEmployeeTF;

    private MainController mainController;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }


    @FXML
    public void onAddEmployee(ActionEvent event) {
        String name = nameEmployeeTF.getText();
        String salary = salaryEmployeeTF.getText();
        try {
            int salario = Integer.parseInt(salary);
            Employee empleado = new Employee(name, salario);
            mainController.addEmployee(empleado);

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al agregar empleado");
            alert.setHeaderText(null);
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
