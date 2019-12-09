import java.io.FileWriter;
import java.io.IOException;

public class JsonConverter {
    private static JsonConverter instance;

    public static JsonConverter getInstance() {
        if (instance == null)
            instance = new JsonConverter();
        return instance;
    }

    private JsonConverter() {
    }

    public void jsonToFile(String fileName, String json) {
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".json");
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void jsonToFileDic(String json) {
        try {
            FileWriter fileWriter = new FileWriter("wholeWords.json");
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}