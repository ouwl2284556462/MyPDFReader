import java.io.*;
import java.util.stream.Collectors;

public class FileUtil {

    public static String getTextFromFile(String filePath) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"))){
           return reader.lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveTextToFile(String filePath, String text){
        File file = new File(filePath);
        if(!file.exists()){
            file.getParentFile().mkdirs();
        }

        try(PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))){
            writer.write(text);
            writer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
