package day13_seleniumwaits_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_NoSuchElementExceptions extends TestBase {

 /*
    Sayfadaki bir webelementi locate ettigmiz halde NoSuchElement EXCEPTION aliyorsak;

    1) Wait / Syncronization problemi olabilir ==> ImplicitlyWait süresini artirabiliriz.
    2) Locate kontrol edilmelidir
    3) Webelment iframe icinde olup olmadigina bakariz
    4) Driver webelementi göremiyor olabilir, dolayisiyla actions class ile scroll yapip webelementin görünür
    olmasini saglariz
    5) Bir linke tiklandiginda yeni bir sayfa yada sekme aciliyorysa eger driveri bu yeni acilan sayfaya gecirmeden
      o sayfadaki bir webelementi locate ettigimizde bu hatayi aliriz
     */


    @Test
    void test01() {
        driver.get("https://www.techproeducation.com/");
       WebElement searchBox = driver.findElement(By.id(" searchHeaderInput"));
       searchBox.sendKeys("Selenium");

    }
}
