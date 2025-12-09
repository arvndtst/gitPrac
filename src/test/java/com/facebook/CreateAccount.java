package com.facebook;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccount {
	
	static WebDriver driver;
	@Given("Launch browser and facebook {string}")
	public void launch_browser_and_facebook(String string) {
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(string);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    String url=driver.getCurrentUrl();
	}  
	@When("Click create a new account")
	public void click_create_a_new_account() {
	   WebElement create=driver.findElement(By.xpath("//a[text()='Create new account']"));
	   create.click();
	
	}
	@When("Enter firstname and lastname {string} {string}")
	public void enter_firstname_and_lastname(String string, String string2) {
	    WebElement fn=driver.findElement(By.xpath("//input[@name='firstname']"));
	    fn.sendKeys(string);
	    WebElement ln=driver.findElement(By.xpath("//input[@name='lastname']"));
	    ln.sendKeys(string2);
	}
	@When("Select dateofbirth {string} {string} {string}")
	public void select_dateofbirth(String string, String string2, String string3) {
		WebElement dt=driver.findElement(By.xpath("//select[@aria-label='Day']"));
		Select datopt=new Select(dt);
		datopt.selectByValue(string);
		WebElement mn=driver.findElement(By.xpath("//select[@aria-label='Month']"));
		Select monopt=new Select(mn);
		monopt.selectByValue(string2);
		WebElement yr=driver.findElement(By.xpath("//select[@aria-label='Year']"));
		Select yearopt=new Select(yr);
		yearopt.selectByValue(string3);
	}
	@When("Select Gender {string}")
	public void select_gender(String string) {
		WebElement gen=driver.findElement(By.xpath("//*[text()='"+string+"']"));
		gen.click();
	}
	@When("Enter id {string}")
	public void enter_id(String string) {
	    WebElement id=driver.findElement(By.xpath("//input[contains(@aria-label,'email')]"));
	    id.sendKeys(string);
	}
	@When("Enter password {string}")
	public void enter_password(String string) {
	  WebElement pass=driver.findElement(By.xpath("//input[contains(@aria-label,'password')]"));
	  pass.sendKeys(string);
	  
	}
	@When("Click register")
	public void click_register() {
	   WebElement reg=driver.findElement(By.xpath("//button[@type='submit']"));
	   reg.click();
	}
	@Then("TakeScreenShot of the page {string}")
	public void take_screen_shot_of_the_page(String string) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("/Users/arvi/eclipse-workspace/Facebook/Screenshots/"+string+".png");
		source.renameTo(target);
	
}
}
