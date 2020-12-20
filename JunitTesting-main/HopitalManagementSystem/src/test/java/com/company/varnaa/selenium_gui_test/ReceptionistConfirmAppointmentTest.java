package com.company.varnaa.selenium_gui_test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReceptionistConfirmAppointmentTest {

    @Test
    public void startWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Going to the main page
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        //Clicking the receptionist login link
        WebElement receptionist_login= driver.findElement(By.linkText("receptionist login"));
        Thread.sleep(4000);
        receptionist_login.click();

        //Waiting for some time to load the page
        Thread.sleep(4000);

        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        username.sendKeys("marry");
        Thread.sleep(2000);
        password.sendKeys("test123");
        Thread.sleep(2000);
        //Click on the Sing in Button
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        Thread.sleep(3000);
        //Clicking on Appointments link
        WebElement view_appointments = driver.findElement(By.linkText("Appointments"));
        view_appointments.click();

        Thread.sleep(6000);

        WebElement confirm_appointment = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[5]/div/form/input"));
        confirm_appointment.click();

        //Enter the id to confirm appointment
        WebElement appointment_id = driver.findElement(By.id("appointment_id"));
        Thread.sleep(1000);
        appointment_id.sendKeys("30");
        Thread.sleep(3000);
        //Clicking on the Confirm Button
        WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
        Thread.sleep(2000);
        save.click();

        String actualUrl="http://localhost:8080/receptionist/receptionistAppointments";
        String expectedUrl= driver.getCurrentUrl();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed!!");
        } else {
            System.out.println("Test failed!!");
        }

    }
}
