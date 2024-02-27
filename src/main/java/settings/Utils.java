package settings;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static String getData(String file, String key) {
        String path = "src/main/java/settings/" + file;
        String absolutePath = new File(path).getAbsolutePath();
        String jsonContent = readFile(absolutePath);

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);

        System.out.println(jsonObject.get(key));

        return jsonObject.get(key).getAsString();
    }

    private static String readFile(String filePath){
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static void print(String string) {
        System.out.println(string);
    }

}
