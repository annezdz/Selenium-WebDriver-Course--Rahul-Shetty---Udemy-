package miscellaneous;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscellaneous {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //deleta todos cookies

        //deleta um cookie especifico
        driver.manage().deleteCookieNamed("blabla");
        driver.manage().deleteAllCookies();

        driver.get("https:google.com");

        //take screenshot

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/main/resources/screenshoots/teste.jpg"));
    }
}
