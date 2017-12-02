package test;

import org.testng.annotations.Test;

import pageObjects.Accessories_Page;
import pageObjects.Checkout_Page;
import pageObjects.Continue_Page;
import pageObjects.Home_Page;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestNG {
	public WebDriver driver;
	
  @Test (description="STEP 1: Go to http://store.demoqa.com/")
  public void launchSite() throws InterruptedException {
		driver.get("http://store.demoqa.com");
		assertEquals(driver.getTitle(), "ONLINE STORE | Toolsqa Dummy Test site");
  }
	
  @Test (description="STEP 2: Go to Product category and select Accessories")
  public void selectAccessories() throws InterruptedException {

		Actions actions = new Actions(driver);
		WebElement menu = Home_Page.product_Category_tab(driver);
		actions.moveToElement(menu);
		WebElement subMenu = Home_Page.lnk_accessories(driver);
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		
		assertEquals(driver.getTitle(), "Accessories | ONLINE STORE");
  }
  
  @Test (description="STEP 3: Click on “Add to Cart” for just Magic Mouse")
  public void addMagicMouseToCart() throws InterruptedException {
		
		Accessories_Page.magic_Mouse_Add_To_Cart_Button(driver).click();;
		
  }
  
  @Test (description="STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page")
  public void checkoutAndConfirmMagicMouse() throws InterruptedException {		
		Home_Page.lnk_Checkout(driver).click();
		
		//Confirm have 1 magic mouse in checkout page

  }	
  
  @Test (description="STEP 5: After confirming, click on Continue")
  public void clickOnContinue() throws InterruptedException {
		
		Checkout_Page.lnk_continue(driver).click();

  }
  
		
  @Test (description="STEP 6: Enter test data needed for email,  billing/contact details and billing/contact details and click Purchase")
  public void enterBillDataAndPurchase() throws InterruptedException {
		Continue_Page.txtbx_Billingemail(driver).sendKeys("zackforhack@gmail.com");
		Continue_Page.txtbx_Billingfirstname(driver).sendKeys("Ziqian");
		Continue_Page.txtbx_Billinglastname(driver).sendKeys("Huang");
		Continue_Page.txtbx_Billingaddress(driver).sendKeys("197 Cameron Ave");
		Continue_Page.txtbx_Billingcity(driver).sendKeys("North York");
		Continue_Page.txtbx_Billingphone(driver).sendKeys("4163179500");
		Continue_Page.dropdown_Billingcountry(driver).selectByVisibleText("Canada");
		Continue_Page.txtbx_Billingstate(driver).sendKeys("Ontario");
		Continue_Page.txtbx_Shippingstate(driver).sendKeys("Ontario");
		Continue_Page.purchase_btn(driver).click();
  }	
		
  @Test (description="STEP 7: Confirm that you have placed the Order in ‘Transaction Results’ page")
  public void confirmOrder() throws InterruptedException {
  }
	  
	  
	  
  
  
  @BeforeSuite(alwaysRun = true)
  public void setupBeforeSuite() {
	  try {
		System.setProperty("webdriver.chrome.driver", "/Users/amandayang/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Test_Data.Wait_Time_Seconds, TimeUnit.SECONDS);
	  } catch(Exception e) {
		  throw new IllegalStateException("Can't start broweser driver", e);
	  }

  }

  @AfterSuite(alwaysRun = true)
  public void setupAfterSuite() {
	  // Close the driver
	  
      //driver.quit();
	  
  }
  

}
