package com.dhruv.parkingcal;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


//5. Calculate Short Term (hourly) parking


public class ParkCal5 {
	
	static int year = 2015;
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.shino.de/parkcalc/");
	    String homePage = driver.getWindowHandle();
	
		Select WebElement = new Select (driver.findElement(By.id("ParkingLot")));
		WebElement.selectByValue("Short");
		
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
				webElement.selectByVisibleText("September");
			
				
				if(year <2016)
				{
					WebElement year = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a[1]/b/font"));
					year.click();
				}else if (year > 2016)
				{
						WebElement year = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a[2]/b/font"));
						year.click();
				}
				
				driver.findElement(By.xpath("//a[contains(text(), '17')]")).click();
			
			 }
				
				
		  }
		//Navigate back to home page
		
		driver.switchTo().window(homePage);
		
		
		driver.findElement(By.id("StartingTime")).clear();
		driver.findElement(By.id("StartingTime")).sendKeys("09:36");
		driver.findElement(By.xpath("//input[@name='StartingTimeAMPM'][@value='AM']")).click();
		
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[2]/a/img")).click();
		  
		//Set of Windows IDs in String Format
		
		Set<String> windows1 = driver.getWindowHandles();
		Iterator<String> iterator1 = windows1.iterator();
		String CurrentWindowId1;
		
		while(iterator1.hasNext())
		{
			CurrentWindowId1 = iterator1.next().toString();
			
			if(!CurrentWindowId1.equals(homePage))
			{
				driver.switchTo().window(CurrentWindowId1);
				Select webElement = new Select (driver.findElement(By.name("MonthSelector")));
				webElement.selectByVisibleText("September");
			
				if(year <2016)
				{
					WebElement year = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a[1]/b/font"));
					year.click();
				}else if (year > 2016)
				{
						WebElement year = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a[2]/b/font"));
						year.click();
				}
				
				driver.findElement(By.xpath("//a[contains(text(), '17')]")).click();
			
			 }
				
				
		  }
		
		driver.switchTo().window(homePage);
		
		
		driver.findElement(By.id("LeavingTime")).clear();
		driver.findElement(By.id("LeavingTime")).sendKeys("10:35");
		driver.findElement(By.xpath("//input[@name='LeavingTimeAMPM'][@value='AM']")).click();
		
		
		driver.findElement(By.xpath("//input[@value='Calculate'][@name='Submit']")).click();

	
}

}

