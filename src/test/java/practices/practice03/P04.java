package practices.practice03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P04 extends TestBase {

    //    Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    //    Click "Choose File" button
    //    Type "My File" into "Notes about the file" input
    //    Select the file to upload
    //    Click on "Press" button
    //    Assert that "Your notes on the file were" equals "My File"
    //    Assert that file Content contains "Hello, I am uploaded file"


    @Test
    void fileUploadTest() {

        //    “https://cgi-lib.berkeley.edu/ex/fup.html” adresine gidin
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        //    “Dosya Seç” düğmesine tıklayın
        //"C:\Users\artis           \OneDrive\Masaüstü\Batch001.txt"
        String dynamicPath = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\Batch001.txt";
        driver.findElement(By.name("upfile")).sendKeys(dynamicPath);

        //    “Dosya hakkında notlar” girişine ‘Dosyam’ yazın
        driver.findElement(By.name("note")).sendKeys("Dosyam");

        //    “Press” düğmesine tıklayın
        driver.findElement(By.xpath("//input[@value='Press']")).click();
        waitForSecond(3);

        //    "Dosyam" isminin ekranda görüldüğünü doğrulayın
       String actualFileName = driver.findElement(By.tagName("blockquote")).getText();
        Assertions.assertEquals("Dosyam", actualFileName );

        //    “Merhaba, dosya yüklüyorum” mesajının görüldüğünü doğrulayın
       String succesMessage = driver.findElement(By.tagName("pre")).getText();
       Assertions.assertTrue(succesMessage.contains("uploaded file"), "HATA! MESAJ GÖRÜNTÜLENEMEDİ!");

    }
}
