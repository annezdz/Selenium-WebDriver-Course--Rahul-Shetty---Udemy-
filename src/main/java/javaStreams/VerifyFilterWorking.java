package javaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class VerifyFilterWorking {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String search = "Rice";
        driver.get("http://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("#search-field")).sendKeys(search);
        List<WebElement> veggies = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
        //5 results
        List<WebElement> filteredList = veggies.stream().filter(s -> s.getText().contains(search)).collect(Collectors.toList());
        //1 result
        Assert.assertEquals(veggies.size(), filteredList.size());
    }
}
