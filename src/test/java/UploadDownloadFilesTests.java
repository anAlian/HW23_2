import org.example.utils.MyFilesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class UploadDownloadFilesTests extends BaseTestClass{
    @Test
    public void uploadTest() throws IOException, InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "latest");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

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

        File file = MyFilesUtils.generateLoremFile();
        goToPart("upload");
        Thread.sleep(3000);
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        Thread.sleep(3000);
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), file.getName());

        goToPart("download");
        Assert.assertTrue(driver.findElement(By.linkText(file.getName())).isDisplayed());

        MyFilesUtils.clearFilesFolder();
    }

    @Test
    public void downloadTest() throws IOException, InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "latest");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

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

        File file = MyFilesUtils.generateLoremFile();
        goToPart("upload");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), file.getName());

        goToPart("download");
        driver.findElement(By.linkText(file.getName())).click();


        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("C:\\Users\\alifa\\Downloads", file.getName()));

        Assert.assertEquals(file.length(), file1.length());

        file1.deleteOnExit();

    }
}
