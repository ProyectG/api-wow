package cl.vk.api.wow.configuration.input;


public class InputData {
    public static String ip;
    public static String port;
    public static String protocol;
    public static String username_gm;
    public static String password_gm;
    public static String soap;

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        InputData.ip = ip;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        InputData.port = port;
    }

    public static String getProtocol() {
        return protocol;
    }

    public static void setProtocol(String protocol) {
        InputData.protocol = protocol;
    }

    public static String getUsername_gm() {
        return username_gm;
    }

    public static void setUsername_gm(String username_gm) {
        InputData.username_gm = username_gm;
    }

    public static String getPassword_gm() {
        return password_gm;
    }

    public static void setPassword_gm(String password_gm) {
        InputData.password_gm = password_gm;
    }

    public static String getSoap() {
        return soap;
    }

    public static void setSoap(String soap) {
        InputData.soap = soap;
    }



}
