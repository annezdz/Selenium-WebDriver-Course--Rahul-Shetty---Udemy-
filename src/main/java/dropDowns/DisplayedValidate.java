package dropDowns;

import com.google.common.base.Splitter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DisplayedValidate {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='GWL']")).click();
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(12) > div:nth-child(2) > div:nth-child(1) > div:nth-child(17) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(4) > button:nth-child(4)")).click();
        String result = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(result);

        Map<String,String> attributes = new HashMap<>();
        String[] pairs = result.split(";");
        for(int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            attributes.put(keyValue[0], keyValue[1]);
        }

        for(Map.Entry<String, String> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
            if(entry.getKey().equalsIgnoreCase("opacity")) {
                if(entry.getValue().equalsIgnoreCase("0.5")) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }

       // driver.findElement(By.id("Div1")).getAttribute("style").contains("");
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("Disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }
}
