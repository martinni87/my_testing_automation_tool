package com.selenium_java_example;

public class Test {
    public static void main(String[] args){
        // Initialize context driver
        WebDriverConfig context = new WebDriverConfig("Chrome", true);

        // Tasks with driver
        // Open a URL
        context.driver.get("https://katalon-demo-cura.herokuapp.com/\n");

        // Getting values from URL
        String currentURL = context.driver.getCurrentUrl();
        String webpageTitle = context.driver.getTitle();

        // Printing values
        System.out.println("Current URL: " + currentURL);
        System.out.println("Webpage title: " + webpageTitle);

        // Close driver or quit, in windows have the same behavior. In mac close() closes an instance but not the driver
        context.quit();
    }
}
