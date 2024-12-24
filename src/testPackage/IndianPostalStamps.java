package testPackage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class IndianPostalStamps {
	WebDriver driver = null;
  @Test
  public void getStampsByYear() {
	  driver.get("http://www.postalpincode.in/Search-By-Location");
	  //header Search by post office click,redirected to the corresponding page
	  driver.findElement(By.linkText("Indian Postal Stamps")).click();
	  
	  
	  //year selection
	  WebElement yearDropdown = driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlDOI']"));
	  Select yearSelect =new Select(yearDropdown);
	  yearSelect.selectByVisibleText("1982");
		
		
	  
	//*[@id="ContentPlaceHolder1_ddlDOI"]
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
