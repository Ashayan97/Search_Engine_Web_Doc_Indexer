import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class DicMaker {
    private static DicMaker instance;

    public static DicMaker getInstance() {
        if (instance == null)
            instance = new DicMaker();
        return instance;
    }

    private DicMaker() {
    }


    public void dicMaking(Doc doc[]) {
//        ArrayList<String> wordList = new ArrayList<>();
        HashMap<String, Word> wordHashMap = new HashMap<>();
        HashMap<String, Word> titleHashMap = new HashMap<>();
        HashMap<Integer, Doc> docsHashMap = new HashMap<>();
        int len = doc.length;

        for (Doc i : doc) {
            int id = i.getId();
            docsHashMap.put(i.getId(), i);
            String str = i.getTitle();
            str = str.replace("/", " ");
            str = str.replace(".", " ");
            str = str.replace("،", " ");
            str = str.replace("(", " ");
            str = str.replace("»", " ");
            str = str.replace("«", " ");
            str = str.replace(",", " ");
            str = str.replace("[", " ");
            str = str.replace("]", " ");
            str = str.replace("\"", " ");
            str = str.replace(")", " ");
            str = str.replace(";", " ");
            str = str.replace(":", " ");
            str = str.replace("؛", " ");
            str = str.replace("–", " ");
            str = str.replace("-", " ");
            str = str.replace("@", " ");
            str = str.replace("\\", " ");
            str = str.replace("_", " ");
            str = str.replace("?", " ");
            str = str.replace("!", " ");
            str = str.replace("+", " ");
            str = str.replace("؟", " ");
            str = str.replace("·", " ");
            str = str.replaceAll("[0-9]", "");
            String words[] = str.split(" ");
            Word dicWord;
            for (String word : words) {
                word = word.replace(" ", "");
                if (!word.equals(" ") && !word.equals("")) {
                    if (titleHashMap.containsKey(word)) {
                        dicWord = titleHashMap.get(word);
                        CodedDoc wordDoc = dicWord.getDocs().get(dicWord.getDocs().size() - 1);
                        if (wordDoc.getId() == id) {
                            wordDoc.setTermFreq(wordDoc.getTermFreq() + 1);
                        } else {

                            wordDoc = new CodedDoc(i.getId());//, i.getUrl());
                            dicWord.getDocs().add(wordDoc);
                            dicWord.setDocNum(dicWord.getDocNum() + 1);

                        }

                        titleHashMap.replace(word, dicWord);
                    } else {
//                        if (!wordHashMap.containsKey(word))
//                            wordList.add(word);
                        dicWord = new Word(word, len);
                        CodedDoc wordDoc = new CodedDoc(i.getId());//, i.getUrl());
                        dicWord.getDocs().add(wordDoc);
                        titleHashMap.put(word, dicWord);
                    }
                }
            }


            str = i.getBody();
            str = str.replace("/", " ");
            str = str.replace(".", " ");
            str = str.replace("،", " ");
            str = str.replace("(", " ");
            str = str.replace("»", " ");
            str = str.replace("«", " ");
            str = str.replace(",", " ");
            str = str.replace("[", " ");
            str = str.replace("]", " ");
            str = str.replace("\"", " ");
            str = str.replace("\\", " ");
            str = str.replace(")", " ");
            str = str.replace(";", " ");
            str = str.replace(":", " ");
            str = str.replace("؛", " ");
            str = str.replace("–", " ");
            str = str.replace("؟", " ");
            str = str.replace("-", " ");
            str = str.replace("@", " ");
            str = str.replace("_", " ");
            str = str.replace("?", " ");
            str = str.replace("!", " ");
            str = str.replace("+", " ");
            str = str.replace("·", " ");
            str = str.replaceAll("[0-9]", "");

            words = str.split(" ");
            for (String word : words) {
                word = word.replace(" ", "");
                if (!word.equals(" ") && !word.equals("")) {
                    if (wordHashMap.containsKey(word)) {
                        dicWord = wordHashMap.get(word);
                        CodedDoc wordDoc = dicWord.getDocs().get(dicWord.getDocs().size() - 1);
                        if (wordDoc.getId() == id) {
                            wordDoc.setTermFreq(wordDoc.getTermFreq() + 1);
                        } else {

                            wordDoc = new CodedDoc(i.getId());//, i.getUrl());
                            dicWord.getDocs().add(wordDoc);
                            dicWord.setDocNum(dicWord.getDocNum() + 1);

                        }

                        wordHashMap.replace(word, dicWord);
                    } else {
//                        if (!titleHashMap.containsKey(word))
//                            wordList.add(word);
                        dicWord = new Word(word, len);
                        CodedDoc wordDoc = new CodedDoc(i.getId());//, i.getUrl());
                        dicWord.getDocs().add(wordDoc);
                        wordHashMap.put(word, dicWord);
                    }
                }
            }
        }
        Gson gson = new Gson();
        Result result=new Result();
        result.setWordHashMap(wordHashMap);
        result.setDocsHashMap(docsHashMap);
        result.setTitleHashMap(titleHashMap);
        String json=gson.toJson(result);
//        System.gc();
        JsonConverter.getInstance().jsonToFile("result", json);
//        System.gc();
//        JsonConverter.getInstance().jsonToFile("wordDic", wordDic);
//        System.gc();
//        JsonConverter.getInstance().jsonToFile("hashedDoc", hashedDoc);
//        String wholeDic = gson.toJson(wordList.toArray(new String[wordList.size()]));
//        JsonConverter.getInstance().jsonToFileDic(wholeDic);
    }
}