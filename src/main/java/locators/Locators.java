package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static String message;

    public static void main(String[] args) throws InterruptedException {

        //implicit wait - 2 seconds time out
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
       // System.out.println(errorMessage);
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Anne");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("annezdz@otmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("annezdz@hotmail.com");
        driver.findElement(By.xpath("//form/input[@placeholder=\"Phone Number\"]")).sendKeys("(47)991069919");
        driver.findElement(By.xpath("//button[@class=\"reset-pwd-btn\"]")).click();
        message = driver.findElement(By.cssSelector("form p")).getText();
       // System.out.println(message);
        String pass = extractPassword();
       // System.out.println(pass);
        driver.findElement(By.cssSelector("div button[class*='to-login']")).click();
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pass);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

    }

    public static String extractPassword() {
        String[] passArray = message.split("'");
        String[] password = passArray[1].split("'");
        return password[0];
    }
}
