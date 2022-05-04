package javaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsMapperWithSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rahulshettyacademy.com/seleniumPractise/#/offers");

        //List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr td:first-child"));

        //scan the name column with getText -> print the price of the rice
        String product = "Almond";
        boolean isFound = false;
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr td:first-child"));
            price = rows.stream().filter(s -> s.getText().contains(product))
                    .map(s -> getPriceVeggie(s))
                    .collect(Collectors.toList());

            price.forEach(s -> System.out.println(s));

            if(price.size() < 1) {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            } else {
                isFound = true;
            }
        } while (!isFound);

    }

    private static String getPriceVeggie(WebElement element) {
        String price =  element.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
}
