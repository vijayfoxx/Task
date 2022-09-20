package task;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureRedmiTest {
	@Test
	public void captureRedmiTask(){
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://flipkart.com");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("redmi");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		List<WebElement> phones=driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM ')]/../../../div[1]"));
		Iterator<WebElement> it= phones.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getText());
		}
		driver.close();
	}
}

