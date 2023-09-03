import org.example.driver.WebDriverHolder;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeClass() {

        driver = WebDriverHolder.getInstance().getDriver();
    }

    @AfterSuite
    public void afterClass() {
        WebDriverHolder.getInstance().driverQuit();
    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() {
        goToUrl(PropertiesReader.getInstance().getProperties("app.base.url"));
    }

    public void goToPart(String part) {
        goToUrl(PropertiesReader.getInstance().getProperties("app.base.url") + part);
    }
}
