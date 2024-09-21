package day13_seleniumwaits_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_StaleElementException extends TestBase {

    /*
    StaleElementException nasil alinir?
    ==> Bir sayfadaki bir webelementi locate ettikten ve bunu bir webelement seklinde sakladiktan sonra
    o sayfada yenileme yapan herhangi bir islem(navigate.refresh(), back(), forward()...) yapildiginda
    locateini aldigimiz webelementi tekrar kullanmak istersek bu exceptionu aliriz

    Bu hatayi nasil handle ederiz?
    => Bu exceptionu handle etmek icin webelementi navigate.refresh(), back(), forward() ...
    methodlari kullanildiginda tekrar locate etmeliyiz
     */

    @Test
    void test01() {

        driver.get("https://www.techproeducation.com/");

        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));

        driver.navigate().refresh();

        driver.findElement(By.id("searchHeaderInput"));

        searchBox = driver.findElement(By.id("searchHeaderInput"));

        searchBox.sendKeys("CAYLAR TAZE");

    }

    /*
    >>> ElementClickInterceptedException: Bir web elementin başka bir web element (pop-up, reklam, cookies) tarafından
    engellenmesi durumunda bu hatayı alırız. (elemente click esnasında başka bir elementin onun üstünü örtmesi araya başka şeylerin girmesi)

    >>> WebDriverException: Web driver ile ilgili işlemlerde internet yoksa bu hatayı alırız. (kurulum, uyumsuzluk hatası)

    >>> InvalidArgumentException :  Eger bir methoda geçersiz argüman girişi olursa bu hatayı alırız.
     */

    @Test
    void test02() {
        driver.get("1");
    }
}
