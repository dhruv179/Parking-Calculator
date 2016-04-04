package com.dhruv.parkingcal;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

   //8. Calculate Economy lot parking


public class ParkCal8 {
	
	static int year = 2017;
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.shino.de/parkcalc/");
	    String homePage = driver.getWindowHandle();
	
		Select WebElement = new Select (driver.findElement(By.id("ParkingLot")));
		WebElement.selectByValue("Economy");
		
		driver.findElement(By.xpath("//input[@id='StartingDate']")).findElement(By.xpath("//img[@src='cal.gif']")).click();
			
		//Set of Windows IDs with (homepage and new popUp)
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String CurrentWindowId;
		
		while(iterator.hasNext())
		{
			CurrentWindowId = iterator.next().toString();
			
			
			if(!CurrentWindowId.equals(homePage))
			{
				driver.switchTo().window(CurrentWindowId);
				Select webElement = new Select (driver.findElement(By.name("MonthSelector")));
				webElement.selectByVisibleText("December");
			
				
				if(year <2016)
				{
					WebElement year = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a[1]/b/font"));
					year.click();
				}else if (year > 2016)
				{
						WebElement year = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a[2]/b/font"));
						year.click();
				}
				
				driver.findElement(By.xpath("//a[contains(text(), '2')]")).click();
			
			 }
				
				
		  }
		//Navigate back to home page
		
		driver.switchTo().window(homePage);
		
		driver.findElement(By.id("StartingTime")).clear();
		driver.findElement(By.id("StartingTime")).sendKeys("3:20");
		driver.findElement(By.xpath("//input[@name='StartingTimeAMPM'][@value='PM']")).click();
		
		
		driver.findElement(By.id("LeavingDate")).clear();
		driver.findElement(By.id("LeavingDate")).sendKeys("12/2/2017");
		
		driver.findElement(By.id("LeavingTime")).clear();
		driver.findElement(By.id("LeavingTime")).sendKeys("4:52");
		driver.findElement(By.xpath("//input[@name='LeavingTimeAMPM'][@value='PM']")).click();
		
		
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
		

}

}

