package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver wd = null;

    public static WebDriver getDriver() {
        if (wd == null) {
            System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
            wd = new ChromeDriver();
        }
        return wd;
    }

    public static void start() {
        getDriver();
        wd.manage().deleteAllCookies();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    public static void quit() {
        wd.quit();
    }

}
