package com.dhruv.parkingcal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ParkCal3 {

	public static void main(String[] args) {
		
		
		// Calculate Valet parking rate for FIVE HOURS OR LESS
		
		
		    String baseURL = "http://www.shino.de/parkcalc/";
		
		    WebDriver driver = new FirefoxDriver();
		    driver.get(baseURL);
			driver.manage().window().maximize();
			
			// 1. Valet Parking Rate for FIVE HOURS
			
			// Valet Parking is selected from drop-down box
			
			Select webElement = new Select (driver.findElement(By.id("ParkingLot")));
			webElement.selectByValue("Valet");
			
			// Starting Date box is cleared and date value is entered
			
			driver.findElement(By.id("StartingDate")).clear();
			driver.findElement(By.id("StartingDate")).sendKeys("4/5/2016");
			
			// Starting Time box is cleared, time value is entered and PM button is clicked
			
			driver.findElement(By.id("StartingTime")).clear();
			driver.findElement(By.id("StartingTime")).sendKeys("3:00");
			driver.findElement(By.xpath("//input[@name='StartingTimeAMPM'][@value='AM']")).click();
			
			// Leaving Date box is cleared and date value is entered
			
			driver.findElement(By.id("LeavingDate")).clear();
			driver.findElement(By.id("LeavingDate")).sendKeys("4/5/2016");
			
			//Leaving Date box is cleared, time value is entered and PM button is clicked
			
			driver.findElement(By.id("LeavingTime")).clear();
			driver.findElement(By.id("LeavingTime")).sendKeys("8:00");
			driver.findElement(By.xpath("//input[@name='LeavingTimeAMPM'][@value='AM']")).click();
			
			// Estimated parking cost is calculated
			
			driver.findElement(By.xpath("//input[@value='Calculate']")).click();
			driver.close();
			
			
			
			
			
			// 2. Valet Parking rate for LESS THAN FIVE HOURS
			
			
			
			WebDriver d = new FirefoxDriver();
			d.get(baseURL);
			d.manage().window().maximize();
			
			// Valet Parking is selected from drop-down box
			
		    Select webelement = new Select (d.findElement(By.id("ParkingLot")));
			webelement.selectByValue("Valet");
						
			// Starting Date box is cleared and date value is entered
						
			d.findElement(By.id("StartingDate")).clear();
			d.findElement(By.id("StartingDate")).sendKeys("4/5/2016");
						
			// Starting Time box is cleared, time value is entered and PM button is clicked
						
			d.findElement(By.id("StartingTime")).clear();
			d.findElement(By.id("StartingTime")).sendKeys("2:00");
			d.findElement(By.xpath("//input[@name='StartingTimeAMPM'][@value='PM']")).click();
						
		    // Leaving Date box is cleared and date value is entered
						
			d.findElement(By.id("LeavingDate")).clear();
			d.findElement(By.id("LeavingDate")).sendKeys("4/5/2016");
						
			//Leaving Date box is cleared, time value is entered and PM button is clicked
						
			d.findElement(By.id("LeavingTime")).clear();
			d.findElement(By.id("LeavingTime")).sendKeys("5:30");
			d.findElement(By.xpath("//input[@name='LeavingTimeAMPM'][@value='PM']")).click();
						
			// Estimated parking cost is calculated
						
			d.findElement(By.xpath("//input[@value='Calculate']")).click();
			
		}


	}


