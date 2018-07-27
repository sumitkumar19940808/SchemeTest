package onlinescheme;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LuckyPlusScheme {
	WebDriver driver;
	String url="http://172.20.5.18/userroopesh/Online/OnlineSeries/prizescheme.php3?lotcode=M500";
	String expectedGovtName = "GOVERNMENT OF SIKKIM";
	String expectedGameNameScheme = "LUCKY  FOUR WEEKLY LOTTERY ";
	String expectedDrawDateStarted = ":30.07.2018 (Monday) and onwards";
	String expecteddrawNumber =":1 and onwards";
	String expectedTicketPrize =":Rs.3/- per Ticket / Selection";
	String expectedfrequencyOfDraw =": Weekly";
	String expectednumberRange = ": 1000 - 2999";
	String expectedDrawToBeConducted = ": At the Directorate of State Lotteries, Gangtok (Sikkim)";
	String expectedDrawConductedBy = ": Directorate of State Lotteries, Govt. of Sikkim";
	String expectedContactDetails = "Contact details: contact@sugaldamani.com";
	@BeforeSuite(alwaysRun=true)
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/sumitkumar/workspace/DataCompare/plugin/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		String lotcode="";
//		if(whichstate.equalsIgnoreCase("Mizoram")) {
//			lotcode = "M";
//		}else if(whichstate.equalsIgnoreCase("Goa")) {
//			lotcode = "L";
//		}else if(whichstate.equalsIgnoreCase("Arunachal")) {
//			lotcode = "Q";
//		}
		driver.navigate().to(url);
	}
	@Test(priority=1)
	  public void checkGovtName() {
//		  System.out.println("Enter the Govt. Name to be check");
//		  expectedGovtName = sc.nextLine();
		  String actualGovtName = driver.findElement(By.cssSelector("body > center:nth-child(1) > font:nth-child(1) > b:nth-child(1)")).getText();
		  System.out.println(actualGovtName);
		  Assert.assertEquals(actualGovtName, expectedGovtName);
	  }
	  @Test(priority=2)
	  public void checkGameNameScheme() {
		  	String actualGameNameScheme = driver.findElement(By.cssSelector("body > center:nth-child(3) > font:nth-child(1) > b:nth-child(1)")).getText();
		  	Assert.assertEquals(actualGameNameScheme, expectedGameNameScheme);
	  }
	  @Test(priority=3)
	  public void dateOfDrawStarted() {
		  SoftAssert sa = new SoftAssert();
		  String expecteddrawDateText = "Date of Draw";
		  String actualdrawDateText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > b:nth-child(1)")).getText();
		  sa.assertEquals(actualdrawDateText, expecteddrawDateText);
		  String actualDrawDateStarted = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)")).getText();
		  sa.assertEquals(actualDrawDateStarted, expectedDrawDateStarted);
		  sa.assertAll();
	  }
	  @Test(priority=4)
	  public void drawNo() {
		  SoftAssert sa = new SoftAssert();
		  String expecteddrawNumberText = "Draw No.";
		  String actualdrawNumberText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualdrawNumberText, expecteddrawNumberText);
		  String actualdrawNumber = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)")).getText();
		  sa.assertEquals(actualdrawNumber, expecteddrawNumber);
		  sa.assertAll();
	  }
	  @Test(priority=5)
	  public void ticketPrize() {
		  SoftAssert sa = new SoftAssert();
		  String expectedTicketPrizeText ="Ticket Price";
		  String actualTicketPrizeText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualTicketPrizeText,expectedTicketPrizeText ,"ticket prize text not written ");
		  String actualTicketPrize = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)")).getText();
		  sa.assertEquals(actualTicketPrize,expectedTicketPrize,"ticket prize may be wroung");
		  sa.assertAll();
	  }
	  @Test(priority=6) 
	  public void numberRange() {
		  SoftAssert sa = new SoftAssert();
		  String expectednumberRangeText = "Number Range";
		  String actualnumberRangeText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualnumberRangeText, expectednumberRangeText,"Number Range Text Wrong");
		  
		  String actualnumberRange = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)")).getText();
		  sa.assertEquals(actualnumberRange, expectednumberRange,"Number Range Wroung");
		  sa.assertAll();
	  }
	  @Test(priority=7)
	  public void frequencyOfDraw() {
		  SoftAssert sa = new SoftAssert();
		  String expectedfrequencyOfDrawText ="Frequency of Draw";
		  String actualfrequencyOfDrawText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualfrequencyOfDrawText, expectedfrequencyOfDrawText ,"frequency of text may be wrong");
		 
		  String actualfrequencyOfDraw = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2)")).getText();
		  sa.assertEquals(actualfrequencyOfDraw, expectedfrequencyOfDraw ,"frequency of draw be wrong");
		  sa.assertAll();
	  }
	  @Test(priority=8)
	  public void drawToBeConducted() {
		  SoftAssert sa = new SoftAssert();
		  String expectedDrawToBeConductedText = "Draw To Be Conducted";
		  String actualDrawToBeConductedText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(7) > td:nth-child(1) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualDrawToBeConductedText, expectedDrawToBeConductedText,"Draw To Be Conducted Text is wrong");
		  
		  String actualDrawToBeConducted = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(2) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualDrawToBeConducted, expectedDrawToBeConducted,"Draw To Be Conducted is wrong");
		  sa.assertAll();
	  }
	  @Test(priority=9)
	  public void drawConductedBy() {
		  SoftAssert sa = new SoftAssert();
		  String expectedDrawConductedByText = "Draws Conducted By";
		  String actualDrawConductedByText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(7) > td:nth-child(1) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualDrawConductedByText, expectedDrawConductedByText,"Draw Conducted Text is wrong");
		  
		  String actualDrawConductedBy = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(7) > td:nth-child(2) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualDrawConductedBy, expectedDrawConductedBy,"Draw Conducted is wrong");
		  sa.assertAll();
	  }
	  @Test(priority=10)
	  public void contactDetails() {
		  SoftAssert sa = new SoftAssert();
		  String actualContactDetails = driver.findElement(By.cssSelector("body > b:nth-child(7) > center:nth-child(1)")).getText();
		  sa.assertEquals(actualContactDetails, expectedContactDetails," contails may be incorrect");
		  sa.assertAll();
	  }
	  @Test(priority=11)
	  public void playAndDrawInstruction() {
		  SoftAssert sa = new SoftAssert();
		  String expectedplayAndDrawInstruction ="Play and Draw Instructions:";
		  String actualplayAndDrawInstruction = driver.findElement(By.cssSelector("body > b:nth-child(7) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > font:nth-child(1)")).getText();
		  sa.assertEquals(actualplayAndDrawInstruction, expectedplayAndDrawInstruction, " play draw instruction text is incorrect");
		  sa.assertAll();
	  }
	  @Test(priority=12)
	  public void chechSteps1() {
		SoftAssert sa = new SoftAssert();
	  	String expected="The buyer has a wide range to choose numbers from 1000 - 2999 and a series from 00-99 / A, B, C, D, E, G, H, J, K, L      E.G.:  39C 1214.";
	  	String actual = driver.findElement(By.cssSelector("body > b:nth-child(7) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > font:nth-child(1)")).getText();
	  	sa.assertEquals(actual, expected);
	  }
	  @Test(priority=13)
	  public void chechSteps2() {
		SoftAssert sa = new SoftAssert();
	  	String expected="For first prize, one number of 4 digits from 1000 - 2999 and a series from 00-99/ A, B, C, D, E, G, H, J, K, L shall be drawn (e.g. 48B 1013).  The player who matches all his selected numbers with series with the drawn number in same sequence will be eligible for first prize.";
	  	String actual = driver.findElement(By.cssSelector("body > b:nth-child(7) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > font:nth-child(1)")).getText();
	  	sa.assertEquals(actual, expected);
	  }
	  @Test(priority=14)
	  public void chechSteps3() {
		SoftAssert sa = new SoftAssert();
	  	String expected="For 2nd prize, one number of 4 digits from 1000 - 2999 and a series from 00-99/ A, B, C, D, E, G, H, J, K, L shall be drawn (e.g. 17B 1013).  The player who matches all his selected numbers with series with the drawn number in same sequence will be eligible for 2nd prize.";
	  	String actual = driver.findElement(By.cssSelector("body > b:nth-child(7) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > font:nth-child(1)")).getText();
	  	sa.assertEquals(actual, expected);
	  }
	  @Test(priority=15)
	  public void chechSteps4() {
		SoftAssert sa = new SoftAssert();
	  	String expected="For 3rd prize, 20 individual numbers of 4 digits from 1000 - 2999 shall be drawn, applicable to all series.  The player, who matches all his selected 4 digits number with the drawn number, in same sequence, will be eligible for 3rd prize.";
	  	String actual = driver.findElement(By.cssSelector("body > b:nth-child(7) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2) > font:nth-child(1)")).getText();
	  	sa.assertEquals(actual, expected);
	  }
