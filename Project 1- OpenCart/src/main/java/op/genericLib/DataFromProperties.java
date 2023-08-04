package op.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFromProperties {
	
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\91740\\OneDrive\\Desktop\\Projects\\OpenCart\\Commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}

}
