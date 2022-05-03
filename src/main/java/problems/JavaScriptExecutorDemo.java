package problems;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        int sum = 0;
        String[] totalAmount =driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");
        System.out.println(totalAmount[1].trim());
        List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']/table[@id='product']/tbody/tr/td[4]"));
        for (int i = 0; i < values.size(); i++) {
            sum+= Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        Assert.assertEquals((int) sum,Integer.parseInt(totalAmount[1].trim()));
    }
}
