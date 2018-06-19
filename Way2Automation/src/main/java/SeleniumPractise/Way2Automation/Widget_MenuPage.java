package SeleniumPractise.Way2Automation;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Widget_MenuPage {

	@FindBy(xpath = "//a[text()='Widget']")
	WebElement WidgetTab;
	
	@FindBy(xpath="//a[text()='Menu']")
	WebElement Menu;
	
	@FindBy(xpath="//a[text()='Menu With Sub Menu']")
	WebElement MenuWithSubMenuHeader;
	
	@FindBy(how=How.CLASS_NAME,using="demo-frame")
	WebElement MenuWithSubMenuHeader_iframe;
	
	@FindBy(how=How.XPATH,using="//ul[@aria-activedescendant='ui-id-18']//following-sibling::li[2]")
	WebElement Adamsville;
	
	@FindBy(how=How.XPATH,using="//ul[@aria-expanded='true']/li[text()='Sub Menu 4']")
	WebElement Adamville_SubMenu4;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"example-1-tab-2\"]/div/iframe")
	WebElement SubmenuIframe;
	
	
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

	public void MenuWithSubMenu() {
		driver.switchTo().frame(SubmenuIframe);
		Actions ac=new Actions(driver);
		Action soa=ac.moveToElement(Adamsville).click().moveToElement(Adamville_SubMenu4).click().build();
		soa.perform();
		System.out.println(Adamville_SubMenu4.getText());
	}
}


