package com.tcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Balaji {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement dDnSkills = driver.findElement(By.xpath("//select[@id='Skills']"));
		Select select= new Select(dDnSkills);
		List<WebElement> Skills = select.getOptions();
		//mention the path of the excel sheet
		File file = new File("C:\\Users\\Balaji\\eclipse-workspace\\Java\\Excel Sheet\\DEMO.xlsx");
		//create the workbook-->collections of sheets
	   Workbook workbook = new XSSFWorkbook();
	   //get the sheet name
	   Sheet sheet = workbook.createSheet("Sheet1");
	   //iterate the rows
	   for (int i = 0; i < Skills.size(); i++) {
		   WebElement element = Skills.get(i);
		   //get the text
		   String text = element.getText();
		   Row row = sheet.createRow(i);
		   Cell cell = row.createCell(0);
		   cell.setCellValue(text);
		   }
		   //objects to file
		   FileOutputStream fileOutputStream = new FileOutputStream(file);
		   workbook.write(fileOutputStream);
		   System.out.println("done");
	   
	}	
}				
					
					
					
					
					
					
					
			