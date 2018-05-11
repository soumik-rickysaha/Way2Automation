package SeleniumPractise.Way2Automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;





/**
 * Unit test for simple App.
 */
public class Way2AutomationLogin {
	CommonLib Clib;
	String URL = "http://www.way2automation.com/demo.html";
	WebDriver driver;

	@BeforeTest
	public void LaunchBrowser(){
		Clib=new CommonLib();
		Clib.Setup();
		driver=Clib.LaunchBrowser(URL);
		String ActualURL=Clib.FetchCurrentURL();
		//
		try {
			Assert.assertEquals(ActualURL, URL);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
