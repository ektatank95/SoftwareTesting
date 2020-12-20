package com.company.varnaa.selenium_gui_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeLoginTest {

    @Test
    public void startWebDriver1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//button[text()='Sign in']"));

        username.sendKeys("ramesh");
        Thread.sleep(2000);
        password.sendKeys("test123");
        Thread.sleep(2000);
        login.click();

        String actualErrorMsg = driver.findElement(By.xpath("/html/body/div/form/div")).getText();;
        String expectedErrorMsg = "Bad credentials";

        //Assert.assertEquals(expectedUrl,actualUrl);

        if (actualErrorMsg.equalsIgnoreCase(expectedErrorMsg)) {
            System.out.println("Test passed!!");
        } else {
            System.out.println("Test failed!!");
        }
    }
}
