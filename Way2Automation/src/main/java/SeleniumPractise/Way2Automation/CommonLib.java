package SeleniumPractise.Way2Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLib {

	WebDriver driver;
	WebDriverWait wait;
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	String ProjectPath = System.getProperty("user.dir");

	public void Setup() {
		System.out.println(ProjectPath);
		System.setProperty("webdriver.chrome.driver", ProjectPath.replace("\\", "\\\\") + "\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public WebDriver LaunchBrowser(String URL) {
		try {
			driver.get(URL);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return driver;
	}
	
	public String FetchCurrentURL() {
		return driver.getCurrentUrl().toString();			
	}
	
	public WebDriver GetDriverInstance() {
		return driver;		
	}
	
	public WebDriverWait GetDriverWaitInstance() {
		return wait;
	}
}
