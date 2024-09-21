package practices.practice01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

    //   ChromeDriver kullanarak, facebook sayfasina gidin
    //   sayfa basliginin (title) "Facebook"icerdigini dogrulayin,
    //   Sayfa URL'inin "facebook"kelimesi icerdigini dogrulayin,
    //   https://testcenter.techproeducation.com/ sayfasina gidin.
    //   Sayfa basliginin "Automation Engineer"icerdigini dogrulayin.
    //   Sayfa URL'inin "techproeducation"kelimesi icerdigini dogrulayin,
    //   Tekrar "facebook"sayfasina donun
    //   Geri döndüğünüzü doğrulayin.
    //   Sayfayi kapatin

    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void test01() {
        //ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://www.facebook.com/");
        //sayfa basliginin (title) "Facebook"icerdigini dogrulayin,
        Assertions.assertTrue(driver.getTitle().contains("Facebook"));
        //Sayfa URL'inin "facebook"kelimesi icerdigini dogrulayin
        Assertions.assertTrue(driver.getCurrentUrl().contains("facebook"));
        //https://testcenter.techproeducation.com/ sayfasina gidin.
        driver.get("https://testcenter.techproeducation.com/");
        //Sayfa basliginin "Automation Engineer"icerdigini dogrulayin.
        Assertions.assertTrue(driver.getTitle().contains("Automation Engineer"));
        //   Sayfa URL'inin "techproeducation"kelimesi icerdigini dogrulayin,
        Assertions.assertTrue(driver.getCurrentUrl().contains("techproeducation"));
        //   Tekrar "facebook"sayfasina donun
        driver.navigate().back();
        //   Geri döndüğünüzü doğrulayin.
        Assertions.assertEquals("https://www.facebook.com/", driver.getCurrentUrl());
        driver.close();

    }
}
