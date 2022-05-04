package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //broken URL
        // step 1v- IS to get all urls tied up to the links using Selenium
        //Java methods will call URl and gets you the status code
        // if status code > 400 then that url is not working -> link which tied to url is broken
        //a[href*="soapui"]
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        int responseCode = 0;

        List<WebElement> links = driver.findElements(By.cssSelector("#gf-BIG a"));

        SoftAssert softAssert = new SoftAssert();

        for (WebElement link : links) {
            String url1 = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url1).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            softAssert.assertTrue(responseCode < 400, "The link with text " + link.getText() + " is broken! - " + responseCode );
//            if(responseCode >= 400) {
//                System.out.println("The link with text " + link.getText() + " is broken! - " + responseCode);
//                Assert.assertTrue(false);
//            }
        }
        softAssert.assertAll();

        String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(responseCode);






    }
}
