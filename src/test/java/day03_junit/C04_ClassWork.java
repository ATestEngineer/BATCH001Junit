package day03_junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ClassWork {


//  Youtube ana sayfasina gidelim . https://www.youtube.com/
//  Amazon soyfasina gidelim. https://www.amazon.com/
//  Tekrar YouTube’sayfasina donelim
//  Yeniden Amazon sayfasina gidelim
//  Sayfayi Refresh(yenile) yapalim
//  Sayfayi kapatalim / Tum sayfalari kapatalim

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void naviagetMethodsTest() {
        //  Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");

        //  Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //  Tekrar YouTube’sayfasina donelim
        driver.navigate().back();

        //  Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        //  Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        //  Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();

    }
}
