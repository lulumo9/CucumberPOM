package utilities;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;

    //Constructor
    public BaseClass() {

        properties = new Properties();
        {
            try {
                //Loading the config properties file
                properties.load(new FileInputStream("C:\\Users\\Luisa_Fernanda_Munoz\\IdeaProjects\\CucumberPOM\\src\\test\\java\\utilities\\config.properties"));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

        public static void driverInitialization()
        {
            String browserName = properties.getProperty("browser");

            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriverChrome"));
                driver = new ChromeDriver();
            } else if (browserName.equals("firefox")) {
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriverFirefox"));
                driver = new FirefoxDriver();
            }

            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); /*I am giving time to the URL to load*/
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.get(properties.getProperty("webSiteUrl"));
        }
    }
