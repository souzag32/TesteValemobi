package com.testevalemobi.util;

import java.io.IOException;
import java.io.InputStream;

public class Properties {

	private static java.util.Properties props;
	private InputStream in = getClass().getClassLoader().getResourceAsStream("cpfcnpj.properties");

	public Properties(){
		props = new java.util.Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String key){
		return props.getProperty(key);
	}
}
