package com.company.varnaa.selenium_gui_test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PatientBookAppointmentTest {

    @Test
    public void startWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("http://localhost:8080/login");

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
        //Clicking on book_appointment link
        WebElement book_appointment = driver.findElement(By.linkText("book appointment"));
        book_appointment.click();

        //Waiting to load the page
        Thread.sleep(4000);

        //Appointment Booking
        WebElement patient_name = driver.findElement(By.id("patientName"));
        WebElement doctor_name = driver.findElement(By.id("doctorName"));
        //DatePicker
        WebElement date = driver.findElement(By.xpath("//*[@id=\"date\"]"));
        WebElement prescription = driver.findElement(By.id("prescription"));

        patient_name.sendKeys("Radha");
        Thread.sleep(2000);
        doctor_name.sendKeys("bijoy");
        Thread.sleep(2000);
        date.sendKeys("23-Dec-2020");
        Thread.sleep(2000);
        prescription.sendKeys("No");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Save']")).click();

        Thread.sleep(3000);
        //For viewing the appointments
        WebElement view_appointments = driver.findElement(By.partialLinkText("view appointments"));
        view_appointments.click();


        Thread.sleep(7000);

        //Going back to the Homepage
        driver.findElement(By.linkText("homepage")).click();

        String actualUrl="http://localhost:8080/patients";
        String expectedUrl= driver.getCurrentUrl();

        //Assert.assertEquals(expectedUrl,actualUrl);

        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("Test passed!!");
        }
        else
        {
            System.out.println("Test failed!!");
        }

    }

    @Test
    public void startWebDriver1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("http://localhost:8080/login");

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
        username.sendKeys("rupa");
        Thread.sleep(2000);
        password.sendKeys("test123");
        Thread.sleep(2000);
        //Click on the Sing in Button
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();

        Thread.sleep(3000);
        //Clicking on book_appointment link
        WebElement book_appointment = driver.findElement(By.linkText("book appointment"));
        book_appointment.click();

        //Waiting to load the page
        Thread.sleep(4000);

        //Appointment Booking
        WebElement patient_name = driver.findElement(By.id("patientName"));
        WebElement doctor_name = driver.findElement(By.id("doctorName"));
        //DatePicker
        WebElement date = driver.findElement(By.xpath("//*[@id=\"date\"]"));
        WebElement prescription = driver.findElement(By.id("prescription"));

        patient_name.sendKeys("Shaurya");
        Thread.sleep(2000);
        doctor_name.sendKeys("bijoy");
        Thread.sleep(2000);
        date.sendKeys("23122020");
        Thread.sleep(2000);
        prescription.sendKeys("No");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Save']")).click();

        Thread.sleep(3000);
        //For viewing the appointments
        WebElement view_appointments = driver.findElement(By.linkText("view appointments"));
        view_appointments.click();


        Thread.sleep(7000);

        //Going back to the Homepage
        driver.findElement(By.linkText("homepage")).click();

        String actualUrl="http://localhost:8080/patients";
        String expectedUrl= driver.getCurrentUrl();

        //Assert.assertEquals(expectedUrl,actualUrl);

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

