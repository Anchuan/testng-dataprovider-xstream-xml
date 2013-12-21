package qa.dataprovider;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import qa.dataprovider.def.ArgObject;
import qa.dataprovider.def.TestArguments;
import qa.dataprovider.def.TestRow;

public class ParametersTest {
	
	private static String testData = "data-provider.xml";

	@Test(dataProvider = "testdata")
	public void printHorizontal( TestArguments testArgs ) {
		System.out.println("\n----------------\nPrint horizontal test:\n----------------");
		
		System.out.println( testArgs.toString() );
		
		System.out.println("----------------\nFinished printHorizontal test.\n");
		Assert.assertTrue( true );
	}

	@Test(dataProvider = "testdata")
	public void printVertical( TestArguments testArgs ) {
		System.out.println("\n----------------\nPrint vertical test:\n----------------");
		
		for ( ArgObject x: testArgs.getAllTestArguments() ) {
			System.out.println( x.getKey() + "[" + x.getType() + "]: " + x.getVal() );
		}
		
		System.out.println("----------------\nFinished printVertical test.\n");
	}
	
	@Test
	public void testSuiteFile() {
		System.out.println("\n----------------\nRunning testSuiteFile\n----------------");
		
		XMLDataHelper helper = new XMLDataHelper();
		
		TestArguments tArgs3 = new TestArguments("true", "Test 3", "portal3", "Grid", "Firefox");
	    tArgs3.setTestArgument("url", "java.lang.String", "http://google.com");
	    TestRow tCase3 = new TestRow( tArgs3 );
	    
	    TestArguments tArgs4 = new TestArguments("true", "Test 4", "portal4", "Grid", "Firefox");
	    tArgs4.setTestArgument("url", "java.lang.String", "http://etsy.com");
	    TestRow tCase4 = new TestRow( tArgs4 );
	    
	    TestRow[] trs = new TestRow[2];
	    trs[0] = tCase3;
	    trs[1] = tCase4;
	    File out = new File("test.xml");
		helper.createSuiteFile( out, "Suite 2", "http://google.com", tCase3, tCase4 );
		
		helper = new XMLDataHelper( out.getAbsolutePath() );
		
		 
		System.out.println("----------------\nFinished testSuiteFile()\n");
	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() {
		System.out.println("Calling TestNG data provider method.");
		XMLDataHelper dp = new XMLDataHelper( testData );
		return dp.getArgumentsArrays();
	}

}
