package com.selenium_java_example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.selenium_java_example.Main.print;

public class WebDriverConfig {
    // Drivers available
    public WebDriver driver;
    String startingMsg = ConsoleColors.GREEN + """
            ################ MARTIN'S AUTOMATION TOOL ################
            Welcome to Martin's Automation tool
            If something goes wrong please follow the error logs.
            In any case, check that the driver version in use is correct!
            Enjoy!
            """ + ConsoleColors.RESET;
    String endingMsg = ConsoleColors.GREEN + """
            -----------------------------------------------
            Thanks for using Martin's Automation Tool
            ################ TEST FINISHED ################
            """ + ConsoleColors.RESET;

    /**
     * @param driver could be "Chrome", "Firefox", or "Edge"
     */
    public WebDriverConfig(String driver) {
        print(this.startingMsg);
        switch (driver) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                this.driver = new ChromeDriver();
                break;
            case "Firefox":
                System.out.println("Pending Firefox configuration");
                break;
            case "Edge":
                System.out.println("Pending Edge configuration");
                break;
            default:
                System.out.println("No driver available");
        }
    }

    /**
     * @param driver    could be "Chrome", "Firefox", or "Edge"
     * @param incognito "incognito"
     */
    public WebDriverConfig(String driver, Boolean incognito) {
        print(this.startingMsg);
        switch (driver) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                if (incognito) {
                    options.addArguments("incognito");
                }
                options.addArguments("start-maximized");
                this.driver = new ChromeDriver(options);
                break;
            case "Firefox":
                System.out.println("Pending Firefox configuration");
                break;
            case "Edge":
                System.out.println("Pending Edge configuration");
                break;
            default:
                System.out.println("No driver available");
        }
    }

    public void quit() {
        print(this.endingMsg);
        this.driver.quit();
    }
}
