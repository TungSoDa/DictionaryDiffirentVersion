package dictionary;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();

    public void insertFromCommandline() {

        Scanner scanner = new Scanner(System.in);
        String word_target = scanner.nextLine();
        String word_explain = scanner.nextLine();
        Word word = new Word(word_target, word_explain);
        dictionary.pushWords(word);

    }


    public void insertFromFile() {

        String s;
        try {
            File file = new File("dictionary.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            while ((s = br.readLine()) != null) {
                String[] item = s.split("\t");
                Word word = new Word(item[0], item[1]);
                dictionary.pushWords(word);

            }

        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }

    public void dictionaryLookup() {
        ArrayList<Word> words = dictionary.getWords();
        System.out.println("nhập từ tìm kiếm");
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
//        int size = words.size();
//        for (int i = 0; i < size; i++) {
//            if (word_target.equals(words.get(i).getWord_target())) {
//                System.out.println(i + "\t" + words.get(i).getWord_target() + "\t\t" + words.get(i).getWord_explain());
//
//            }
//        }
//        }
        int i = 1;
        for (Word word : words) {
            if (word_target.equals(word.getWord_target())) {
                System.out.println(i + "\t| " + word.getWord_target() + "\t| " + word.getWord_explain());
            }
            i++;
        }

    }
}
