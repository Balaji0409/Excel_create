package com.tcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	@Parameters({"browser"})
	@Test
	public void launch(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.greenstech.in/selenium-course-content.html");
	}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.get("http://www.greenstech.in/selenium-course-content.html");
	}	
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.get("http://www.greenstech.in/selenium-course-content.html");
	}	else {
		System.out.println("No such Browser!!!");
	}
}
}
