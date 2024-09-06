package com.cura;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Cura_HealthCare {
	public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://katalon-demo-cura.herokuapp.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.findElement(By.id("btn-make-appointment")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("#txt-username")).sendKeys("John Doe");
	Thread.sleep(3000);
	driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	WebElement StaticDropdown = driver.findElement(By.id("combo_facility"));
	Select dropdown = new Select(StaticDropdown);
	dropdown.selectByIndex(1);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("#radio_program_medicaid")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='txt_visit_date']")).sendKeys("12/09/2024");
	Thread.sleep(3000);
	driver.findElement(By.id("txt_comment")).sendKeys("Monthly dental checkup");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("D:\\SeleniumScreenshot\\appointment.png"));
	Thread.sleep(5000);
	System.out.println("Execution done Successfully");
	driver.quit();
	}

}
