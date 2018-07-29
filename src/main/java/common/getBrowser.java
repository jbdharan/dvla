package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getBrowser {

    public WebDriver getChromeDriver() throws Exception {
           WebDriver driver = new ChromeDriver();

        return driver;
    }
}
