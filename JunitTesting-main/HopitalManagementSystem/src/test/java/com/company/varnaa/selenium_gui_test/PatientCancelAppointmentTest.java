package com.company.varnaa.selenium_gui_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PatientCancelAppointmentTest {

    @Test
    public void startWebDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Going to the main page
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        //Clicking the patient login link
        WebElement patient_login= driver.findElement(By.linkText("patient login"));
        Thread.sleep(4000);
        patient_login.click();

        //Waiting for some time to load the page
        Thread.sleep(4000);

        //Fetching the username and password
        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        username.sendKeys("varnaa");
        Thread.sleep(2000);
        password.sendKeys("test123");
        Thread.sleep(2000);
        //Click on the Sing in Button
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        Thread.sleep(3000);

        //Clicking on cancel appointment link
        WebElement cancel_appointment = driver.findElement(By.linkText("cancel appointment"));
        cancel_appointment.click();

        //Waiting to load the page
        Thread.sleep(4000);

        //Entering the Appointment ID to cancel
        WebElement Appointment = driver.findElement(By.id("appointment_id"));
        Thread.sleep(1000);
        Appointment.sendKeys("27");
        Thread.sleep(3000);
        //Clicking on the Confirm Button
        WebElement confirm = driver.findElement(By.xpath("//button[text()='Confirm']"));
        Thread.sleep(2000);
        confirm.click();

        String actualUrl="http://localhost:8080/patients";
        String expectedUrl= driver.getCurrentUrl();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed!!");
        } else {
            System.out.println("Test failed!!");
        }

    }
}
