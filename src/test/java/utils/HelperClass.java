package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.NoSuchElementException;

public class HelperClass {
    private static HelperClass helperClass;
    private static WebDriver driver;

    private HelperClass() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setUpDriver();
        }
        return driver;
    }

    // Method untuk menginisialisasi WebDriver
    public static void setUpDriver() {
        if (helperClass == null) {
            helperClass = new HelperClass();
        }
    }

    // Method untuk menutup WebDriver
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        helperClass = null;
    }

    // Method untuk membuka URL
    public static void openPage(String url) {
        getDriver().get(url);
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static boolean isServerRunning(String serverUrl) {
        try {
            URL url = new URL(serverUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
