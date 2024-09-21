package practices.practice04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P01 extends TestBase {


    @Test
    void test01() {

        // kullanıcı https://www.amazon.com/ adresine gider
        driver.get("https://www.amazon.com/");
        waitForSecond(3);

        //Account linkine tıklayın
        Actions actions = new Actions(driver);
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
        waitForSecond(2);

        //Ardından sayfa başlığının “Account” içerdiğini doğrulayın
        WebElement accountOption = driver.findElement(By.linkText("Account"));

       //   1 accountOption.click(); //normal yol
       //   2 actions.click(accountOption).perform(); normal yol ile tıklayamazsak, alternatif olarak actions kullanabilirz
       // yukarıdaki iki işlevin ikisi de çalışmazsa, js ile click yapabilirz

        jsClick(accountOption);
        waitForSecond(3);

        //Ardından sayfanın altındaki Amazon Music öğesine ilerleyin
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));

       // actions.moveToElement(amazonMusic).perform(); >> moveToElement() methodu, ögeyi sayfanın neresinde olursa olsun genellikle bulur
        jsScrollToWebElement(amazonMusic);
        waitForSecond(3);


        //Elemente tıklayın
        //        amazonMusic.click(); // normal way
        //        actions.click(amazonMusic); //normal yola alternatif
        jsClick(amazonMusic);
        waitForSecond(3);

        //Ardından Amazon Music sayfasının görüntülendiğini doğrulayın
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));

        // Sayfayı yukarı ve aşağı kaydırın
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 250)"); //scroll down
        waitForSecond(1);
        js.executeScript("window.scrollTo(0, -250)"); //scroll up
        waitForSecond(1);
        jsScrollEnd(); //sayfa sonuna scroll
        waitForSecond(1);
        jsScrollHome(); //sayfa başına scroll


        //müzik sayfasındaki arama girişini bulun ve 'POP' aratın
        WebElement searchBox = driver.findElement(By.id("navbarSearchInput"));
        searchBox.sendKeys("POP", Keys.ENTER);

        //arama kutusunun id değerini, kendi ismimiz ile değiştirelim

        /*
        <input id="navbarSearchInput" class="HnY_v1NvZaJZknyxFDBP" placeholder="Search" type="search" role="searchbox" value="">
         */
        js.executeScript("arguments[0].setAttribute('id' , 'elif')", searchBox);

        //değiştrdiğimiz id ile yeniden searchboxı locate edelim
        driver.findElement(By.id("elif"));

    }
}
