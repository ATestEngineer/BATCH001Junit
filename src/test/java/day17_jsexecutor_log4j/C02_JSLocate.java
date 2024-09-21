package day17_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSLocate extends TestBase {


    @Test
    void test01() {

        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //jsexecutor ile arama kutusuna selenium yazdiralim
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement searchBox = (WebElement) js.executeScript("return document.getElementById('twotabsearchtextbox')");
        searchBox.sendKeys("selenium");

    }

    //techproeducation sayfasina gidelim  https://techproeducation.com
    //Events yazisini BATCH001 olarak degistirelim


    @Test
    void test02() {
        driver.get("https://techproeducation.com");
        waitForSecond(2);

        WebElement eventsText = driver.findElement(By.xpath("//h2[.='Events']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].textContent='BATCH001'", eventsText);

    }
}
