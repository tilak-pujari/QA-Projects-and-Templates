package herokuapp.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import herokuapp.dataUtilites.DataProperties;

public class TC00FetchDataTest {
	DataProperties dp=new DataProperties();
	@Test(priority=1)
	public void launch() throws IOException {
		
	System.out.println(dp.getDataFromPropertiesFile("Url"));
	System.out.println(dp.getDataFromPropertiesFile("Username"));
	System.out.println(dp.getDataFromPropertiesFile("Password"));
	
	}
}
