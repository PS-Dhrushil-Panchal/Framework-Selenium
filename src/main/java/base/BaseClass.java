package base;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.main.PropertyReader;

import bsh.org.objectweb.asm.Constants;

public class BaseClass {
	
	public static WebDriver driver;
	@BeforeSuite
	public void initDriver() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
}