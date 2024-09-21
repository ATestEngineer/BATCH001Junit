package day08_testbase_alert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Alert extends TestBase {

    /*
    Eger bir sayfadaki bir button a tikladiktan sonra bir uyari penceresi cikiyorsa ve bu cikan pencereye inspect yaparak
    locate alamiyorsak, bu bir JS Alert'tur.
    JS Alert'u handle edebilmek icin driver'imizi o pencereye gecis yaptirmamiz gerekecek.
    Bunun icin driver object'imiz üzerinden switchTo() methoduyla alert() e gecis yapacağız.
     */
    //   https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.

    //   Bir metod olusturun: acceptAlert
    //      birinci butona tıklayın,
    //      uyarıdaki OK butonuna tıklayın
    //      result mesajının  “You successfully clicked an alert” oldugunu test edin.


    //Bir metod olusturun: dismissAlert
    //       ikinci butona tıklayın,
    //       uyarıdaki Cancel butonuna tıklayın
    //       result mesajının “successfuly” icermedigini test edin.


    //Bir metod olusturun: sendKeysAlert
    //       ucuncu butona tıklayın,
    //       uyarıdaki  metin kutusuna isminizi yazin,
    //       OK butonuna tıklayın
    //       result mesajında isminizin görüntülendiğini doğrulayın.


    @Test
    void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
       // birinci butona tıklayın,
        waitForSecond(2);
        driver.findElement(By.xpath("//*[@onclick = 'jsAlert()']")).click(); //1.butona tıkladık.
        //      uyarıdaki OK butonuna tıklayın
        waitForSecond(2);
        driver.switchTo().alert().accept();
        /*
        accept > onay kabull etme
        dissmis > iptal etme * cansel
        getText > alert'ün yazısını getirir
        sendKeys > kullanıcının alerte gönderdiği text
         */
        //      result mesajının  “You successfully clicked an alert” OLDUĞUNU test edin.
        waitForSecond(2);
        String actualResultText = driver.findElement(By.id("result")).getText();
        String expectedResultText = "You successfully clicked an alert";
        Assertions.assertEquals(expectedResultText,actualResultText);

    }


    @Test
    void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        waitForSecond(2);
        //       ikinci butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();//2. buttona tikladik

        waitForSecond(2);
        //       uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();//Cancel a (iptal) bastik

        waitForSecond(2);
        //       result mesajının “successfuly” icermedigini test edin.
        // >> yani icerir kodunun false oldugunu doğrulamaliyiz <<
        String actualResultMessage = driver.findElement(By.id("result")).getText();
        String unExpectedResultMessage ="successfuly";
        Assertions.assertFalse(actualResultMessage.contains(unExpectedResultMessage));

    }

    @Test
    void sendKeysAlert() {
        //       ucuncu butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        //       uyarıdaki  metin kutusuna isminizi yazin,
        waitForSecond(2);
        driver.switchTo().alert().sendKeys("elif");
        //       OK butonuna tıklayın
        waitForSecond(2);
        driver.switchTo().alert().accept();
        //       result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResultMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assertions.assertTrue(actualResultMessage.contains("elif"));

    }
}
