package onlinescheme;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OnlineScheme {
	WebDriver driver;
	String url="http://172.20.5.18/userroopesh/Online/Online_caller/prizescheme.php3?lotcode=";
	String whichstate = "Goa";
	String expectedGovtName = "Govt. of Goa";
	String expectedGameNameScheme = "ONLINE WEEKLY LOTTERY SCHEME";
	String expectedDrawDateStarted = ": 18.06.2018 and onwards";
	String expecteddrawNumber =": 1 onwards";
	String expectedTicketPrize =": Rs. 3/- per ticket";
	String expectedfrequencyOfDraw =": 7 Days A Week";
	String expectednumberRange = ": 0000000 - 9999999";
	String expectedDrawToBeConducted = ": At the Directorate of Small Savings & Lotteries, Serra Building Next to All India Radio, Altinho, Panaji, Goa-403001";
	String expectedDrawConductedBy = ": Directorate of Small Saving & State Lotteries, Govt. of Goa";
	String expectedContactDetails = "Contact details: contact@sugaldamani.com";
	SoftAssert sa = new SoftAssert();
	
//	Scanner sc = new Scanner(System.in);
	@BeforeSuite(alwaysRun=true)
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/sumitkumar/workspace/DataCompare/plugin/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		String lotcode="";
		if(whichstate.equalsIgnoreCase("Mizoram")) {
			lotcode = "M";
		}else if(whichstate.equalsIgnoreCase("Goa")) {
			lotcode = "L";
		}else if(whichstate.equalsIgnoreCase("Arunachal")) {
			lotcode = "Q";
		}
		driver.navigate().to(url+lotcode+"500");
	}
  @Test(priority=1)
  public void checkGovtName() {
//	  System.out.println("Enter the Govt. Name to be check");
//	  expectedGovtName = sc.nextLine();
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
	  String expecteddrawDateText = "Date of Draw";
	  String actualdrawDateText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > b:nth-child(1)")).getText();
	  sa.assertEquals(actualdrawDateText, expecteddrawDateText);
	  String actualDrawDateStarted = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)")).getText();
	  sa.assertEquals(actualDrawDateStarted, expectedDrawDateStarted);
	  sa.assertAll();
  }
  @Test(priority=4)
  public void drawNo() {
	  String expecteddrawNumberText = "Draw No.";
	  String actualdrawNumberText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualdrawNumberText, expecteddrawNumberText);
	  String actualdrawNumber = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)")).getText();
	  sa.assertEquals(actualdrawNumber, expecteddrawNumber);
	  sa.assertAll();
  }
  @Test(priority=5)
  public void ticketPrize() {
	  String expectedTicketPrizeText ="Ticket Price";
	  String actualTicketPrizeText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualTicketPrizeText,expectedTicketPrizeText ,"ticket prize text not written ");
	  String actualTicketPrize = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)")).getText();
	  sa.assertEquals(actualTicketPrize,expectedTicketPrize,"ticket prize may be wroung");
	  sa.assertAll();
  }
  @Test(priority=6) 
  public void numberRange() {
	  String expectednumberRangeText = "Number Range";
	  String actualnumberRangeText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualnumberRangeText, expectednumberRangeText,"Number Range Text Wrong");
	  
	  String actualnumberRange = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)")).getText();
	  sa.assertEquals(actualnumberRange, expectednumberRange,"Number Range Wroung");
	  sa.assertAll();
  }
  @Test(priority=7)
  public void frequencyOfDraw() {
	  String expectedfrequencyOfDrawText ="Frequency of Draw";
	  String actualfrequencyOfDrawText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualfrequencyOfDrawText, expectedfrequencyOfDrawText ,"frequency of text may be wrong");
	 
	  String actualfrequencyOfDraw = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2)")).getText();
	  sa.assertEquals(actualfrequencyOfDraw, expectedfrequencyOfDraw ,"frequency of draw be wrong");
	  sa.assertAll();
  }
  @Test(priority=8)
  public void drawToBeConducted() {
	  String expectedDrawToBeConductedText = "Draw To Be Conducted";
	  String actualDrawToBeConductedText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(1) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualDrawToBeConductedText, expectedDrawToBeConductedText,"Draw To Be Conducted Text is wrong");
	  
	  String actualDrawToBeConducted = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(2) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualDrawToBeConducted, expectedDrawToBeConducted,"Draw To Be Conducted is wrong");
	  sa.assertAll();
  }
  @Test(priority=9)
  public void drawConductedBy() {
	  String expectedDrawConductedByText = "Draws Conducted By";
	  String actualDrawConductedByText = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(7) > td:nth-child(1) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualDrawConductedByText, expectedDrawConductedByText,"Draw Conducted Text is wrong");
	  
	  String actualDrawConductedBy = driver.findElement(By.cssSelector("body > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(7) > td:nth-child(2) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualDrawConductedBy, expectedDrawConductedBy,"Draw Conducted is wrong");
	  sa.assertAll();
  }
  @Test(priority=10)
  public void contactDetails() {
	  String actualContactDetails = driver.findElement(By.cssSelector("body > b:nth-child(7) > center:nth-child(1) > b:nth-child(1)")).getText();
	  sa.assertEquals(actualContactDetails, expectedContactDetails," contails may be incorrect");
	  sa.assertAll();
  }
  @Test(priority=11)
  public void playAndDrawInstruction() {
	  String expectedplayAndDrawInstruction ="Play and Draw Instructions:";
	  String actualplayAndDrawInstruction = driver.findElement(By.xpath("body > b:nth-child(7) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > font:nth-child(1)")).getText();
	  sa.assertEquals(actualplayAndDrawInstruction, expectedplayAndDrawInstruction, " play draw instruction text is incorrect");
	  
	  sa.assertAll();
  }
  
}
