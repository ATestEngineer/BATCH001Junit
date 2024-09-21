package day13_seleniumwaits_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait_FluentWait extends TestBase {

    //https://the-internet.herokuapp.com/dynamic_loading/1



    @Test
    void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Click the start button
        driver.findElement(By.tagName("button")).click();

        //Hello World! Test that the article is on the site
        FluentWait<WebDriver> wait = new FluentWait<>(driver);

        WebElement helloWorldText = driver.findElement(By.xpath("//*[.='Hello World!']"));

        wait.withTimeout(Duration.ofSeconds(20)) //max bekleme süresini belirttik
                .pollingEvery(Duration.ofMillis(500)) //belirttiğimiz aralıklarla koşulu kontrol et
                .withMessage("Web elementi ve süreyi kontrol et")
                .until(ExpectedConditions.visibilityOf(helloWorldText));

        Assertions.assertEquals("Hello World!", helloWorldText);

    }
}
