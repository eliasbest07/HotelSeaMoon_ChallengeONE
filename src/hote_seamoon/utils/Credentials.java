package hote_seamoon.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Credentials {

    private String driver, url, username, password, managerpassword;

    public Credentials() {
    	 obtenerCofiguracion();
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getManagerPassword() {
        return managerpassword;
    }

    public void obtenerCofiguracion() {
        try {

            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src\\hote_seamoon\\utils\\SetData.ini");
            properties.load(fileInputStream);

            this.driver = properties.getProperty("driverName");
            this.url = properties.getProperty("url");
            this.username = properties.getProperty("username");
            this.password = properties.getProperty("password");
            this.managerpassword =  properties.getProperty("managerpassword");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
