package cl.vk.api.wow.service.utils;

import cl.vk.api.wow.configuration.input.InputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class SOAPUtils {

    Logger logger = LoggerFactory.getLogger(SOAPUtils.class);
    public String sendMessage(String command){
        return executeCommand(command);
    }
    private String executeCommand(String command){

        try{
            logger.info("URL {}", InputData.getProtocol()+"://"+InputData.getIp()+":"+InputData.getPort());
            URL endpoint = new URL(InputData.getProtocol()+"://"+InputData.getIp()+":"+InputData.getPort());
            SOAPConnectionFactory soapConnection = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnection.createConnection();
            SOAPMessage response = connection.call(generateMessage(command), endpoint);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            response.writeTo(out);
            return out.toString();
        } catch (MalformedURLException e) {
            logger.error("Malformed Url ", e.getMessage());
        } catch (SOAPException e) {
            logger.error("SOAP Error ", e.getMessage());
        } catch (IOException e) {
            logger.error("IOException ", e.getMessage());
        }
        return null;
    }

    private SOAPMessage generateMessage(String command){
        try{
            InputStream is = new ByteArrayInputStream(InputData.getSoap().replaceAll("comando", command).getBytes());
            SOAPMessage message = MessageFactory.newInstance().createMessage(null, is);
            MimeHeaders headers = message.getMimeHeaders();
            headers.addHeader("Authorization", "Basic " + base64Authorization());
            message.saveChanges();
            return message;
        } catch (SOAPException e) {
            logger.error("SOAP Error ", e.getMessage());
        } catch (IOException e) {
            logger.error("IOException ", e.getMessage());
        }
        return null;
    }

    protected String base64Authorization(){
        String userPass = String.format("%s:%s", InputData.getUsername_gm(),InputData.getPassword_gm());
        logger.info("Authorization {}", userPass);
        String basicAuth = Base64.getEncoder().encodeToString(userPass.getBytes());
        return basicAuth;
    }



}
