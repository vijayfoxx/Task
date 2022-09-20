package task;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AddToCartTest {
	@Test
	public void addToCartTask() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://flipkart.com");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("winter heater");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		driver.findElement(By.xpath("(//a[@class='s1Q9rs'])[1]")).click();
		Set<String> whs = driver.getWindowHandles();
		Iterator<String> it=whs.iterator();
		String wh=it.next();
		String wh2=it.next();
		driver.switchTo().window(wh2);
		String productName= driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		String cartProductName= driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
		Assert.assertEquals(productName,cartProductName);
		driver.close();
	}
}
