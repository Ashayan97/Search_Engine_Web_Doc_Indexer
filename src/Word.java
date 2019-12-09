import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<CodedDoc> docs;
    private double idf;
    private int docLen;
    private int docNum=1;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getDocNum() {
        return docNum;
    }

    public void setDocNum(int docNum) {
        this.docNum = docNum;
        this.idf=Math.log((this.docLen/this.docNum));
    }


    public ArrayList<CodedDoc> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<CodedDoc> docs) {
        this.docs = docs;
    }

    public Word(String word,int docLen){
        this.word=word;
        this.docs=new ArrayList<>();
        this.docLen=docLen;
        this.idf=Math.log((docLen/this.docNum));
    }
}
