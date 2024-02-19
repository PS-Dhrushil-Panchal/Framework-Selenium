package base;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.main.Constants;
import com.main.PropertyReader;

public class LoginErrorCheck extends BaseClass{
	WebDriver driver;
    PropertyReader propreader=new PropertyReader();
    public LoginErrorCheck(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath="//span[@id='lblMessage']")
    private WebElement ErrorMessage;
    @FindBy(id= "txtUserName")
	private WebElement Username;
	@FindBy(id = "txtPassword")
	private WebElement password;
	@FindBy (xpath = "//a[@id='btnLogin']")
	private WebElement loginbutton;
	
	//checking user functionality
	public void ErrorMessage() {
		//driver.navigate().back();
		String User=propreader.readProperty(Constants.WRONGUSER);
		String Pass=propreader.readProperty(Constants.WRONGPASS);
		Username.clear();
		Username.sendKeys(User);
		password.clear();
		password.sendKeys(Pass);
		loginbutton.click();
		String Msg = propreader.readProperty(Constants.LOGINERROR);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		String ActMsg = wait.until(ExpectedConditions.visibilityOf(ErrorMessage)).getText();
		String ActMsg = ErrorMessage.getText();
		System.out.println(ActMsg);
		assertEquals(ActMsg, Msg);
	}
}
