package dropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class UpdatedDropdown {
    public static void main(String[] args) {

        int count = 1;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        do {
            count++;
            driver.findElement(By.id("hrefIncAdt")).click();

        } while (count < 5);
        driver.findElement(By.id("btnclosepaxoption")).click();
        String passengers = driver.findElement(By.xpath("//div[@id=\"divpaxinfo\"]")).getText();
        String total = passengers.split(" ")[0];
        Assert.assertEquals(total,String.valueOf(count));
    }
}
