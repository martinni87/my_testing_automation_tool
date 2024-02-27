package PageElements;

import settings.WebDriverContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Button {

    WebDriverContext context;
    WebElement element;
    Duration timeout;
    ByType type;
    String byTypeValue;

    public Button (WebDriverContext context, ByType type, String byTypeValue, int millisTimeout){
        this.context = context;
        this.timeout = Duration.ofMillis(millisTimeout);
        this.type = type;
        this.byTypeValue = byTypeValue;
        switch (type) {
            case XPATH:
                this.ByXPATH(byTypeValue);
                break;
            case ID:
                this.ByID(byTypeValue);
                break;
            case CSS:
                this.ByCSS(byTypeValue);
                break;
        }
    }

    private void ByXPATH (String xpath) {
        this.element = this.context.driver.findElement(By.xpath(xpath));
    }
    private void ByID (String id) {
        this.element = this.context.driver.findElement(By.id(id));
    }
    private void ByCSS (String css) {
        this.element = this.context.driver.findElement(By.cssSelector(css));
    }

    public void click() {
        if (this.isDisplayed()) {
            new WebDriverWait(context.driver, timeout).until(ExpectedConditions.elementToBeClickable(this.element));
            this.element.click();
        }
        else {
            System.out.println("Button is not displayed or is not clickable.");
        }
    }

    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    public Point getLocation() {
        return this.element.getLocation();
    }
}
