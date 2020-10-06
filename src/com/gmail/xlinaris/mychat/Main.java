package com.gmail.xlinaris.mychat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static final ObservableList<String> LIST_CHARTERERS = FXCollections.observableArrayList("Ivanof's", "Petrof's", "Vodkin's");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindowChat.fxml"));
        primaryStage.setTitle("My Net Chat");
        primaryStage.setScene(new Scene(root, 602, 402));
        primaryStage.show();
    }


}
