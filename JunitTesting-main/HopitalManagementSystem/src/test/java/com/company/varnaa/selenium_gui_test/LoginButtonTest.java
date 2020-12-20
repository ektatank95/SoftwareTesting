package com.company.varnaa.selenium_gui_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginButtonTest {

    @Test
    public void startWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.xpath("//button[text()='Sign in']"));

        username.sendKeys("varnaa");
        Thread.sleep(2000);
        password.sendKeys("test123");
        Thread.sleep(2000);
        login.click();

        String actualUrl="http://localhost:8080/showPostLogin";
        String expectedUrl= driver.getCurrentUrl();

        //Assert.assertEquals(expectedUrl,actualUrl);

        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test failed");
        }
    }

}
