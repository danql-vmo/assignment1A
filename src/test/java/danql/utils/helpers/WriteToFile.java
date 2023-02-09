package danql.utils.helpers;

import java.io.*;

public class WriteToFile {
    public static void writeToFile(String filePath, String data, boolean isAppending) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, isAppending);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
