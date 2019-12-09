import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Doc doc[] = parser.getDocs();
        DicMaker.getInstance().dicMaking(doc);
//        Result result;
//        try {
//            Gson gson=new Gson();
//            FileReader reader=new FileReader("result.json");
//            result=gson.fromJson(reader,Result.class);
//            System.out.println(result.getWordHashMap().get("تهران").getDocNum());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
