package practices.practice01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class P04 {

    //amazon sitesine gidin
    //"city bike" ifadesini search et.
    //amazonda görüntülenen ilgili sonuçların yazısını yazdırın
    //arama sonuc sayısını konsola yazdırın
    //sonra karşınıza çıkan ilk resme tıklayın.

    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void test01() {
        //amazon sitesine gidin
        driver.get("https://www.amazon.com/");

        //"city bike" ifadesini search et.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        //amazonda görüntülenen ilgili sonuçların yazısını yazdırın
        List<WebElement> searchResultText = driver.findElements(By.className("sg-col-inner"));
        System.out.println("arama sonucundaki yazı : = " + searchResultText.get(0).getText()); //0. İndexteki yazıyı bana getir.

        //arama sonuc sayısını konsola yazdırın
        String[] numberOfResult = searchResultText.get(0).getText().split(" ");
        System.out.println("sonuc sayısı : " + numberOfResult[2]);

        //sonra karşınıza çıkan ilk resme tıklayın. 







        



    }
}
