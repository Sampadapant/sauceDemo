package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class jquery {
	ChromeDriver driver;
     @Test
      public void droppableJquery() {
    	 driver = new ChromeDriver();
    	 driver.get("https://jqueryui.com/droppable/");
    	 Actions ac = new Actions(driver);
    	 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
    	 WebElement dr = driver.findElement(By.id("draggable"));
    	 WebElement dp = driver.findElement(By.id("droppable"));
    	 ac.dragAndDrop(dr, dp).build().perform();
    	 
    	 String firstDrop = dp.getText();
    	 System.out.println(firstDrop);
    	 
    	 Assert.assertEquals(firstDrop, "Dropped!");
    	 
    	 driver.quit();

   }
     @Test
     public void verifyTitle() {
    	 driver = new ChromeDriver();
    	 driver.get("https://jqueryui.com/droppable/");
    	 driver.manage().window().maximize();
    	 Assert.assertEquals(driver.getTitle(), "Droppable | jQuery UI");
    	 driver.quit();
     }
     
     @Test
     public void verifyCurrentUrl() {
    	 driver = new ChromeDriver();
    	 driver.get("https://jqueryui.com/droppable/");
    	 Assert.assertEquals(driver.getCurrentUrl(), "https://jqueryui.com/droppable/");
    	 driver.quit();
     }
     
   }
