package dictionary;

import java.io.*;
import java.util.*;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();


//    public DictionaryCommandline(){
//        this.dictionaryManagement.insertFromFile();
//    }
    public void showAllWord(){

        Set<String> setkey = dictionaryManagement.dictionary.map.keySet();

        for (String word : setkey) {
            System.out.println(dictionaryManagement.dictionary.map.get(word));
        }
    }
    public void Advance(){
        dictionaryManagement.insertFromFile();
        dictionaryManagement.dictionaryLookup();
        //showAllWord();
    }


    public ArrayList<String> dictionarySearch(String word_target) {

        Set<String> ketSet = dictionaryManagement.dictionary.map.keySet();// ngẫu nhiên
        ArrayList<String> word_ = new ArrayList<>();
        //TreeMap<String,String> long_list = new TreeMap<>();
        for (String word : ketSet) {
            if (word.startsWith(word_target)) {
                word_.add(word);
            }

        }
        return word_;
    }
    public void file() {
        dictionaryManagement.insertFromFile();
    }

    public void addWord(){

        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {

            Scanner sc = new Scanner(System.in);
            String word_target = sc.nextLine();
            String word_explain = sc.nextLine();
            String word = "\n" + word_target + "\t" + word_explain;
            File file = new File("dictionary.txt");

            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            fileWriter.write(word);
            System.out.println("Xong");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    //    public void NewArray(String word_target, String word_explain){
//        Map<String,String> newmap;
//        newmap = dictionaryManagement.dictionary.map;
//        if (newmap.keySet().equals(word_explain)){
//            return;
//        }
//        else dictionaryManagement.dictionary.map.put(word_target, word_explain);
//    }
    // addWord Controller
    public void addWord(String word_target, String word_explain) {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try {

            Scanner sc = new Scanner(System.in);
            String word = "\n" + word_target + "\t" + word_explain;
            File file = new File("dictionary.txt");
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            bufferedWriter = new BufferedWriter(fileWriter);
            if (word_target != null && word_explain != null) fileWriter.write(word);
            else return;
            System.out.println("Success!!!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deleteWord(String word_tareget){


        Set<String> keySet = dictionaryManagement.dictionary.map.keySet();
        for (String word : keySet){
            if (word.equals(word_tareget)) {
                dictionaryManagement.dictionary.map.remove(word);
            }
        }
        File file =new File ("dictionary.txt");
        try (FileWriter fw = new FileWriter (file,true); BufferedWriter bf = new BufferedWriter(fw) ;
             PrintWriter pw = new PrintWriter(bf) ){
            for (String word : keySet)   {
                pw.println(word + "\t" + dictionaryManagement.dictionary.map.keySet());
            }
        }
        catch (Exception e){
        }

    }
//    public void dictionaryExportToFile(){
//
//        Map<String,String> newmap = dictionaryManagement.dictionary.map;
//        // make a obj file ,  we read data from this file;
//        File file =new File ("dictionary.txt");
//        try (FileWriter fw = new FileWriter (file,true); BufferedWriter bf = new BufferedWriter(fw) ;
//             PrintWriter pw = new PrintWriter(bf) ){
//            for (String word : newmap.keySet())   {
//                pw.println(word + "\t" + newmap.keySet());
//            }
//        }
//        catch (Exception e){
//        }
//    }
}

