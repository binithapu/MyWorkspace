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

public class searchBylocation {
	WebDriver driver = null;
  @Test
  public void run() {
	  driver.get("http://www.postalpincode.in/Search-By-Location");
	  driver.manage().window().maximize();
	  
	  //state selection
	  
	  WebElement stateDropDown = driver.findElement(By.id("ContentPlaceHolder1_ddlState"));
	
		Select stateSelect =new Select(stateDropDown);
		stateSelect.selectByVisibleText("KERALA");
		
	//district select
		
		 WebElement distrDropDown = driver.findElement(By.id("ContentPlaceHolder1_ddlDistrict"));
		 Select distrSelect =new Select(distrDropDown);
		 distrSelect.selectByIndex(2);
		 
	//pincode
		 
		 WebElement pincodeDropDown = driver.findElement(By.id("ContentPlaceHolder1_ddlPINCode"));
		 Select pincodeSelect =new Select(pincodeDropDown);
		 pincodeSelect.selectByValue("683513");

		 
	//side bar clicks
		 driver.findElement(By.partialLinkText("Bihar")).click();
		 
    //Testcase : Details ICON should show the details
		 WebElement detailImg = driver.findElement(By.cssSelector("img[src='Images/Home/Open.png']"));
	//	 detailImg.click();
		 
		 
    //check wheather navigation buttons are working properly
		 
		 //Next button
		 
		 
		 driver.findElement(By.id("ContentPlaceHolder1_gvBranch_GridViewPaging_imgBtnNext")).click();
		 System.out.print("next");
		 
		 //back button
		 
		 System.out.print("back");
		 driver.findElement(By.id("ContentPlaceHolder1_gvBranch_GridViewPaging_imgBtnPrev")).click();
		
		 System.out.print("f");
		 
		 
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
	  driver.close();
  }
  

}
