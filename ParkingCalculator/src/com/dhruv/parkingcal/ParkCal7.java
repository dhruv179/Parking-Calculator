package com.dhruv.parkingcal;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ParkCal7 {

	public static void main(String[] args) {
		
		
		// Calculate Long-Term Surface parking rate 
		
		
		    String baseURL = "http://www.shino.de/parkcalc/";
		
		    WebDriver driver = new FirefoxDriver();
		    driver.get(baseURL);
			driver.manage().window().maximize();
			
			Select webElement = new Select (driver.findElement(By.id("ParkingLot")));
			webElement.selectByValue("Long-Surface");
			
			driver.findElement(By.id("StartingDate")).clear();
			driver.findElement(By.id("StartingDate")).sendKeys("8/5/2015");
			
			driver.findElement(By.id("StartingTime")).clear();
			driver.findElement(By.id("StartingTime")).sendKeys("4:00");
			driver.findElement(By.xpath("//input[@name='StartingTimeAMPM'][@value='PM']")).click();
			
			
			driver.findElement(By.id("LeavingDate")).clear();
			driver.findElement(By.id("LeavingDate")).sendKeys("8/17/2015");
			
			
			driver.findElement(By.id("LeavingTime")).clear();
			driver.findElement(By.id("LeavingTime")).sendKeys("8:00");
			driver.findElement(By.xpath("//input[@name='LeavingTimeAMPM'][@value='AM']")).click();
			
			
			driver.findElement(By.xpath("//input[@value='Calculate']")).click();
			

	}

}
