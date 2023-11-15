package cl.vk.api.wow.configuration;

import cl.vk.api.wow.configuration.input.InputData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class Configuration
{
    final String CONFIG_FILE = "apiConfiguration.properties";
    static Properties properties;
    public Configuration(){
        loadProperties();
    }

    protected void loadProperties(){
        try (InputStream is = new FileInputStream("./"+CONFIG_FILE)){
            properties= new Properties();
            properties.load(is);
            InputData.setIp( properties.getProperty("api.ip"));
            InputData.setPort( properties.getProperty("api.port"));
            InputData.setProtocol( properties.getProperty("api.protocol"));
            InputData.setUsername_gm( properties.getProperty("api.usergm"));
            InputData.setPassword_gm( properties.getProperty("api.passgm"));
            InputData.setSoap(properties.getProperty("api.soap"));
        } catch (IOException e) {
            log.error("IOException, the file doesn't exist. Create de file apiConfiguration.properties");
        }
    }
}
