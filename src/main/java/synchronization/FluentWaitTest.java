package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("div[id='start'] button")).click();

        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);


        WebElement element = driver.findElement(By.cssSelector("div[id='finish'] h4"));

        WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if(element.isDisplayed()) {
                    return element;
                } else {
                    return null;
                }
            }
        });
        System.out.println(element.isDisplayed());

    }
}
