package TestSets;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.WebFormPO;
import settings.WebDriverContext;

import static settings.Utils.getData;

public class TestSet1 {

    WebDriverContext context;

    @BeforeTest
    public void beforeTest() {
        this.context = new WebDriverContext("Chrome", true);
    }

    @Test
    public void TestCase1() {
        // Initialize page object with context and explicit URL website.
        WebFormPO webForm = new WebFormPO(this.context, getData("datas.json", "URL_starting"));
        webForm.inputData("Single line text", "Password123", "Area text");
        webForm.checkData();
        webForm.submitData();
    }

    @AfterTest
    public void tearDown(){
        // Close driver or quit, in windows have the same behavior. In mac close() closes an instance but not the driver
        context.quit();
    }
}



//// OLD METHODS DEPRECATED

//    @Test
//    public void test1(){
//        context.driver.get("https://katalon-demo-cura.herokuapp.com/");
//
//        // Getting values from URL
//        String currentURL = context.driver.getCurrentUrl();
//        String webpageTitle = context.driver.getTitle();
//
//        // Printing values
//        System.out.println("Current URL: " + currentURL);
//        System.out.println("Webpage title: " + webpageTitle);
//    }
