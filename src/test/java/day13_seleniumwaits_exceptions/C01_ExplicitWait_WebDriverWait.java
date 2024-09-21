package day13_seleniumwaits_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait_WebDriverWait extends TestBase {


    /*
        Selenium Waits

        1) Implicitly Wait
            ==> Bir websayfasina gittikten sonra sayfadaki tum webelemenetlerin driver ile etkilesime gecebilmesi icin
            belirtmis oldugumuz max. sure kadar driveri bekletiriz

       2)  Explicit Wait

            a) WebDriverWait :
            ==> Bir websayfasi yuklendikten sonra bir webelement ile ilgili specific bir KOSUL(==>ExpectedConditions) icin maximum
            belirtmis oldugumuz sure kadar bekletiriz ve bu sure default olarak yarim saniyelik araliklar ile olur
            ==> Bir kosulun gerceklesmesi farkli surelerde meydana gelebilir, böyle bir durumda Thread.sleep kullanmak Profosyonel bir yaklasim olmaz
            Bunun yerine WebdriverWait ile bir webelementin olusmasini beklemek daha mantikli olur

            b) FluentWait:
            ==>Bir websayfasi yuklendikten sonra bir webelement ile ilgili specific bir KOSUL(==>ExpectedConditions) bizim belirteceğimz araliklar

            ile bekler
         */

    //https://the-internet.herokuapp.com/dynamic_loading/1
    //Click the start button
    //Hello World! Test that the article is on the site



    @Test
    void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

             /*
            1) WebdriverWait objecti olusturup burada maximum beklenecek sureyi tayin ederiz
            2) Hangi weblement gorunur olana kadar beklemek istiyorsak locate ederiz
            3) Olusturmus oldugumuz webdriverwait objecti üzerinden kosulumuzu belirtiyoruz
             */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //elemente erişimimiz için verdiğimiz max süre

        WebElement helloWordText = driver.findElement(By.xpath("//*[.='Hello World!']"));

        wait.until(ExpectedConditions.visibilityOf(helloWordText));

        Assertions.assertEquals("Hello World!", helloWordText.getText());

    }

    @Test
    void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.tagName("button")).click();

        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorldText = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Hello World!']")));

        Assertions.assertEquals("Hello World!", helloWorldText.getText());

    }
}
