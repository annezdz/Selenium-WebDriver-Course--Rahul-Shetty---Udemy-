package javaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSortedWithStreams {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //capture text of all webelements into a new list(original)
        //sort in the original list of step 3 -> sorted list
        //compare original list x sorted list

        driver.get("http://rahulshettyacademy.com/seleniumPractise/#/offers");
        //click on column
        driver.findElement(By.cssSelector("th:nth-child(1)")).click();
        //capture all webelements into a list
        List<WebElement> productsName = driver.findElements(By.cssSelector("tbody tr td:first-child"));

        //capture text of all webelements into a new list(original)
        List<String> originaList = productsName.stream()
                .map(s -> s.getText())
                .collect(Collectors.toList());

        //sort in the original list of step 3 -> sorted list
        List<String> sortedList = originaList.stream().sorted().collect(Collectors.toList());

        //compare original list x sorted list
        Assert.assertTrue(originaList.equals(sortedList));

//        for(String name : productsName1) {
//            System.out.println(name);
        }
    }

