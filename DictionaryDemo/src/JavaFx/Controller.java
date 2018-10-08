package JavaFx;


import dictionary.DictionaryCommandline;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;


public class Controller{

    DictionaryCommandline dc = new DictionaryCommandline();
    @FXML
    ListView<String> wordListView;
    @FXML
    TextField textField;
    @FXML
    Button button;

    public void actionSearch(String s) {
        ArrayList<String> stringWords = dc.dictionarySearch(s);
        ObservableList<String> list = FXCollections.observableArrayList(stringWords);
        wordListView = new ListView<>(list);
        System.out.println(wordListView.getItems());
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(wordListView);

    }
    @FXML
    public void SearchText(ActionEvent keyEvent){
        if (keyEvent.getSource() == textField){
            String sText = textField.getText();
            if (!sText.isEmpty()) {
                this.actionSearch(sText);
                System.out.println(textField.getText());
            }

        }
    }


}
