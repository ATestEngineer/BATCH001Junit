package day11_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {


    @Test
    void test01() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");
        waitForSecond(3);

        //arama kutusunda shift tusuna basılı olarak "selenium" yazdıralım ve // shift tuşunu serbest bırakarak java  yazdıralım, aratalım
     WebElement searchBox = driver.findElement(By.id("APjFqb"));
     Actions actions = new Actions(driver);
     actions.keyDown(searchBox, Keys.SHIFT) //arama kutusunda shift tuşuna basılı tutar
                .sendKeys("selenium") //shift tuşuna basılıyken selenium yazar
                .keyUp(Keys.SHIFT) //shift tuşundan elini kaldırır
                .sendKeys("      -java", Keys.ENTER)
                .perform();

    }

    @Test  //trick :)
    void test02() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");
        waitForSecond(3);

        //arama kutusunda shift tusuna basılı olarak "selenium" yazdıralım ve // shift tuşunu serbest bırakarak java  yazdıralım, aratalım
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, "    -java", Keys.ENTER);

    }
}
