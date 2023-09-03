import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestTest {
    @Test
    public void Test() throws InterruptedException, MalformedURLException {

//        WebDriver driver = new ChromeDriver();

        /////////////////////////////////////////
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "latest");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
//            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", false);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        /////////////////////////////////////////

        driver.manage().window().maximize();

        driver.get("https://www.google.com/?hl=en-US");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept all']"))).click();
        driver.findElement(By.name("q")).sendKeys("hillel it school");

        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        int i = 0;
        for (WebElement element : elements) {
            if (!element.getText().toLowerCase().contains("hillel it school")) {
                System.out.println("Element with number " + i + " " + element.getText() + " doesn't containe \"hillel it school\"");
            }
            i++;
        }
        driver.quit();
    }
    @Test
    public void Test2() throws InterruptedException, MalformedURLException {

//        WebDriver driver = new ChromeDriver();

        /////////////////////////////////////////
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "114.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
//            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", false);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        /////////////////////////////////////////

        driver.manage().window().maximize();

        driver.get("https://www.google.com/?hl=en-US");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept all']"))).click();
        driver.findElement(By.name("q")).sendKeys("hillel it school");

        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        int i = 0;
        for (WebElement element : elements) {
            if (!element.getText().toLowerCase().contains("Linkedin")) {
                System.out.println("Element with number " + i + " " + element.getText() + " doesn't containe \"Linkedin\"");
            }
            i++;
        }
        driver.quit();
    }


}
