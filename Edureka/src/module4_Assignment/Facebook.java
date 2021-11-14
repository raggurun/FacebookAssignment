package module4_Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
//import org.junit.Test;

public class Facebook {


	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();

	String LoginBgcolor = driver.findElement(By.xpath("//*[@name='login']")).getCssValue("background-color");
	System.out.println("Background color of the ‘Log In’ button is blue: " + LoginBgcolor);
	
	driver.findElement(By.linkText("Forgotten password?")).click();
	
	Thread.sleep(2000);
	
	String EmailBgcolor = driver.findElement(By.xpath("//*[@placeholder='Email or phone']")).getCssValue("color");
	System.out.println("Background color of the ‘Email or phone’ button is white: " + EmailBgcolor);
	
	Boolean loginbtn = driver.findElement(By.linkText("Log In")).isEnabled();
	System.out.println("Login Button Enabled = "+ loginbtn);
	
	Boolean url = driver.getCurrentUrl().contains("facebook");
	System.out.println("URL contains the word facebook: "+ url);
	
	//driver.findElement(By.linkText("Forgotten account?")).click();
	
	Thread.sleep(2000);
	
	WebElement mobilenumber = driver.findElement(By.cssSelector("input[placeholder='Mobile number']"));
	mobilenumber.sendKeys("999999");
	
	Thread.sleep(2000);
	
	WebElement Search = driver.findElement(By.cssSelector("button[type='submit']"));
	Search.click();
	
	Thread.sleep(2000);
	
	System.out.println(driver.findElement(By.xpath("//*[@id='account_search']/child::div/form/div/div[2]")).getText());
	
	String title = driver.getTitle();
	System.out.println(title);
	
	driver.close();
	
	


}

}
