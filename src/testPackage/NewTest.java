package testPackage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver = null;
  @Test
  public void f() {
	  driver.get("http://www.postalpincode.in/Search-By-Location");
  }
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
	  
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
  }

  @AfterTest
  public void afterTest() {
	 
  }

}
