package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();

    public void insertFromFile() {

        String s;
        try {
            File file = new File("dictionary.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            while ((s = br.readLine()) != null) {
                String[] item = s.split("\t");
                //Word word = new Word(item[0], item[1]);
                dictionary.map.put(item[0], item[1]);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    public void dictionaryLookup() {
        Set<String> Setkey = dictionary.map.keySet();//

        System.out.println("nhập từ tìm kiếm");
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();

        for (String string : Setkey) {
            if (word_target.equals(string)) {
                System.out.println(dictionary.map.get(string));
            }
        }
    }

    //Lookup Controller
    public String dictionaryLookup(String word_target) {
        Set<String> Setkey = dictionary.map.keySet();

        for (String word_english : Setkey) {
            if (word_target.equals(word_english)) {
                return (dictionary.map.get(word_english));
            }
        }

        return null;
    }

}