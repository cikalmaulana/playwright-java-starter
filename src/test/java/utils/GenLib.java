package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class GenLib {

    private static final Logger log = Logger.getLogger(GenLib.class);

    private String systemDir = System.getProperty("user.dir");

    public Properties getPropertiesFromFile(String properties_filename) throws IOException{
        Properties prop = loadPropertiesFromFile(properties_filename);
        readjustWithSystemProperties(prop);
        return prop;
    }

    public Properties loadPropertiesFromFile(String properties_filename) throws IOException{
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(systemDir + "\\src\\test\\resources\\properties\\" + properties_filename);
            prop.load(fis);
        } catch (FileNotFoundException e){
            throw new FileNotFoundException("Property file '" + properties_filename + "' not found in the classpath");
        }
        return prop;
    }

    public void readjustWithSystemProperties(Properties prop){
        for (Object propKey : prop.keySet()){
            String key = String.valueOf(propKey);
            if(StringUtils.isNotEmpty(System.getProperty(key))){
                prop.setProperty(key, System.getProperty(key));
            }
        }
    }
}
