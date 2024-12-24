package testPackage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class searchByPincode {
	
	WebDriver driver = null;
	@BeforeTest
	@Parameters("browser")
	  public void setUp(String browser) {
		System.out.print("inside"+browser);
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
	
  @Test
  public void searchByPicode() {
	  driver.get("http://www.postalpincode.in/Search-By-PIN-Code");
	driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtPINCode")).sendKeys("683513");
	driver.findElement(By.id("ContentPlaceHolder1_btnSearch")).click();
	
	//reset the pincode textbox value
	
	driver.findElement(By.id("ContentPlaceHolder1_btnCancel")).click();
	 
  }
  

  @AfterTest
  public void afterTest() {
	  driver.close();
	  
  }

}
