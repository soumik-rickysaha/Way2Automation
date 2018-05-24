package SeleniumPractise.Way2Automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

/**
 * Unit test for simple App.
 */
public class Way2AutomationLogin {
	CommonLib Clib;
	String URL = "http://www.way2automation.com/demo.html";
	WebDriver driver;
	WebDriverWait wait;

	// Page objects

	By ResignationTab = By.xpath("//*[@id=\"toggleNav\"]/li[6]/a");
	By SigninLink = By.xpath("//a[@class='fancybox'][text()='Signin']");
	By Username=By.xpath("//*[@id=\"load_form\"]/fieldset[1]/input[@name='username']");
	By Password=By.xpath("//*[@id='load_form']/fieldset[2]/input[@name='password']");
	By SubmitButton=By.xpath("//*[@id=\"load_form\"][@class='ajaxlogin']/div/div[2]/input");
	By Loginform=By.xpath("//*[@id=\"load_form\"]");
	
	
	@BeforeSuite
	public void LaunchBrowser() {
		Clib = new CommonLib();
		Clib.Setup();
		driver = Clib.LaunchBrowser(URL);
		wait = Clib.GetDriverWaitInstance();
		String ActualURL = Clib.FetchCurrentURL();
		//
		try {
			Assert.assertEquals(ActualURL, URL);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Test(priority=1)
	@Parameters({"Username","password"})
	public void LoginToApp(String Uname,String Pass) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(ResignationTab));
		driver.findElement(ResignationTab).click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs.get(1));
		// Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(SigninLink));
		driver.findElement(SigninLink).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Username)));
		driver.findElement(Username).sendKeys(Uname);
		driver.findElement(Password).sendKeys(Pass);
		driver.findElement(SubmitButton).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Widget']")).isDisplayed());
	}
	
	@Test(priority=2)
	public void WidgetMenuTest() throws InterruptedException {
		Widget_MenuPage MP=new Widget_MenuPage(driver);
		MP.NavigatetoMenuInWidget();
	}
	
	@AfterSuite
	public void Closebrowser() {
		driver.close();
	}
}
