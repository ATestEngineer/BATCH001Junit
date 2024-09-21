package day14_screenshot_extentreport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ClassWork extends TestBase {

    //Go to Techproeducation page https://www.techproeducation.com/
    //Verify that the home page has loaded successfully.
    //Take a screenshot of the page
    //Verify that the phone number displayed on the page is +1 585 304 29 59
    //take a screenshot of the displayed phone number
    //print selenium in search box and take screenshot of search box




    @Test
    void test01() {

        //Techproeducation sayfasına gidelim https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");

        //Ana sayfanın başarıyla yüklendiğini doğrula.
        Assertions.assertEquals("https://www.techproeducation.com/", driver.getCurrentUrl());

        //Sayfanın tam ekran görüntüsünü alin
        screenShot();

        //Sayfada görüntülenen telefon numarasinin +1 585 304 29 59 oldugunu dogrulayin
       WebElement phoneNumber = driver.findElement(By.xpath("(//a[.='+1 585 304 29 59'])[1]"));
       Assertions.assertEquals("+1 585 304 29 59", phoneNumber.getText());

        //goruntulenen telefon numarasinin ekran goruntusunu alin
        screenShotOfWebElement(phoneNumber);
        waitForSecond(1);

        //arama kutusunda selenium yazdirin ve arama kutusunun ekran goruntusunu alin
       WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));
       searchBox.sendKeys("selenium");
       screenShotOfWebElement(searchBox);

    }
}
