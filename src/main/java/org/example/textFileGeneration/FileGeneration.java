package org.example.textFileGeneration;
import org.example.BasePage;
import org.example.driver.WebDriverHolder;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FileGeneration extends BasePage {
    @FindBy (id="create")
    private WebElement buttonGenerateFile;

    @FindBy (id="link-to-download")
    private WebElement buttonDownload;

    @FindBy (id="textbox")
    private WebElement textBox;

    public FileGeneration pasteText (String text){
        textBox.sendKeys(text);
        return this;
    }
    public FileGeneration generateFile (){
        buttonGenerateFile.click();
        return this;
    }
    public FileGeneration downloadFile (){
        buttonDownload.click();
        return this;
    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }
    public void goToUrl() {
        goToUrl(PropertiesReader.getInstance().getProperties("app.easyselenium.url"));
    }

   public FileGeneration fileGeneration (String text){
        FileGeneration fileGeneration = new FileGeneration()
                .pasteText(text)
                .generateFile()
                .downloadFile();
        return new FileGeneration();
    }
}
