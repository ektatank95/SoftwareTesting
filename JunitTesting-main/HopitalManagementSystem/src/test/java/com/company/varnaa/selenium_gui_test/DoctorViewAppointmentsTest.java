package com.company.varnaa.selenium_gui_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DoctorViewAppointmentsTest {

    @Test
    public void startWebDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Going to the main page
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        //Clicking the doctor login link
        WebElement doctor_login= driver.findElement(By.linkText("doctor login"));
        Thread.sleep(4000);
        doctor_login.click();

        //Waiting for some time to load the page
        Thread.sleep(4000);

        //Fetching the username and password
        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        username.sendKeys("bijoy");
        Thread.sleep(2000);
        password.sendKeys("test123");
        Thread.sleep(2000);
        //Click on the Sing in Button
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        Thread.sleep(3000);

        //Clicking on Appointments link
        WebElement appointments = driver.findElement(By.linkText("Appointments"));
        appointments.click();

        Thread.sleep(7000);
        //Going back to the Homepage
        driver.findElement(By.linkText("homepage")).click();

        String actualUrl="http://localhost:8080/doctors";
        String expectedUrl= driver.getCurrentUrl();

        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("Test passed!!");
        }
        else
        {
            System.out.println("Test failed!!");
        }

    }
}
