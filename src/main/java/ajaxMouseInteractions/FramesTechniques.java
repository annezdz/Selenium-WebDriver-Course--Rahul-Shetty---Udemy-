package ajaxMouseInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class FramesTechniques {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        //Quando temos apenas 1 frame podemos fazer dessa forma
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);

        //driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        WebElement origin = driver.findElement(By.id("draggable"));
        WebElement destiny = driver.findElement(By.cssSelector("#droppable"));
        origin.click();

        Actions actions = new Actions(driver);
        actions.dragAndDrop(origin,destiny).build().perform();
        driver.switchTo().defaultContent();
    }
}
