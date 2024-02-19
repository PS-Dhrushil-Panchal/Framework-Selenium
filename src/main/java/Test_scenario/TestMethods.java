package Test_scenario;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.main.Constants;
import com.main.PropertyReader;
import com.pageobject.BaseClass;
import com.pageobject.PageObjectclass;

import base.Egovernance;
import base.LoginErrorCheck;

public class TestMethods extends BaseClass {
	PropertyReader propreader=new PropertyReader();
	@BeforeSuite
	public void initdriver() {
		driver.get(propreader.readProperty(Constants.URL));
		}
	

	
	@Test
	public void LoginToEgoc() {
		Egovernance Test1 = new Egovernance(driver);
		String Username=propreader.readProperty(Constants.USERNAME);
		String Password=propreader.readProperty(Constants.PASSWORD);
		Test1.login(Username, Password);
	}
	
	@Test(dependsOnMethods = "LoginToEgoc")
	public void checkUserName() {
		Egovernance Test2 = new Egovernance(driver);
		Test2.checkUserName();
	}
	
	@Test(dependsOnMethods = "checkUserName")
	public void CheckFontSize() {
		Egovernance Test3 = new Egovernance(driver);
		Test3.CheckFontSize();
				
	}
	
	@Test(dependsOnMethods = "CheckFontSize")
	public void Logout() {
		Egovernance Test4 = new Egovernance(driver);
		Test4.logout();
	}
	
	@Test (dependsOnMethods = "Logout")
	public void Loginerror() {
		LoginErrorCheck lc = new LoginErrorCheck(driver);
		lc.ErrorMessage();
	}	
	
	@AfterTest
	public void aftertest() {
		driver.close();
	}
}
