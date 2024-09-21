package practices.practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class P01 extends TestBase {



    @Test
    void test01() {

        //Ebay web sayfasina git "https://www.ebay.com"
        driver.get("https://www.ebay.com");

        //Sayfanın Title testini yap, title ekrana yazdır
        System.out.println("Sayfa title: = " + driver.getTitle());

        //Sayfa Title ının "Electronics, Cars, Fashion, Collectibles & More | eBay" olduğunu doğrula
        String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

        //Sayfanın URL testini yap. url ekrana yazdır

        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = driver.getCurrentUrl();
            //Sayfa Url ini doğrula.
        //        Assertions.assertEquals(expectedUrl, actualUrl);
        //
        System.out.println("actualUrl = " + actualUrl);

        //yöntem 2
        Assertions.assertTrue(actualUrl.contains("ebay.com"));

        //Sayfanın kaynak kodlarını ekrana yazdır
        System.out.println("Sayfanın Kaynak Kodları = " + driver.getPageSource());


    }
}
