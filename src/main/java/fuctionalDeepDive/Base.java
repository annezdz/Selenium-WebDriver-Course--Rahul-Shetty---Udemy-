package fuctionalDeepDive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String[] veggies = {"Cucumber","Brocolli","Beetroot"};

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String veggieName = name[0].trim();
            //format it to get actual vegetable name
            //check wheter name you extracted is present in arrayList or not
            //convert array into array list for easy search
            List list = Arrays.asList(veggies);

            int count = 0;
            if(list.contains(veggieName)){
                count++;
                //Click On Add to Cart
                driver.findElements(By.xpath("//div[@class='product-action]/button")).get(i).click();
                if(veggies.length == count) {
                    break;
                }
            }
        }

    }
}
