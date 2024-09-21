package day13_seleniumwaits_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_TimeOutException extends TestBase {


    @Test
    void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Click the start button
        driver.findElement(By.tagName("button")).click();

        //Hello World! Test that the article is on the site
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement helloWorldText = driver.findElement(By.xpath("//*[.='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        Assertions.assertEquals("Hello World!", helloWorldText);

    }
}
