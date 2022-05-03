package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class HandlingCalendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");

        // 14 de maio
        LocalDateTime date = LocalDateTime.now().plusMonths(1);
        String day = String.valueOf(date.getDayOfMonth());

        String month = String.valueOf(date.getMonth());
        String year = String.valueOf(date.getYear());

        // capitalize first letter
        String output = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
        System.out.println(day);
        System.out.println(output);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#travel_date")).click();
        String[] monthYear = driver.findElement(By.cssSelector("table[class=' table-condensed'] [class='datepicker-switch']"))
                .getText().split(" ");
//        boolean monthAndYear = driver.findElement(By.cssSelector("table[class=' table-condensed'] [class='datepicker-switch']"))
//                .getText().contains(output);

        while ((!monthYear[0].equals(output) && monthYear[1].equals(year))) {
            driver.findElement(By.cssSelector("table[class=' table-condensed'] th[class='next']")).click();
            break;
        }
        //grab common attribute // put into list and iterate

        List<WebElement> days = driver.findElements(By.className("day"));
        for (int i = 0; i < days.size(); i++) {
            String text = days.get(i).getText();
            if(text.equalsIgnoreCase(day)) {
                days.get(i).click();
                break;
            }
        }
    }
}
