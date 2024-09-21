package day10_basicauthentication_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {

    //Authenticate using the following information:
    // Url: https://the-internet.herokuapp.com/basic_auth
    // Username: admin
    //Password: admin
    // Congratulations! You must have the proper credentials. verify that the post has appeared
    //Click on the Elemental Selenium link
    //Let's test that the header contains Elemental Selenium


    @Test
    void test01() {
        //Aşağıdaki bilgileri kullanarak authentication yapınız:
        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //   "Congratulations! You must have the proper credentials." yazısinın çıktığını doğrulayın
        String actualText = driver.findElement(By.tagName("p")).getText();
        Assertions.assertEquals("Congratulations! You must have the proper credentials." , actualText );

        // "Elemental Selenium" linkine tıklayınız
        driver.findElement(By.partialLinkText("Elemental Selenium")).click();
        switchToWindow(1);

        // Başlığın "Elemental Selenium" içerdiğini test edelim
        Assertions.assertTrue(driver.getTitle().contains("Elemental Selenium"));

    }
}
