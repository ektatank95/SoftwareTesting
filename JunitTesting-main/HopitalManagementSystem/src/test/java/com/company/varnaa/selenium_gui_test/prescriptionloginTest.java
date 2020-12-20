package com.company.varnaa.selenium;



        import org.junit.Assert;
        import org.junit.jupiter.api.Test;
        import org.mockito.internal.matchers.Null;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.edge.EdgeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import java.util.List;

        import static java.lang.Thread.sleep;


public class prescriptionloginTest {

    @Test
    public void startWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        //driver.get("http://localhost:8088/login");
        driver.manage().window().maximize();

        WebElement alink =  driver.findElement(By.partialLinkText("receptionist"));
        alink.click();

        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//button[text()='Sign in']"));

        username.sendKeys("marry");
        password.sendKeys("test123");
        login.click();

        Thread.sleep(3000);

        WebElement alink1 =  driver.findElement(By.partialLinkText("Appointments"));
        alink1.click();

        Thread.sleep(3000);
        WebElement mytable = driver.findElement(By.xpath("/html/body/table/tbody"));
        //List rows = driver.findElements(By.xpath (".//table/tbody/tr/td[1]"));
        List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
        System.out.println("Total No of rows are : " + rows_table.size());

        for (int row = 1; row < rows_table.size(); row++) {
            //To locate columns(cells) of that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            //To calculate no of columns (cells). In that specific row.
            int columns_count = Columns_row.size();
            System.out.println("Number of cells In Row " + row + " are " + columns_count);

            String celtext1 = Columns_row.get(0).getText();
            String celtext2 = Columns_row.get(4).getText();

            if(celtext2.equals("")){
                WebElement confirm = driver.findElement(By.xpath("//input[@type='submit' and @value='click to confirm']"));
                confirm.click();

                Thread.sleep(3000);

                WebElement textField = driver.findElement(By.xpath("//input[@type='text']"));
                textField.sendKeys(celtext1);

                Thread.sleep(3000);

                WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
                save.click();
            }
            //Loop will execute till the last cell of that specific row.
//            for (int column = 0; column < columns_count; column++) {
//                // To retrieve text from that specific cell.
//                String celtext = Columns_row.get(column).getText();
//                System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
//            }
            System.out.println("-------------------------------------------------- ");
        }


//        WebElement confirm = driver.findElement(By.xpath("//input[@type='submit' and @value='click to confirm']"));
//        confirm.click();

//        String actualUrl = "http://localhost:8088/showPostLogin";
//        String expectedUrl = driver.getCurrentUrl();
//
//        //Assert.assertEquals(expectedUrl,actualUrl);
//
//        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
//            System.out.println("Test passed");
//        } else {
//            System.out.println("Test failed");
//        }

    }
}