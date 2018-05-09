package com.bsuir.aipos;

import com.bsuir.aipos.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new MainWindow();
    }


    public static void main(String[] args) {
        launch(args);
    }
}