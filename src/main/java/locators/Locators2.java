package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {

        String username = "rahul";
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
       // System.setProperty("webdriver.edge.driver","src/main/resources/edgedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(username);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String validateText = driver.findElement(By.cssSelector("div p")).getText();
        System.out.println(validateText);
        Assert.assertEquals(validateText,"You are successfully logged in.");
        String message = driver.findElement(By.cssSelector("div[class=\"login-container\"] h2")).getText();
        Assert.assertEquals(message,"Hello " + username +",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
    }


}
