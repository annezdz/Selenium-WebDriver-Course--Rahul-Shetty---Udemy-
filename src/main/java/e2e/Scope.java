package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) {

        //give me the count of links on the page  -- //a
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //give me the count of links on the footer  -- //a

        System.out.println(driver.findElements(By.cssSelector("#gf-BIG a")).size());

        //3 - give me the count of links on the footer on left

        WebElement columnsLeft = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
        int linksLeft = columnsLeft.findElements(By.tagName("a")).size();
        System.out.println(columnsLeft.findElements(By.tagName("a")).size());

        //4 - click on each link in the column and check if the pages are opening
        for(int i = 0; i < linksLeft; i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnsLeft.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }
        //Open all the tabs
        Set<String> list = driver.getWindowHandles();
        Iterator<String> it = list.iterator();
        //Print the title of all tabs

        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
