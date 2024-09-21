package day16_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static java.awt.SystemColor.window;

public class C05_JSScroll extends TestBase {


    //js executor ile web elemente scroll yapalım
    @Test
    void test01() {

        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");

        //Challenges a kadar scroll yapiniz
        WebElement challengesElement = driver.findElement(By.xpath("//h2[3]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", challengesElement);

    }

    //js executor ile sayfa başına ve sayfa sonuna scroll yapalım
    @Test
    void test02() {

        //https://www.techproeducation.com/ adresine gidiniz
        driver.get("https://www.techproeducation.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0,2200)"); >>bununla sayfada belirli bir pikselde aşağıya indildi. sayfanın sonuna inilmedi

        //sayfanın en sonuna inelim
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //sayfanın toplam yüksekliğini dynamic olarak aldık ve y koordinatı olarak verdik
        waitForSecond(2);

        //sayfanın en başına çıkalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    @Test
    void test03() {
        //https://www.techproeducation.com/ adresine gidiniz
        driver.get("https://www.techproeducation.com/");
        jsScrollEnd();
        waitForSecond(2);
        jsScrollHome();
    }
}
