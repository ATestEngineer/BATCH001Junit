package day08_testbase_alert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TestBaseClassWork extends TestBase {

 /*
     https://testcenter.techproeducation.com/index.php?page=dropdown sayfasina gidelim
     Year, month, day dropdown menulerden reusable method kullanarak secim yapalim
     */

    @Test
    void reusubleMethodUsage() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //         a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));


        //reusable method kullanarak secim yapalim
        waitForSecond(2);
        selectIndex(year,0); //1.indexi seçmiş olduk
        waitForSecond(2);
        selectIndex(month, 1);//2.indexi seçti
        waitForSecond(2);
        selectIndex(day, 2);//3.indexi seçti
        waitForSecond(3);

        waitForSecond(2);
        selectVisible(year,"2000");
        waitForSecond(2);
        selectVisible(month,"May");
        waitForSecond(2);
        selectVisible(day,"5");
        waitForSecond(5);
    }








}