//	  @Test(priority=16)
//	  public void chechSteps5() {
//	  	String expected="One selection will be eligible for one prize only whichever is higher.";
//	  	String actual = driver.findElement(By.cssSelector("body > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(2) > font:nth-child(1)")).getText();
//	  	sa.assertEquals(actual, expected);
//	  }
	  @Test(priority=17)
	  public void checkPrizeStructure() {
		  SoftAssert sa = new SoftAssert();
		  String expectedPrizeStructureResultText ="PRIZE STRUCTURE";
		  String actualPrizeStructureResultText = driver.findElement(By.cssSelector("body > b:nth-child(7) > center:nth-child(7)")).getText();
		  sa.assertEquals(actualPrizeStructureResultText, expectedPrizeStructureResultText," Prize Structure may be wrong");
		  sa.assertAll();
	  }
	  @Test(priority=18)
	  public void checkPrizeAmountTable() {
		  SoftAssert sa = new SoftAssert();
		  WebElement tableElement = driver.findElement(By.xpath("/html/body/b[2]/table[2]"));
		// create empty table object and iterate through all rows of the found table element
		  ArrayList<HashMap<String, WebElement>> userTable = new ArrayList<HashMap<String, WebElement>>();
		  ArrayList<WebElement> rowElements = (ArrayList<WebElement>) tableElement.findElements(By.xpath(".//tr"));

		  // get column names of table from table headers
		  ArrayList<String> columnNames = new ArrayList<String>();
		  ArrayList<WebElement> headerElements = (ArrayList<WebElement>) rowElements.get(0).findElements(By.xpath("/html/body/b[2]/table[2]/tbody/tr[3]"));
		  for (WebElement headerElement: headerElements) {
		    columnNames.add(headerElement.getText());
		    System.out.println(columnNames);
		  }

		  // iterate through all rows and add their content to table array
		  for (WebElement rowElement: rowElements) {
		    HashMap<String, WebElement> row = new HashMap<String, WebElement>();
		    
		    // add table cells to current row
		    int columnIndex = 0;
		    ArrayList<WebElement> cellElements = (ArrayList<WebElement>) rowElement.findElements(By.xpath(".//td"));
		    for (WebElement cellElement: cellElements) {
		      row.put(columnNames.get(columnIndex), cellElement);
		      columnIndex++;
		    }
//		    /html/body/b[2]/table[2]/tbody/tr[4]/td[1]
//		    		/html/body/b[2]/table[2]/tbody/tr[4]/td[2]
//		    				/html/body/b[2]/table[2]/tbody/tr[5]/td[1]
//		    						/html/body/b[2]/table[2]/tbody/tr[5]/td[2]
		    userTable.add(row);
		  }

		  // finally fetch the desired data
		  WebElement cellInSecondRowFourthColumn = userTable.get(0).get("1 / 10000000");
		  System.out.println(cellInSecondRowFourthColumn);
		  
	  }
	  
}
