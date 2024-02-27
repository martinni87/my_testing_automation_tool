package PageObjects;

import PageElements.Button;
import settings.ConsoleColors;
import settings.WebDriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static PageElements.ByType.*;

public class WebFormPO {

    WebDriverContext context;
    String URL;
    WebElement formTitle;
    WebElement textInput;
    WebElement password;
    WebElement textArea;
    Button submitButton;

    String textData;
    String passData;
    String areaData;


    public WebFormPO(WebDriverContext context, String URL){
        this.context = context;
        this.URL = URL;
        this.textData = "";
        this.passData = "";
        this.areaData = "";
        this.initializeWebElements();
    }

    private void initializeWebElements() {
        this.context.driver.get(this.URL);
        this.formTitle = context.driver.findElement(By.xpath("//h1"));
        this.textInput = context.driver.findElement(By.id("my-text-id"));
        this.password  = context.driver.findElement(By.xpath("//*[@id='my-text-id']/../..//descendant::input[@type='password']"));
        this.textArea  = context.driver.findElement(By.xpath("//*[@id='my-text-id']/../..//descendant::*[@name='my-textarea']"));
        this.submitButton = new Button(context, XPATH, "//*[@type='submit']", 5000);
    }

    public void inputData(String data1, String data2, String data3){
        this.textData = data1;
        this.passData = data2;
        this.areaData = data3;
        this.textInput.sendKeys(this.textData);
        this.password.sendKeys(this.passData);
        this.textArea.sendKeys(this.areaData);
    }

    public void checkData() {
        boolean validation = true;
        String errorMsg = "Following assertions have failed:\n";

        if (!this.formTitle.getText().equals("Web form")) {
            validation = false;
            errorMsg += "Expected web form title should be 'Web form'\n";
        }
        if (!this.textInput.getAttribute("value").equals(this.textData)) {
            validation = false;
            errorMsg += "Expected text should be " + this.textData + "\n";
        }
        if (!this.password.getAttribute("value").equals(this.passData)) {
            validation = false;
            errorMsg += "Expected pass should be " + this.passData + "\n";
        }
        if (!this.textArea.getAttribute("value").equals(this.areaData)) {
            validation = false;
            errorMsg += "Expected text area should be " + this.areaData + "\n";
        }
        Assert.assertTrue(validation, ConsoleColors.GREEN + errorMsg + ConsoleColors.RESET);
    }

    public void submitData(){
        Assert.assertTrue(this.submitButton.isDisplayed());
        this.submitButton.click();
        FormSubmittedPO submitted = new FormSubmittedPO(this.context);
        submitted.checkPageTitle("Form submitted");
        System.out.println("Page title: " + submitted.title.getText());
        System.out.println("Current url: " + context.driver.getCurrentUrl());
        System.out.println("Site title: " + context.driver.getTitle());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
