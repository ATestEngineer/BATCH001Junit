package practices.practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02 extends TestBase {

    // https://testpages.herokuapp.com/styled/calculator




    // sayfayı kapat


    @Test
    void plusTest() {
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 30 gir
        driver.findElement(By.id("number1")).sendKeys("30");

        // ikinci kutucuga 15 gir
        driver.findElement(By.id("number2")).sendKeys("15");

        // calculate'e tıkla
        driver.findElement(By.id("calculate")).click();

        // sonucu yazdır
        String result = driver.findElement(By.id("answer")).getText();
        System.out.println("result = " + result);
        waitForSecond(2);

        //sonucunun 45 olduğunu doğrula.
        Assertions.assertTrue(result.equals("45"));
        waitForSecond(2);

    }


    @Test
    void minusTest() {

        driver.get("https://testpages.herokuapp.com/styled/calculator");

        //İlk kutucuga 80 gir
        driver.findElement(By.id("number1")).sendKeys("80");

        //dorpdown menüdeki minus seçeneğini seç
        WebElement minusOperator = driver.findElement(By.id("function"));
        selectIndex(minusOperator, 2);
        waitForSecond(2);

        //ikinci kutuya 20 gir
        driver.findElement(By.id("number2")).sendKeys("20");

        // calculate'e tıkla
        driver.findElement(By.id("calculate")).click();

        // sonucu yazdır
        String result2 = driver.findElement(By.id("answer")).getText();
        System.out.println("result2 = " + result2);
        waitForSecond(2);

        // sonucun 60 olduğunu doğrula
        Assertions.assertTrue(result2.equals("60"));
        waitForSecond(3);

    }
}
