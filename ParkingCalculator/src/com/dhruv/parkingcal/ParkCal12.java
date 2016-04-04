package com.dhruv.parkingcal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ParkCal12 {

	public static void main(String[] args) {
		
		// 1. To verify the default layout of Parking cost calculator

		
        WebDriver d = new FirefoxDriver();
		
		d.get("http://www.shino.de/parkcalc/");
		d.manage().window().maximize();
		d.close();
		
		
		// 2. To verify that user is able to calculate Valet parking rate for PER DAY
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.shino.de/parkcalc/");
		driver.manage().window().maximize();
		
		// Valet Parking is selected from drop-down box
		
		Select webElement = new Select (driver.findElement(By.id("ParkingLot")));
		webElement.selectByValue("Valet");
		
		// Starting Date box is cleared and date value is entered
		
		driver.findElement(By.id("StartingDate")).clear();
		driver.findElement(By.id("StartingDate")).sendKeys("3/31/2016");
		
		// Starting Time box is cleared, time value is entered and PM button is clicked
		
		driver.findElement(By.id("StartingTime")).clear();
		driver.findElement(By.id("StartingTime")).sendKeys("2:00");
		driver.findElement(By.xpath("//input[@name='StartingTimeAMPM'][@value='PM']")).click();
		
		// Leaving Date box is cleared and date value is entered
		
		driver.findElement(By.id("LeavingDate")).clear();
		driver.findElement(By.id("LeavingDate")).sendKeys("4/1/2016");
		
		//Leaving Date box is cleared, time value is entered and PM button is clicked
		
		driver.findElement(By.id("LeavingTime")).clear();
		driver.findElement(By.id("LeavingTime")).sendKeys("2:00");
		driver.findElement(By.xpath("//input[@name='LeavingTimeAMPM'][@value='PM']")).click();
		
		// Estimated parking cost is calculated
		
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
		
	}

}
