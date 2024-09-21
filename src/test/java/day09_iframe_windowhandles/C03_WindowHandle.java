package day09_iframe_windowhandles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {


    /*
    1-driver.switchTo().newWindow(WindowType.WINDOW) ==> yeni bir PENCERE acar ve driver ile birlikte buraya gecis yapar
    2-driver.switchTo().newWindow(WindowType.TAB) ==> yeni bir SEKME acar ve driver ile birlikte buraya gecis yapar
    3-driver.switchTo().window(String handleDegeri) ==> Eger handle degeri ile acik olan bir sayfaya gecis yapmak istersek
    parantez icinde gecis yapmak istedigimiz sayfanin handle değerini belirtiriz
     */



    //On Windows 1, go to https://www.techproeducation.com
    //Verify that the title contains "TechPro Education"
    //Open https://www.youtube.com in Windows 2 (in a new window)
    //In Windows 3 (in a new window), open https://www.linkedin.com
    //Go to the techproeducation page,
    //go to youtube page,
    //Go to LinkedIn page



    @Test
    void tets01() {  //WINDOW VERSION
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));
        String techproHandleDegeri = driver.getWindowHandle();

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni bir PENCERE açar ve driver'ı o pencereye geçirir.
        driver.get("https://www.youtube.com");
        String youtubeHandleDegeri = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandleDegeri = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz,
        driver.switchTo().window(techproHandleDegeri);
        waitForSecond(2);

        //youtube sayfasına geçiniz,
        driver.switchTo().window(youtubeHandleDegeri);
        waitForSecond(2);

        //linkedIn sayfasına geçiniz
        driver.switchTo().window(linkedinHandleDegeri);

    }
    //BU SENARYONUN TAB VERSİYONUNU CEVAPLAYIN


    @Test
    void test02() {    //TAB VERSION

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));
        String techproHandleDegeri = driver.getWindowHandle();

        //Window 2'de (yeni bir SEKMEDE) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB); //yeni bir PENCERE açar ve driver'ı o pencereye geçirir.
        driver.get("https://www.youtube.com");
        String youtubeHandleDegeri = driver.getWindowHandle();

        //Window 3'te (yeni bir SEKMEDE) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinHandleDegeri = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz,
        driver.switchTo().window(techproHandleDegeri);
        waitForSecond(2);

        //youtube sayfasına geçiniz,
        driver.switchTo().window(youtubeHandleDegeri);
        waitForSecond(2);

        //linkedIn sayfasına geçiniz
        driver.switchTo().window(linkedinHandleDegeri);
    }
}
