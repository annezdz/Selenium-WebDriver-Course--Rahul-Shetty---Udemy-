package selenium4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InvokingMultipleWindowsAndTabsSelenium4 {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://rahulshettyacademy.com/angularpractice/");

        //Switching Window
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles =  driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.navigate().to("http://rahulshettyacademy.com/");
        List<WebElement> links = driver.findElements(By.cssSelector("a[href*='courses.rahulshettyacademy.com/p']"));
        String firstCourse = links.get(1).getText();
        System.out.println(firstCourse);
        driver.switchTo().window(parentId);
        WebElement name = driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']"));
        name.sendKeys(firstCourse);

        //Screenshot

        File file =name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/main/resources/screenshoots/1.jpg"));

        //Get height & Width

        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());


        //
    }
}
