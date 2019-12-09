public class CodedDoc {
    private int id;
    private int termFreq = 1;
    private double tf;

    public CodedDoc(int id){
        this.id = id;
        this.tf = Math.log((double) (termFreq));
    }

    public int getTermFreq() {
        return termFreq;
    }

    public double getTf() {
        return tf;
    }

    public void setTf(double tf) {
        this.tf = tf;
    }

    public void setTermFreq(int termFreq) {
        this.termFreq = termFreq;
        this.tf = Math.log((double) (termFreq));

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
