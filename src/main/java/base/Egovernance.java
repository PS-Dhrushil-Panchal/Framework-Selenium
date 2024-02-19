package base;


import static org.testng.Assert.assertEquals;

import java.awt.Font;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.Constants;
import com.main.PropertyReader;

public class Egovernance {
    WebDriver driver;
    PropertyReader propreader=new PropertyReader();
    public Egovernance(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(id= "txtUserName")
	private WebElement Username;
	@FindBy(id = "txtPassword")
	private WebElement password;
	@FindBy (xpath = "//a[@id='btnLogin']")
	private WebElement loginbutton;
	
	//checking user functionality
	public void login(String id, String pass) {
		Username.clear();
		Username.sendKeys(id);
		password.clear();
		password.sendKeys(pass);
		loginbutton.click();
	}
	
	//checking user name after login
	@FindBy(xpath="//li[@class='head-dpdn']/span[2]")
	private WebElement User;
	
	public void checkUserName() {
		String UsName = User.getText();
		assertEquals(UsName, "DHRUSHIL PANCHAL");
	}
	
	//checking font size
	@FindBy(xpath="//ul[@id='gn-menu']/li/span")
	private WebElement FontSize;
	public void CheckFontSize() {
		String fontsize = FontSize.getCssValue("font-size");
		System.out.println(fontsize);
		String FSize = propreader.readProperty(Constants.FONTSIZE);
		assertEquals(fontsize, FSize);
	}
	
	@FindBy(xpath = "//li/a[@id='lnkLogout']")
	private WebElement LogoutBtn;
	
	public void logout() {
		LogoutBtn.click();
	}
	
	
}
