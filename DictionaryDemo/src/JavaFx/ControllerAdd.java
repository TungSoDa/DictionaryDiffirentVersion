package JavaFx;


import dictionary.DictionaryCommandline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.util.Optional;

public class ControllerAdd{

    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
    @FXML
    private TextField add_english;
    @FXML
    private TextField add_vietnamese;

    @FXML
    private Button add;


    public void addtoWord(ActionEvent event){
        if (!add_english.getText().equals("") && !add_vietnamese.getText().equals("")) {
            dictionaryCommandline.addWord(add_english.getText(), add_vietnamese.getText());
            add_english.clear();
            add_vietnamese.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations");
            alert.setContentText("Bạn đã thêm thành công!");
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
