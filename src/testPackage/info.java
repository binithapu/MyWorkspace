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

public class info {
	WebDriver driver = null;
  @Test
  public void info() {
	  driver.get("http://www.postalpincode.in/Info");
	  
	  driver.findElement(By.xpath("//*[@id='centercolumn']/section/div/label")).click();
  }
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
	//  String browser = "chrome";
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
