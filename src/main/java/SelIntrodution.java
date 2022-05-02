import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntrodution {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        System.setProperty("webdriver.edge.driver","src/main/resources/edgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
