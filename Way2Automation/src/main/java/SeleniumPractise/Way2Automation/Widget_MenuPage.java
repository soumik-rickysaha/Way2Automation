package SeleniumPractise.Way2Automation;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Widget_MenuPage {

	@FindBy(xpath = "//a[text()='Widget']")
	WebElement WidgetTab;
	
	@FindBy(xpath="//a[text()='Menu']")
	WebElement Menu;
	
	//declaring variables
	
	WebDriver driver;
	
	Widget_MenuPage(WebDriver driver) {
		
		try {
			this.driver = driver;
			PageFactory.initElements(this.driver, this);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void NavigatetoMenuInWidget() throws InterruptedException {
		Actions ac = new Actions(driver);
		Action soa=ac.moveToElement(WidgetTab).click().moveToElement(Menu).click().build();
		soa.perform();
		Thread.sleep(5000);
	}

	/*@Test
	public void Menu() throws InterruptedException {
		List<WebElement> WidgetsSubitems = driver.findElements(By.xpath("//*[@id=\"toggleNav\"]/li[3]/ul/li[4]/a"));
		for (int i = 0; i<=WidgetsSubitems.size(); i++) {
			if (WidgetsSubitems.get(i).getText().equalsIgnoreCase("Menu")) {
				WidgetMenu(WidgetsSubitems.get(i));
			}
		}
		
		Thread.sleep(5000);
	}*/
}


