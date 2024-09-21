package day15_extentreports_webtables_excel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReport extends TestBase {

    //Go to Amazon page
    //Search selenium in the search box
    //Verify that the page title contains selenium


    @Test
    void test01() {

        createExtentReport("Amazon Title Test");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanıcı amazon sayfasına gider");
        waitForSecond(3);
            //tüm sayfa ekran görüntüsünü alır, rapora ekler
            addscreenShotToReport();

        //Arama kutusunda laptop aratalim
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("laptop");

        addScreenShotOfWebElementToReport(searchbox);

        searchbox.submit();
        extentTest.info("Arama kutusunda laptop yazılarak aratıldı");

        //searchbox web elementinin ekran görüntüsünü alır, rapora ekler


        //Sayfa basliginin laptop icerdigini doğrulayalim
        Assertions.assertTrue(driver.getTitle().contains("laptop"));
        extentTest.pass("Sayfa başlığının laptop içerdiği doğrulandı");

        //tüm sayfa ekran görüntüsünü alır, rapora ekler
        addscreenShotToReport();

        extentReports.flush();
    }
}
