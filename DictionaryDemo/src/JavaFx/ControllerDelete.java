package JavaFx;

import dictionary.DictionaryCommandline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerDelete {
    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
    @FXML
    private TextField deltext;

    @FXML
    private Button delete;
    public void deleteWord(ActionEvent event) {
        if (!deltext.getText().equals("")){
            dictionaryCommandline.deleteWord(deltext.getText());
            deltext.clear();
        }
    }
}
