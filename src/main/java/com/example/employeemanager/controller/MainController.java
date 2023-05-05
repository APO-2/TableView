package com.example.employeemanager.controller;

import com.example.employeemanager.MainApplication;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Integer> ageColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private EmployeeList employeeList;

    public void initialize(EmployeeList employeeList) {
        this.employeeList = employeeList;

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        System.out.println(tableView);
        tableView.setItems(
                employeeList.getEmployees()
        );
    }

    public void onAddEmployee(ActionEvent event) {
        FXMLLoader loader = MainApplication.renderView("add-employee-view.fxml");
        AddEmployeeController addEmployeeController = loader.getController();
        addEmployeeController.setEmployeeList(this.employeeList);
        editButton.setDisable(false);
    }

}
