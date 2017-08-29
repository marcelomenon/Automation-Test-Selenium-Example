package newpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MyClass2 {
	public static void main(String[] args) {
		
					File file = new File("src/datafile.properties");
					FileInputStream fileInput = null;
					try {
						fileInput = new FileInputStream(file);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					Properties prop = new Properties();
		
					//load properties file
					try {
						prop.load(fileInput);
					} catch (IOException e) {
						e.printStackTrace();
					}
		
					WebDriver driver = new FirefoxDriver();
		              
					// maximize the browser window
					driver.manage().window().maximize();
		              
					String message01;
					String message02 = "Saved";
		              
					// to open the index.html located in eclipse
					String inputFilePath = prop.getProperty("url");
					String url = new File(inputFilePath).getAbsolutePath();
					driver.get("file:///"+url);
					driver.get(url);
		              
					driver.findElement(By.xpath(".//input[@name='brand']")).sendKeys(prop.getProperty("brand"));
		              
					driver.findElement(By.xpath(".//input[@name='type']")).sendKeys(prop.getProperty("type"));
		              
					new Select (driver.findElement(By.xpath(".//select"))).selectByVisibleText("2016");
		              
					driver.findElement(By.xpath(".//input[@value='gas']")).click();
		              
					driver.findElement(By.xpath(".//input[@value='buy']")).click();
		              
					driver.findElement(By.xpath(".//input[@value='save']")).click();
		              
					message01 = driver.findElement(By.xpath("html/body")).getText();
		              
					try{
						Assert.assertEquals(message02, message01);
		      
						System.out.println("Test Case Passed");
					}catch(AssertionError e){
						System.out.println("Test Case Failed");
					}
		              
					// close the browser
					driver.close();
		                            
}
}