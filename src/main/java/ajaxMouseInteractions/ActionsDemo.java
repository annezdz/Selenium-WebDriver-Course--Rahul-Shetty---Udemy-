package ajaxMouseInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br/");
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox")))
                .click().keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .build().perform();

        actions.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox")))
                .click().keyDown(Keys.SHIFT)
                .sendKeys(" anne")
                .build().perform();

        //Moves to  specific element
        WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(element).build().perform();

        actions.moveToElement(element).contextClick().build().perform();

        //Drag and drop

    }
}
