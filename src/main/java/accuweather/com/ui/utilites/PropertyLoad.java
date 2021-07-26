package accuweather.com.ui.utilites;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoad {


    private static  String filePath=".//src//main//resources//env.properties";
    private static FileReader fileReader;

    private static Properties properties=new Properties();

    static {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties localProperties) {
         properties = localProperties;
    }

}
