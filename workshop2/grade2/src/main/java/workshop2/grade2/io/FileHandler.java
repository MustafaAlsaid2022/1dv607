package workshop2.grade2.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import workshop2.grade2.model.Register;

/**
 * @author Mustafa Alsaid
 * @version 0.00.00
 * @name FileHandler.java
 */

public class FileHandler {
	
	private static final String CONFIG_PATH = System.getProperty("user.home") + "/Documents/Timeline Manager/config.properties";
	private File configFile;
	private Properties configProperties;
	
	public FileHandler() {
		configFile = new File(CONFIG_PATH);
		configProperties = new Properties();
		
		if (!configFile.getParentFile().exists()) {
			configFile.getParentFile().mkdirs();
		}
	}
	
	
	public Register readXML(File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Register.class);
		Unmarshaller un = context.createUnmarshaller();
		return (Register) un.unmarshal(file);
	}

	
	public void writeXML(Register member, File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Member.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(member, file);
	}
	
	public void writeProperty(String key, String value) throws IOException {
		try (FileOutputStream out = new FileOutputStream(configFile)) {
			configProperties.setProperty(key, value);
			configProperties.store(out, null);
		}
	}
	
	public String readProperty(String key, String defaultVal) throws IOException {
		
		try (InputStream in = new FileInputStream(configFile)) {
			configProperties.load(in);
		}
		
		return configProperties.getProperty(key, defaultVal);
	}
	
	
	

}
