package day17_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutorSetAttribute extends TestBase {


    //attrıbute value set etme
    @Test
    void test01() {

        //<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        // placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        // aria-label="Search Amazon" spellcheck="false">


        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='selenium'", searchBox);


    }


    @Test
    void test02() {
        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        jsSendKeys(searchBox, "selenium");

    }



    //Attribute name ile set etme
    @Test
    void test03() {
        //amazona gidelim
        driver.get("https://amazon.com");

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id', 'elif')", searchBox);

        //değiştirilmiş id attribute name ile search box'ı locate edelim
        driver.findElement(By.id("elif")).sendKeys("selenium");

    }









}
