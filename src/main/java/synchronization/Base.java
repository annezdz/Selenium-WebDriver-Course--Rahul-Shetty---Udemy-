package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {

   // public static WebDriver driver = new ChromeDriver();
    //String[] veggies = {"Cucumber","Brocolli","Beetroot"};

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String[] veggies = {"Cucumber","Brocolli","Beetroot"};
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/");
        addItens(driver, veggies);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //explicit wait

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public static void addItens(WebDriver driver, String[] items) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String veggieName = name[0].trim();
            //format it to get actual vegetable name
            //check wheter name you extracted is present in arrayList or not
            //convert array into array list for easy search
            List list = Arrays.asList(items);
            int count = 0;
            if(list.contains(veggieName)){
                count++;
                //Click On Add to Cart
                driver.findElements(By.xpath("//div[@class='product-action]/button")).get(i).click();
                if(items.length == count) {
                    break;
                }
            }
        }
    }
}
