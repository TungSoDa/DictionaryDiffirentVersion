package dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void showAllWord() {
        int i = 0;
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

    public void dictionaryAdvance() {
        dictionaryManagement.insertFromFile();
        //dictionarySearch();
        dictionaryManagement.dictionaryLookup();
        showAllWord();

    }

    public ArrayList<String> dictionarySearch(String word_target) {
        ArrayList<Word> words = dictionaryManagement.dictionary.getWords();
        ArrayList<String> word_ = new ArrayList<>();
//        System.out.println("nhập từ tìm kiếm");
//        Scanner sc = new Scanner(System.in);
//        String word_target = sc.nextLine();
//       int size = words.size();
//       for ( i = 0; i < size; i++) {
//          if (a.equals(words.get(i).getWord_target())) {
//                System.out.println(  words.get(i).getWord_explain());
//            }
//        }
//      }
        for (Word word : words) {
            if (word.getWord_target().startsWith(word_target)) {
                word_.add(word.getWord_target());
            }

        }
        return word_;
    }


}

