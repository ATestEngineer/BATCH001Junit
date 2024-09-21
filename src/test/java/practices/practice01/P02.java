package practices.practice01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {

    //https://stackoverflow.com/ sitesine gidin
    //Sitenin sayfa başlığını ve url'ini yazdırın
    //Title ve url'inin "Stack" kelimesini içerip içermediğini kontrol edin
    // https://www.amazon.com/"sitesine gidin
    //Sitenin sayfa başlığını alın ve "Amazon" kelimesini içerip içermediğini test edin
    //Bir önceki web sayfasına geri dönün
    //Sayfayı yenileyin
    //Bir sonraki sayfaya tekrar gidin
    //Sayfayı kapatın
    //-------------------------------------------------------------------------------
    //Go to https://stackoverflow.com/
    //Print the page title and url of the site
    //Check if the title and url contain the word "Stack"
    //Go to https://www.trendyol.com/
    //Take the page title of the site and test if it contains the word "Site"
    //Go back to the previous web page
    //Refresh the page
    //Go to the next page again
    //Close the page

    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void test01() {
        //https://stackoverflow.com/ sitesine gidin
        driver.get("https://stackoverflow.com/");
        System.out.println("sayfa başlığı " + driver.getTitle());
        System.out.println("sayfa url'i = " + driver.getCurrentUrl());
        //Title ve url'inin "Stack" kelimesini içerip içermediğini kontrol edin
        Assertions.assertTrue(driver.getTitle().contains("Stack"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("stack"));
        driver.get("https://www.amazon.com/");
        //Sitenin sayfa başlığını alın ve "Amazon" kelimesini içerip içermediğini test edin
        //negatif senaryo ile test edildi
        Assertions.assertFalse(driver.getTitle().contains("Stack"));
        //Bir önceki web sayfasına geri dönün
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.quit();
    }
}
