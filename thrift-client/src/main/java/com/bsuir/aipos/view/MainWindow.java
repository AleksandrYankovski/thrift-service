package com.bsuir.aipos.view;

import com.bsuir.aipos.controler.Controler;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainWindow {

    private Controler controler;
    private Stage primaryStage;
    private AnchorPane root;
    private Scene scene;


    public MainWindow() {
        this.controler = Controler.getInstance();
        this.primaryStage =new Stage();


        root = new AnchorPane();

        createMainWindow();

        this.primaryStage.setTitle("Thrift client");
        this.primaryStage.show();
    }


    private void createMainWindow() {

        scene = new Scene(root, 700, 487);
        root.setStyle("-fx-background-color: green;");




        primaryStage.setScene(scene);
    }


    private void createButton(String name, EventHandler eventHandler, double deltaValue) {
        Button button = new Button();
        button.setText(name);
        button.setOnAction(eventHandler);
        button.setPrefSize(110, 35);
        root.getChildren().add(button);
        AnchorPane.setLeftAnchor(button, deltaValue);
        AnchorPane.setTopAnchor(button, 20.0);
    }





}
