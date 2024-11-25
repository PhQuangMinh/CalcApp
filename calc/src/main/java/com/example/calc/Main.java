package com.example.calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainCalc.class.getResource("maincalc.fxml"));
        Parent root = fxmlLoader.load();
        MainCalc mainCalc = fxmlLoader.getController();
        mainCalc.init();
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Calculation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}