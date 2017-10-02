package workshop2.grade2.io;

import java.io.File;
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
	
	private File file = new File("src/main/java/workshop2/grade2/io/data.xml");
	
	public Register readXML() throws Exception {
		JAXBContext context = JAXBContext.newInstance(Register.class);
		Unmarshaller un = context.createUnmarshaller();
		return (Register) un.unmarshal(file);
	}

	public void writeXML(Register register) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Register.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(register, file);
	}
}