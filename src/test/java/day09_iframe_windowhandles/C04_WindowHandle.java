package day09_iframe_windowhandles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_WindowHandle extends TestBase {

    @Test
    void tets01() {  //WINDOW VERSION

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni bir PENCERE açar ve driver'ı o pencereye geçirir.
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        /*

        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(0));

        YUKARIDAKİ KODUN AÇIKLAMASI:
        Acilmis olan tüm pencerelerin window handle değerlerini getWindowHandles() methodu ile aldik,
        driver.getWindowHandles() methodu set return ediyor.
        setlerde index kullanarak istediğimiz bir elemani secmek mumkun değildi
        Bu nedenle seti kullanarak bir tane list olusturduk,
        cunku listlerde get() methodu sayesinde index kullanarak istedigimiz pencereye
        rahatlikla gecis yapabileceğiz
         */


        //techproeducation sayfasına geçiniz,
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(0));
        waitForSecond(2);

        //youtube sayfasına geçiniz,
        driver.switchTo().window(windowsList.get(1));
        waitForSecond(2);

        //linkedIn sayfasına geçiniz
        driver.switchTo().window(windowsList.get(2));

    }

    @Test
    void tets02() {  //UZUN YOL:
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni bir PENCERE açar ve driver'ı o pencereye geçirir.
        driver.get("https://www.youtube.com");


        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");


        //techproeducation sayfasına geçiniz,
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        waitForSecond(2);

        //youtube sayfasına geçiniz,
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        waitForSecond(2);

        //linkedIn sayfasına geçiniz
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());

    }

}
