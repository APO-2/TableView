package com.example.employeemanager;

import com.example.employeemanager.controller.MainController;
import com.example.employeemanager.model.EmployeeList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        EmployeeList employeeList = new EmployeeList();
        FXMLLoader loader =  renderView("main-view.fxml");
        MainController controller = loader.getController();
        controller.initialize(employeeList);
    }

    public static FXMLLoader renderView(String fxml){
        FXMLLoader fxmlLoader = null;
        try {

            fxmlLoader = new FXMLLoader(
                    MainApplication.class.getResource(fxml)
            );

            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent, 320, 240);
            Stage stage = new Stage();
            stage.setTitle("Employees App");
            stage.setScene(scene);
            stage.show();

        }catch (IOException ex){
            ex.getMessage();
            ex.printStackTrace();
        }
        return fxmlLoader;
    }

    public static void main(String[] args) {
        launch();
    }
}