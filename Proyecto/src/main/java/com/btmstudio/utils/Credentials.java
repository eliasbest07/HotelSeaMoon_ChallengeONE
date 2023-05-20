package com.btmstudio.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class Credentials {

    private String driver, url, username, password, managerpassword;

    public Credentials() {
    	try {
    	 obtenerCofiguracion();
    	}catch (Exception e) {
    		 System.out.println("Credentials File ERROR: " + e);
			// TODO: handle exception
		}
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

    public void obtenerCofiguracion() throws Exception {
        try {

            Properties properties = new Properties();
            String jarPath = Credentials.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            String folderPath = new File(jarPath).getParent();
            String filePath = folderPath + File.separator + "SetData.ini";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            
            //FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\com\\btmstudio\\utils\\SetData.ini");
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
