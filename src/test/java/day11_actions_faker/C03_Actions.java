package day11_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {

    /*
    Sayfadaki bir webelementi locate ettigmiz halde NoSuchElement EXCEPTION aliyorsak;

    1) Wait / Syncronization problemi olabilir ==> ImplicitlyWait süresini artirabiliriz.
    2) Locate kontrol edilmelidir
    3) Webelment iframe icinde olup olmadigina bakariz
    4) Driver webelementi göremiyor olabilir, dolayisiyla actions class ile scroll yapip webelementin görünür
    olmasini saglariz
     */


    @Test
    void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com/");

        //Sayfayı istediğimiz bir miktar aşağıya doğru scroll yapalım
        Actions actions = new Actions(driver);
        //İKİ kez aşağıya scroll yapıldı
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // Klavyenizdeki "PAGE DOWN VE PAGE UP" tuşları
        waitForSecond(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(2);


        //trick
        for (int i = 0; i < 3; i++) { //bu şekilde 3 kere aşağıya scrooll yapacak
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            waitForSecond(2);
        }

        //Sayfayı istediğimiz bir miktar yukarıya doğru scroll yapalım
        for (int i = 0; i < 3; i++) { //bu şekilde 3 kere yukarıya scrooll yapacak
            actions.sendKeys(Keys.PAGE_UP).perform();
            waitForSecond(2);
        }
    }

    @Test
    void test02() {

        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com/");

        //Sayfanın en aşağısına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        waitForSecond(3);

        //sayfanın en yukarısına scroll yapalım
        actions.sendKeys(Keys.HOME).perform();
    }

    @Test
    void test03() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com/");

        //"Events" yazısına kadar scroll yapalım
       WebElement eventsText = driver.findElement(By.xpath("//h2[.='Events']"));
       Actions actions = new Actions(driver);
       actions.scrollToElement(eventsText).perform();
    }
}
