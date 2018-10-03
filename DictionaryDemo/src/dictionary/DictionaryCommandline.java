package dictionary;

import java.util.ArrayList;
public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void showAllWord() {
        int i = 1;
        ArrayList<Word> words = dictionaryManagement.dictionary.getWords();
        System.out.println("No\t" + "| English\t" + "| Vietnamese");
        int size = words.size();
//        for(i=0;i<size;i++) {
//            System.out.println(i+1 + "\t| " + words.get(i).getWord_target() + "\t| " + words.get(i).getWord_explain());
//            //i++;
//        }
        for (Word word : words) {
            System.out.println(i + "\t| " + word.getWord_target() + "\t| " + word.getWord_explain());
            i++;
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        dictionaryManagement.insertFromCommandline();
        dictionaryManagement.insertFromCommandline();
        showAllWord();
    }
    public void dictionaryAdvance(){
        dictionaryManagement.insertFromFile();
        dictionaryManagement.dictionaryLookup();
        showAllWord();
    }
    public void dictionarySearch(){

    }


}

