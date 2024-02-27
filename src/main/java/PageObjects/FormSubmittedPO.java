package PageObjects;

import settings.WebDriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FormSubmittedPO {

    WebDriverContext context;
    WebElement title;

    public FormSubmittedPO(WebDriverContext context) {
        this.context = context;
        this.title = this.context.driver.findElement(By.xpath("//h1"));
    }

    public void checkPageTitle (String expected) {
        Assert.assertEquals(this.title.getText(), expected);
    }
}
