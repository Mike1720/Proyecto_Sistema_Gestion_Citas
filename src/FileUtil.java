import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    public static void saveData(String file, String line) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(line + "\n");
        } catch (IOException e) {
            System.out.println("Error guardando archivo.");
        }
    }
}