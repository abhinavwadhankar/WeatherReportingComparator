package accuweather.com.ui.utilites;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoad {
    private String filePath=".//src//main//resources//env.properties";
    private FileReader fileReader;

    private Properties properties=new Properties();

    public PropertyLoad() throws IOException {
        FileReader fileReader = new FileReader(filePath);
        properties.load(fileReader);

    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
