package practices.practice01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    // https://www.trendyol.com/ sitesine gidin
    // WebElement olarak arama kutusunu bulun ve "kolye" yazdırıp, aratın.


    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void trendyolTest() throws InterruptedException {
        driver.get("https://www.trendyol.com/");
        Thread.sleep(5000);
        // WebElement olarak arama kutusunu bulun ve "kolye" yazdırıp, aratın.
        WebElement searchBox =  driver.findElement(By.className("V8wbcUhU"));
        searchBox.sendKeys("kolye", Keys.ENTER);
        // Sayfa başlığını ve url'ini yazdırın
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println("title = " + title);
        System.out.println("url = " + url);
        // Title ve url'inin "kolye" kelimesini içerip içermediğini kontrol edin
        Assertions.assertTrue(title.contains("kolye"));
        Assertions.assertTrue(url.contains("kolye"));
        // Ana sayfaya geri dönün
        driver.navigate().back();
        // Sayfayı yenileyin
        driver.navigate().refresh();
        // Tarayıcıyı kapatın
        driver.close();

    }

}
