package dropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class HandlingCalendarUI {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='GWL']")).click();
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(12) > div:nth-child(2) > div:nth-child(1) > div:nth-child(17) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(4) > button:nth-child(4)")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isDisplayed());
        System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isDisplayed());

    }
}
