package miscellaneous;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;

public class HandlingHttps {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        FirefoxOptions options1 = new FirefoxOptions();
//        options1.setAcceptInsecureCerts(true);
        options.setAcceptInsecureCerts(true);
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy",proxy);

        //proxy.
        //add extensions
        //options.addExtensions("")

        //block pop0up windows
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
