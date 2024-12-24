package testPackage;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class searchByPOstOffice {
	WebDriver driver = null;
  @Test
  public void searchByPostOffc() {
	  driver.get("http://www.postalpincode.in/Search-By-Location");
	  //header Search by post office click,redirected to the corresponding page
	  driver.findElement(By.linkText("Search By Post Office")).click();
	  
	  //searching for a postoffice using its name
	  driver.findElement(By.id("ContentPlaceHolder1_txtPostOfficeName")).sendKeys("Aluva");
	  
	  //enter key press
	  driver.findElement(By.id("ContentPlaceHolder1_txtPostOfficeName")).sendKeys(Keys.ENTER);
	  
  }
  @BeforeTest
  @Parameters("browser")
  public void setUp(String browser) {
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();
	  }
	  else if(browser.equalsIgnoreCase("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
	  }
  }

  @AfterTest
  public void afterTest() {
  }

}
