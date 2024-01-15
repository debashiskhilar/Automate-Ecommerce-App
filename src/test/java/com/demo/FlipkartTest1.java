package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest1 {
	WebDriver driver = null;
	@BeforeClass
	public void beforeClass() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		System.out.println("Testing initiated");
	}

	@Test(priority = 1)
	public void TestOnChrome() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Testing initiated on Chrome Broweser");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://www.flipkart.com/");
		long start_time = System.currentTimeMillis();
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length -1], 3000);");

		System.out.println("Passed Time: " +(System.currentTimeMillis() - start_time) + " milliSeconds");		
		Thread.sleep(2000);
		
		WebElement we1=driver.findElement(By.linkText("YouTube"));
	    js.executeScript("arguments[0].scrollIntoView();", we1);
		Thread.sleep(2000);
		System.out.println("Reached end of the page by scrolling down");
		
		WebElement we2=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[1]"));
	    js.executeScript("arguments[0].scrollIntoView();", we2);
		Thread.sleep(2000);
		System.out.println("Reached top of the page by scrolling up");
		System.out.println("Go to mobile section");
		we2.click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("iphone 13");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
		Thread.sleep(2000);
		System.out.println("Searching for iphone 13");
		
        driver.navigate().refresh();   
        System.out.println("Refreshed the page successfully");
		
	}
	
	@Test(priority = 2)
	public void testOnEdge() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		System.out.println("Testing initiated on Edge Broweser");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://www.flipkart.com/");
		long start_time = System.currentTimeMillis();
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length -1], 3000);");

		System.out.println("Passed Time: " +(System.currentTimeMillis() - start_time) + " milliSeconds");		
		Thread.sleep(2000);
		
		WebElement we1=driver.findElement(By.linkText("YouTube"));
	    js.executeScript("arguments[0].scrollIntoView();", we1);
		Thread.sleep(2000);
		System.out.println("Reached end of the page by scrolling down");
		
		WebElement we2=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[1]"));
	    js.executeScript("arguments[0].scrollIntoView();", we2);
		Thread.sleep(2000);
		System.out.println("Reached top of the page by scrolling up");
		System.out.println("Go to mobile section");
		we2.click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("iphone 13");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
		Thread.sleep(2000);
		System.out.println("Searching for iphone 13");
		
		
        driver.navigate().refresh();   
        System.out.println("Refreshed the page successfully");
		
	}
	


	@AfterClass
	public void afterClass() {
		System.out.println("Testing Ended successfully");
		driver.close();
	}

}
