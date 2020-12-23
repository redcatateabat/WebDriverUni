package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    private static FirefoxDriver browser;

    public static FirefoxDriver getBrowser(){

        if (browser == null) {
            WebDriverManager.firefoxdriver().setup();
            browser = new FirefoxDriver();
        }
        return browser;
    }


    /*private static ChromeDriver browser;

    public static ChromeDriver getBrowser(){
        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            browser = new ChromeDriver();
        }
        return browser;
    }*/
}
