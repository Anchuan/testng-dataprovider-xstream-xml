package qa.dataprovider;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.dataprovider.def.ArgObject;
import qa.dataprovider.def.TestArguments;
import qa.dataprovider.def.TestRow;
import static qa.dataprovider.XMLTransformer.generateHtmlFromInputXML;

public class ParametersTest {
	
	private static final String directory = "data";
	private static File dataFile;
	
	@BeforeClass 
	public static void setup() {
		dataFile = new File( directory );
	      if ( !new File(directory).exists() ) {
	          new File(directory).mkdir();
	      }
	}

	@Test(dataProvider = "testdata1")
	public void printHorizontal( TestArguments testArgs ) {
		System.out.println("\n----------------\nPrint horizontal test:\n----------------");
		
		System.out.println( testArgs.toString() );
		
		System.out.println("----------------\nFinished printHorizontal test.\n");
		Assert.assertTrue( true );
	}

	@Test(dataProvider = "testdata2")
	public void printVertical( TestArguments testArgs ) {
		System.out.println("\n----------------\nPrint vertical test:\n----------------");
		
		for ( ArgObject x: testArgs.getAllTestArguments() ) {
			System.out.println( x.getKey() + "[" + x.getType() + "]: " + x.getVal() );
		}
		
		System.out.println("----------------\nFinished printVertical test.\n");
	}
	
	@Test
	public void createDataTest() {
		System.out.println("\n----------------\nRunning createDataAndHtmlView... \n----------------");
		
		XMLDataHelper helper = new XMLDataHelper();
		
		TestArguments tArgs3 = new TestArguments("true", "Test 3", "portal3", "Grid", "Firefox");
	    tArgs3.setTestArgument("url", "java.lang.String", "http://google.com");
	    tArgs3.setTestArgument("earth", "java.lang.String", "Earth");
	    tArgs3.setTestArgument("air", "java.lang.String", "Air");
	    tArgs3.setTestArgument("fire", "java.lang.String", "Fire");
	    tArgs3.setTestArgument("water", "java.lang.String", "Water");
	    TestRow tCase3 = new TestRow( tArgs3 );
	    
	    TestArguments tArgs4 = new TestArguments("true", "Test 4", "portal4", "Grid", "Firefox");
	    tArgs4.setTestArgument("url", "java.lang.String", "http://etsy.com");
	    tArgs4.setTestArgument("earth", "java.lang.String", "Earth");
	    tArgs4.setTestArgument("air", "java.lang.String", "Air");
	    tArgs4.setTestArgument("fire", "java.lang.String", "Fire");
	    tArgs4.setTestArgument("water", "java.lang.String", "Water");
	    TestRow tCase4 = new TestRow( tArgs4 );
	    
	    TestArguments tArgs5 = new TestArguments("true", "Test 5", "portal5", "Grid", "Firefox");
	    tArgs5.setTestArgument("url", "java.lang.String", "http://etsy.com");
	    tArgs5.setTestArgument("earth", "java.lang.String", "Earth");
	    tArgs5.setTestArgument("air", "java.lang.String", "Air");
	    tArgs5.setTestArgument("fire", "java.lang.String", "Fire5");
	    tArgs5.setTestArgument("water", "java.lang.String", "Water");
	    TestRow tCase5 = new TestRow( tArgs5 );
	    
	    File out = new File("data/elements.xml");
		helper.createSuiteFile( out, "Suite 2", "http://google.com", tCase3, tCase4, tCase5 );
		
		helper = new XMLDataHelper( out );
		
		
		 
		System.out.println("----------------\nFinished createDataAndHtmlView... \n");
	}
	
	@AfterClass 
	public static void teardown() {
	      if ( dataFile.exists() ) {
	    	  generateHtmlFromInputXML( "elements.xml", "src/test/resources/default.xsl", "elements.html" );
	    	  generateHtmlFromInputXML( "dataProvider1.xml", "src/test/resources/default.xsl", "dataProvider1.html" );
	    	  generateHtmlFromInputXML( "dataProvider2.xml", "src/test/resources/default.xsl", "dataProvider2.html" );
	      } else {
	    	  throw new IllegalStateException("The data directory for tests is missing.");
	      }
	}

	@DataProvider(name = "testdata1")
	public Object[][] getTestData1() {
		System.out.println("Calling TestNG data provider method: testdata1");
		XMLDataHelper dp = new XMLDataHelper( new File( directory + File.separator + "dataProvider1.xml" ) );
		return dp.getArgumentsArrays();
	}
	
	@DataProvider(name = "testdata2")
	public Object[][] getTestData() {
		System.out.println("Calling TestNG data provider method: testdata2");
		XMLDataHelper dp = new XMLDataHelper( new File( directory + File.separator + "dataProvider2.xml" ) );
		return dp.getArgumentsArrays();
	}

}
