package driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverManager {
    public static ChromeDriver createChromeDriver() {
           System.setProperty("webdriver.chrome.path", "chromedriver.exe");
           return new ChromeDriver();

    }
}
