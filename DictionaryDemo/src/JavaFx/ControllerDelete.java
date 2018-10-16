package JavaFx;

import dictionary.DictionaryCommandline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations");
            alert.setContentText("Bạn đã xóa thành công!");
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
