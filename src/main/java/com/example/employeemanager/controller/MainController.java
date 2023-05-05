package com.example.employeemanager.controller;

import com.example.employeemanager.MainApplication;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.EmployeeList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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


//        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                editButton.setDisable(false);
//                deleteButton.setDisable(false);
//            } else {
//                editButton.setDisable(true);
//                deleteButton.setDisable(true);
//            }
//        });
    }

    public void addEmployee(Employee employee){
        if (employeeList != null)
            employeeList.addEmployee(employee);
//        tableView.refresh();
    }

    public void onAddEmployee(ActionEvent event) {

        FXMLLoader loader = MainApplication.renderView("add-employee-view.fxml");

        AddEmployeeController controlador = loader.getController();
        controlador.setMainController(this);

    }
}


