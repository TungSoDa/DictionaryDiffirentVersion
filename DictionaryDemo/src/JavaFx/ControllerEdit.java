package JavaFx;

import dictionary.DictionaryCommandline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerEdit {
    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
    @FXML
    private TextField themtv;
    @FXML
    private TextField themenglish;

    @FXML
    private Button edit;
    public void edittoWord(ActionEvent event) {
        if (!themenglish.getText().equals("") && !themtv.getText().equals("")) {
            dictionaryCommandline.addWord(themenglish.getText(), themtv.getText());
            themenglish.clear();
            themtv.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations");
            alert.setContentText("Bạn đã sửa thành công!");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Mời nhập từ");
            alert.show();
        }
    }
}