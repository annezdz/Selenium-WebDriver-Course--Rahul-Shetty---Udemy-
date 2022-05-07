package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class RelativeLocators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement label = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(label)).click();

        WebElement iceCream =  driver.findElement(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();

        WebElement element = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        System.out.println(driver.findElement(with(By.tagName("input")).toRightOf(element)).getText());
    }
}
