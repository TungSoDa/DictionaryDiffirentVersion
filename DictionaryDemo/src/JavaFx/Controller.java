package JavaFx;


import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.translator.GoogleTranslate;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import de.dfki.lt.freetts.en.us.MbrolaVoice;
import dictionary.DictionaryCommandline;
import dictionary.DictionaryManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private static String fromLang = "en";
    private static String toLang = "vi";

    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
    @FXML
    ListView<String> list_english;
    @FXML
    WebView list_vn;
    @FXML
    private TextField textField;
    @FXML
    Button button;
    @FXML
    Button them;

    @FXML
    Button clearButton;
    @FXML
    Button speakButton;

    @FXML
    Button delteteWord;
    @FXML
    Button editWord;

    @FXML
    public void addWord(ActionEvent event) {
        Stage primaryStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddWord.fxml"));
            primaryStage.setTitle("Add");
            primaryStage.setScene(new Scene(root, 300, 300));
            primaryStage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void handleMouseClick(MouseEvent event) {

        dictionaryManagement.insertFromFile();
        String S = list_english.getSelectionModel().getSelectedItems().toString();
        String word_english = S.substring(1, S.length() - 1);
        String word_vn = dictionaryManagement.dictionaryLookup(word_english);
        if (word_vn != null) {
//            ArrayList<String> arrayList_mean = new ArrayList<>();
//            arrayList_mean.add(word_vn);
            WebEngine webEngine = list_vn.getEngine();
            webEngine.loadContent(word_vn);
            //list_vn.getItems().setAll(arrayList_mean);
            //list_mean.setAll(arrayList_mean);

        }
        textField.setText(list_english.getSelectionModel().getSelectedItem());

    }

    private ObservableList<String> list = FXCollections.observableArrayList();
    private ObservableList<String> list_mean = FXCollections.observableArrayList();

    public void Translate(ActionEvent event) {
        try {
            //ArrayList<String> arrayList_mean = new ArrayList<>();
            // arrayList_mean.add(GoogleTranslate.translate(fromLang,toLang,textField.getText()));
            //arrayList_mean.add(Translator.translate(fromLang,toLang,textField.getText()));
            // list_vn.getItems().setAll(arrayList_mean);
            String s = GoogleTranslate.translate(fromLang,toLang,textField.getText());
            WebEngine webEngine = list_vn.getEngine();
            webEngine.loadContent(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWord(ActionEvent event){

        Stage primaryStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DeleteWord.fxml"));
            primaryStage.setTitle("Delete");
            primaryStage.setScene(new Scene(root, 300, 300));
            primaryStage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void editWord(ActionEvent event){

        Stage primaryStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("EditWord.fxml"));
            primaryStage.setTitle("Edit");
            primaryStage.setScene(new Scene(root, 300, 300));
            primaryStage.show();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    @FXML
    public void SearchText(KeyEvent event) throws Exception {
        list_english.getItems().clear();
        // list_vn.getCssMetaData().clear();
        dictionaryCommandline.file();
        ArrayList<String> stringWords = dictionaryCommandline.dictionarySearch(textField.getText());
        list.addAll(stringWords);
//        if (textField.getText().equals("")) {
//            list_english.getItems().clear();
//        }

    }


    @FXML
    public void actionPerformed(ActionEvent e) {
        //System.setProperty("mbrola.base", "C:\\Users\\DELL\\Desktop\\mbr301d\\mbrola");
        if (e.getSource() == clearButton) {
            textField.setText("");
            //list_vn.getItems().clear();
            list_english.getItems().clear();
            list_vn.getEngine().load("");
        }
        if (e.getSource() == speakButton) {
            Voice voice;//Creating object of Voice class
            voice = VoiceManager.getInstance().getVoice("kevin");//Getting voice
            if (voice != null) {
                voice.allocate();//Allocating Voice
            }
            try {
                voice.setRate(190);//Setting the rate of the voice
                voice.setPitch(150);//Setting the Pitch of the voice
                voice.setVolume(10);//Setting the volume of the voice
                voice.speak(textField.getText());//Calling speak() method
            } catch (Exception ex) {

                ex.printStackTrace();
            }

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        list_english.setItems(list);
//        DictionaryManagement.insertFromFile(word_english,word_vietnamese);
//        list_vn.setItems(list_mean);
        //list_vn.setItems(list_mean);
    }
}
