package newpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class MyClass {
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
		              
					WebElement txtBrand = driver.findElement(By.xpath("html/body/input[1]"));
					txtBrand.clear();
					txtBrand.sendKeys(prop.getProperty("brand"));
		              
					WebElement txtType = driver.findElement(By.xpath("html/body/input[2]"));
					txtType.clear();
					txtType.sendKeys(prop.getProperty("type"));
		              
					Select sltYear = new Select(driver.findElement(By.xpath("html/body/select")));
					sltYear.selectByVisibleText("2016");
		              
					WebElement rdbFuel = driver.findElement(By.xpath("html/body/input[3]"));
					rdbFuel.click();
		              
					WebElement chkAction = driver.findElement(By.xpath("html/body/input[5]"));
					chkAction.click();
		              
					WebElement btnSave = driver.findElement(By.xpath("html/body/input[7]"));
					btnSave.click();
		              
					message01 = driver.findElement(By.xpath("html/body")).getText();
		              
					System.out.println(message01);
		              
					if(message01.equals(message02))
					{
						System.out.println("Test Case Passed");
					}else{
						System.out.println("Test Case Failed");
					}
		                          
					// close the browser
					driver.close();
		                            
}
}