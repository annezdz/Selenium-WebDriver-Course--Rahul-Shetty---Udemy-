package dropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class E2E {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("Disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropDown);
        dropdown.selectByIndex(3);
        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
    }
}
