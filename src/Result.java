import java.util.HashMap;

public class Result {
    public HashMap<String, Word> getWordHashMap() {
        return wordHashMap;
    }

    public void setWordHashMap(HashMap<String, Word> wordHashMap) {
        this.wordHashMap = wordHashMap;
    }

    public HashMap<String, Word> getTitleHashMap() {
        return titleHashMap;
    }

    public void setTitleHashMap(HashMap<String, Word> titleHashMap) {
        this.titleHashMap = titleHashMap;
    }

    public HashMap<Integer, Doc> getDocsHashMap() {
        return docsHashMap;
    }

    public void setDocsHashMap(HashMap<Integer, Doc> docsHashMap) {
        this.docsHashMap = docsHashMap;
    }

    private HashMap<String, Word> wordHashMap;
    private HashMap<String, Word> titleHashMap;
    private HashMap<Integer, Doc> docsHashMap;
}
