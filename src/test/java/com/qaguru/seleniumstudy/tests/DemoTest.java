package com.qaguru.seleniumstudy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {
    private final String baseUrl = "https://www.homeandstuff.com/";

    @Test
    public void TestHomePgeTitle() throws InterruptedException {
        System.out.println("Test for home page title");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        String expTitle = "Furniture, Kitchen, Dining Room, Entertainment, Bedroom Sets, Outdoor, Fireplaces";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, expTitle, "incorrect title");
        Thread.sleep(1000);
        driver.quit();

    }

    @Test
    public void TestSearchingForAProduct() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        WebElement txtSearch = driver.findElement(By.name("search_field"));
        txtSearch.sendKeys("table");

        WebElement btnSearch = driver.findElement(By.xpath("//*[@id=\"search\"]/form/div/span/input"));
        btnSearch.click();
        WebElement lnkResult = driver.findElement(By.linkText("Atlantic Height Adjustable Standing Desk Converter Large"));
        driver.quit();

    }
}