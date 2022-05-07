package globalEnvironments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValues {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        FileInputStream fileInputStream =
                new FileInputStream("C:\\Users\\anicolle\\eclipse-workspace\\introduction\\src\\main\\java\\globalEnvironments\\data.properties");
        properties.load(fileInputStream);
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("url"));
        properties.setProperty("browser","firefox");
        System.out.println(properties.getProperty("browser"));
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\anicolle\\eclipse-workspace\\introduction\\src\\main\\java\\globalEnvironments\\data.properties");
        properties.store(fileOutputStream, null);

    }
}
