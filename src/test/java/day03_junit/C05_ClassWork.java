package day03_junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {

//    Amazon soyfasina gidelim. https://www.amazon.com/
//    Sayfanin konumunu ve boyutlarini yazdirin
//    Sayfayi simge durumuna getirin
//    simge durumunda 3 saniye bekleyip sayfayi maximize yapin
//    Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
//    Sayfayi fullscreen yapin
//    Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
//    Sayfayi kapatin


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void test01() throws InterruptedException {
        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("sayfanın konumu:" + driver.manage().window().getPosition());
        System.out.println("sayfanın boyutu:" + driver.manage().window().getSize());

        //    Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //    simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //    Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("sayfanın konumu:" + driver.manage().window().getPosition());
        System.out.println("sayfanın boyutu:" + driver.manage().window().getSize());

        //    Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //    Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("sayfanın konumu:" + driver.manage().window().getPosition());
        System.out.println("sayfanın boyutu:" + driver.manage().window().getSize());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
