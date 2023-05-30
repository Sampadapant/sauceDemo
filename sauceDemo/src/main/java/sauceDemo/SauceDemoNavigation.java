package sauceDemo;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class SauceDemoNavigation {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("// input[@id='user-name']")).sendKeys("standard_user");
	    driver.findElement(By.xpath("// input[@id='password']")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("// input[@id='login-button']")).click();
	    driver.findElement(By.cssSelector(".bm-burger-button")).click();
	    List<WebElement> lists = driver.findElements(By.cssSelector(".bm-item.menu-item"));
	    List<String> actualLists = new ArrayList<String>();

	    for(WebElement newlists :lists) {
	    	actualLists.add(newlists.getText());
	    	System.out.println(newlists.getText());
	    }
	    String [] expectedNavItems= {"All Items","About","Logout","Reset App State"};
	    for (int i = 0; i > expectedNavItems.length; i++) {
	          System.out.println(expectedNavItems[i]);
	       
	   Assert.assertEquals(actualLists.get(i), expectedNavItems[i], "Navigation item is not correct");

	    }
//	    WebElement allItems = driver.findElement(By.xpath("//*[@id=\"inventory_sidebar_link\"]"));
//	    WebElement about = driver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]"));
//	    WebElement logOut = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
//	    WebElement resApp = driver.findElement(By.xpath("//*[@id=\"reset_sidebar_link\"]"));
//	    
//	    System.out.println(allItems.getText());
//	    System.out.println(about.getText());
//	    System.out.println(logOut.getText());
//	    System.out.println(resApp.getText());
//	    
//		Assert.assertEquals(allItems.getText(),"All Items");
//		Assert.assertEquals(about.getText(),"About");
//		Assert.assertEquals(logOut.getText(),"Logout");
//		Assert.assertEquals(resApp.getText(),"Reset App State");
//		
		driver.quit();
		

	}

}
