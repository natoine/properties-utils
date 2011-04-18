package fr.natoine.properties.test;

import java.util.Properties;

import fr.natoine.properties.PropertiesUtils;
import junit.framework.TestCase;

public class PropertiesTest  extends TestCase 
{
	public PropertiesTest(String name) 
	{		    
		super(name);
	}

	public void testLoadDefault()
	{
	//File _test = new File("/src/test/resources/test");
	//System.out.println(_test.getAbsolutePath());
		PropertiesUtils.loadDefault("src/test/resources/defaultprop");
	}
	
	public void testLoadLastState()
	{
		Properties applicationProps = new Properties();
		PropertiesUtils.loadLastState(applicationProps, "src/test/resources/lastprop");
	}
	
	public void testStore()
	{
		Properties applicationProps = new Properties();
		PropertiesUtils.store(applicationProps, "src/test/resources/lastprop", "testStore");
	}
}
