package day02_drivermethods_implicitlywait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethods {

    public static void main(String[] args) {
        // Go to TechproEducation page https://www.techproeducation.com/
        // Print the page title
        // Test if the page title contains “IT”
        // Print the page address (url)
        // Test that the page url contains “education”.
        // Print the page handle value
        // Test whether the word "IT Programs" appears in the page HTML codes
        // Close the page.

        // TechproEducation sayfasina gidelim.  https://www.techproeducation.com/
        // Sayfa basligini(title) yazdirin
        // Sayfa basliginin “IT” icerdigini test edin
        // Sayfa adresini(url) yazdirin
        // Sayfa url’inin “education” icerdigini test edin.
        // Sayfa handle degerini yazdirin
        // Sayfa HTML kodlarinda “IT Programs” kelimesi gectigini test edin
        // Sayfayi kapatin.


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // TechproEducation sayfasina gidelim.  https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");

        // Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        // Sayfa basliginin “IT” icerdigini test edin
        if (actualTitle.contains("IT")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        // Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);


        // Sayfa url’inin “education” icerdigini test edin.
        if (actualUrl.contains("Education")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        // Sayfa handle degerini yazdirin
        String windowHandle = driver.getWindowHandle();
        System.out.println("windowHandle = " + windowHandle);

        // Sayfa HTML kodlarinda “IT Programs” kelimesi gectigini test edin
        String pageSource = driver.getPageSource();
        if (pageSource.contains("IT Programs")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        // Sayfayi kapatin.
        driver.close(); //Driverin en son bulundugu sayfayı kapatır, oturumu sonlandırmaz.
        //driver.quit(); >> birden fazla açılan pencere var ise hepsini kapatır, oturumu da sonlandırır.


    }

}
