package com.mtm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ReadConfig {

	public static Properties properties;
	String path = "src/test/resources/config.properties";
	String rtpValue = null;
	//constructor
	public ReadConfig()  {
		try {
			properties = new Properties();

			//to open config .properties file in input mode and load the file
			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}


	}
	public String getBrowser() {
		String browser = null;

		try {
			browser = properties.getProperty("browser");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return browser;
	}
	
	public String getUrl() {
		String url = null;

		try {
			url = properties.getProperty("url");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return url;
	}
}