package com.tcs;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	public static WebDriver driver;
	public static Actions actions;
	public static Select select;
	public static Alert al;
	public static TakesScreenshot screenshot;
	public static JavascriptExecutor executor;
	
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public void fireFoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	public void edgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	public void IEDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
	public void loadUrl(String Url) {
		driver.get(Url);
	}
	public void maximize() {
		driver.manage().window().maximize();
	}
	public void type(WebElement element,String data) {
		element.sendKeys(data);
	}
	public void click(WebElement element) {
		element.click();
	}
	public void closeCurrentBrowser() {
		driver.close();  
	}
	public void closeBrowser() {
		driver.quit();  
	}
	public WebElement findElementById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}
	public WebElement findElementByName(String data) {
		WebElement element = driver.findElement(By.name(data));
		return element;
	}
	public WebElement findElementByXpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}
	public String getEnteredUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public String getText(WebElement element) {
		String data = element.getText();
		return data;
	}
	public String getAttribute(String atrributeName, WebElement element) {
		String data = element.getAttribute(atrributeName);
		return data;
	}
	public String getAtrribute(WebElement element) {
		String title = element.getAttribute("value");
		return title;
	}
	public void mouseOverAction(WebElement element) {
		 actions = new Actions(driver);
		 actions.moveToElement(element).perform();	 
	}
	public void dragAndDrop(WebElement source, WebElement target) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void selectOptionsByText(WebElement element,String data) {
		select = new Select(element);
		select.selectByValue(data);
	}
	public void selectOptionByAttribute(WebElement element,String data) {
		select = new Select(element);
		select.selectByValue(data);
	}
	public void selectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	public void deselectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);
	}
	public void deselectOptionByText(WebElement element,String data) {
		select = new Select(element);
		select.deselectByVisibleText(data);
	}
	public void deselectOptionByValue(WebElement element,String data) {
		select = new Select(element);
		select.deselectByValue(data);  
	}
	public void deselectAll(WebElement element) {
		select = new Select(element);
		select.deselectAll();  
	}
	public boolean isMultiple(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	public List<WebElement> getOptions(WebElement element) {
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		return list;
	}
	public String getFirstSelectedOption(WebElement element) {
		select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}
	public List<WebElement> getAllSelectedOption(WebElement element) {
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}
	public List<String> getOptionsText(WebElement element) {
		List<String>allOptions = new ArrayList<String>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement eachElement : options) {
			String data = eachElement.getText();
			allOptions.add(data);
		}
		return allOptions;
	}
	public Alert alertWindow() {
		al = driver.switchTo().alert();
		return al; 
	}
	public void acceptAlert() {
		al = driver.switchTo().alert();
		al.accept();
	}
	public void dismissAlert() {
		al = driver.switchTo().alert();
		al.dismiss();
	}
	public void promptAlert(String data) {
		al = driver.switchTo().alert();
		al.sendKeys(data);
	}
	public void sleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	public void navigateTo(String data) {
		driver.navigate().to(data); 
	}
	public void navigateBack() {
		driver.navigate().back(); 
	}
	public void navigateForward() {
		driver.navigate().forward(); 
	}
	public void refresh() {
		driver.navigate().refresh(); 
	}
	public void screenshot(String data) throws IOException {
		screenshot = (TakesScreenshot)driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File(data);
		FileUtils.copyFile(s, d);
	}
	public JavascriptExecutor javaScript() {
		executor = (JavascriptExecutor) driver;	
		return executor;    
	}
	public void enterUsingJavaScript(String data, WebElement element){ 
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value', '"+data+"')",element); 
	}
	public void clickUsingJavaScript(WebElement element) {
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",element);
	}
	public Object getAttributeinJavaScript(String data, WebElement element){
		executor = (JavascriptExecutor)driver;
		Object executeScript = executor.executeScript("return arguments[0].getAttribute('value')",element);
		return executeScript; }
	public void scrollDown( WebElement element) {
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);   }
	
	public void scrollUp( WebElement element) {
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);   
	}
	public void robotEnter() throws Throwable  {
		new Robot().keyPress(KeyEvent.VK_ENTER);
		new Robot().keyRelease(KeyEvent.VK_ENTER);
	}
	public void robotSelectAll() throws Throwable {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_A);
		new Robot().keyRelease(KeyEvent.VK_A);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}
	public void robotCut() throws Throwable {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_X);
		new Robot().keyRelease(KeyEvent.VK_X);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}
	public void robotCopy() throws Throwable {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_C);
		new Robot().keyRelease(KeyEvent.VK_C);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}
	public void robotPaste() throws Throwable {
		new Robot().keyPress(KeyEvent.VK_CONTROL);
		new Robot().keyPress(KeyEvent.VK_V);
		new Robot().keyRelease(KeyEvent.VK_V);
		new Robot().keyRelease(KeyEvent.VK_CONTROL);
	}
	public void switchToFrameUsingIdAndNAme(String data) {
		driver.switchTo().frame(data); 
	}
	public void switchToFrameUsingElement(WebElement element) {
		driver.switchTo().frame(element); 
	}
	public void switchToFrameUsingIndex(int i) {
		driver.switchTo().frame(i); 
	}
	public void exitFrame() {
		driver.switchTo().defaultContent(); 
	}
	public void exitChildFrame() {
		driver.switchTo().parentFrame(); 
	}
	public void switchToWindowUsingUrl(String data) {
		driver.switchTo().window(data); 
	}
	public void switchToWindowUsingTitle(String data) {
		driver.switchTo().window(data); 
		}
	public void switchToWindowUsingId(String data) {
		driver.switchTo().window(data); 
		}
	public String toGetParentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
		}
	public Set<String> toGetAllWIndowsId() {
		Set<String> allwindowHandles = driver.getWindowHandles();
		return allwindowHandles; 
		}
	public void switchToChildWindow() {
		String pWId = driver.getWindowHandle();
		Set<String> allwindowHandles = driver.getWindowHandles();
		for (String eacWindowID : allwindowHandles) {
			if (!pWId.equals(eacWindowID)) {
				driver.switchTo().window(eacWindowID);
			}
			}}
	public void switchToMultipleWindow(int index) {
		Set<String> allwindowHandles = driver.getWindowHandles();
		List<String> li = new ArrayList();
		li.addAll(allwindowHandles);
		driver.switchTo().window(li.get(index));
	}
    public String getData(String sheetName,int rowNum,int cellNum) throws IOException {
    	String data = null;
    	File file = new File("C:\\Users\\Balaji\\eclipse-workspace\\Java\\Excel Sheet\\DEMO.xlsx");
    	FileInputStream stream = new FileInputStream(file);
    	Workbook workbook = new XSSFWorkbook(stream);
    	Sheet sheet = workbook.getSheet(sheetName);
    	Row row = sheet.getRow(rowNum);
    	Cell cell = row.getCell(cellNum);
    	int type = cell.getCellType();
    	if(type==1) {
    		 data = cell.getStringCellValue();    
    	}
    	if(type==0) {
    	if(DateUtil.isCellDateFormatted(cell));
    	Date date = cell.getDateCellValue();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
    	 data = dateFormat.format(date);
    	}else {
    	double d = cell.getNumericCellValue();
    	long l = (long)d;
    	 data = String.valueOf(l);
    	}
    	return data;
	}
	public void Adddata(String filename, String sheetname, int r, int c, String data) throws Throwable {
		File file = new File(filename); //cell already contains data
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(r);
		Cell cell = row.createCell(c);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
}
	public void updateData(String SheetName, int rowNum, int CellNum,String newData) throws IOException {
		File file = new File("C:\\Users\\Balaji\\eclipse-workspace\\Framework\\Excel Sheet\\DEMO.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(CellNum);
		cell.setCellValue(newData);
		FileOutputStream o = new FileOutputStream(file);
		workbook.write(o);	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
