package day16_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutorClick extends TestBase {


    @Test
    void test01() {

        //amazon sayfasina gidelim https://amazon.com
        driver.get("https://amazon.com");
        waitForSecond(3);

        //sell webelementine tiklayalim
       WebElement sell = driver.findElement(By.xpath("//a[.='Sell']"));
       sell.click();
       //sell linkinin önüne pop up çıktığı için ElementClickInterceptedException hatası alındı

    }

    @Test
    void test02() {

        //amazon sayfasina gidelim https://amazon.com
        driver.get("https://amazon.com");
        waitForSecond(3);
        WebElement sell = driver.findElement(By.xpath("//a[.='Sell']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sell);

    }


    @Test
    void test03() {

        //amazon sayfasina gidelim https://amazon.com
        driver.get("https://amazon.com");
        waitForSecond(3);

        //sell webelementine tiklayalim
        WebElement sell = driver.findElement(By.xpath("//a[.='Sell']"));
        jsClick(sell);
    }
}
