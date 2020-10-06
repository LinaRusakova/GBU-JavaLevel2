package com.gmail.xlinaris.mychat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class Controller implements Initializable {

    @FXML
    private Button buttonSend;
    @FXML
    private TextField userMessage;
    @FXML
    private Label label;
    @FXML
    private TextArea chatDialogs;
    @FXML
    public ListView<String> listUsers;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listUsers.setItems(FXCollections.observableList(Main.LIST_CHARTERERS));
        MultipleSelectionModel<String> usersSelectionModel = listUsers.getSelectionModel();
        // Set a listener to check userList when a user is selected to respond.
        usersSelectionModel.selectedItemProperty().addListener((changed, oldValue, newValue) -> userMessage.setText("Replay to " + newValue + ": "));
        // Set a listener to perform sending message by click on button or key press Enter.
        buttonSend.setOnAction(actionEvent -> sendMessage());
        userMessage.setOnAction(actionEvent -> sendMessage());

    }

    //Method for sending user message in to chat dialogs.
    private void sendMessage() {
        if (!userMessage.getText().equals("")) {
            chatDialogs.appendText(userMessage.getText() + "\n");
            //chatDialogs.appendText(System.lineSeparator());
            userMessage.clear(); //clearing text field after sending}
        }
    }


}