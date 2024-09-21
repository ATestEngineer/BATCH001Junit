package practices.practice03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class P01 extends TestBase {
    //      When Navigate to https://testpages.herokuapp.com/styled/windows-test.html
    //      When Click on "Alerts In A New Window From JavaScript"
    //      And Switch to new window
    //      And Click on "Show alert box" button
    //      And Accept alert
    //      And Click on "Show confirm box" button
    //      And Cancel alert
    //      Then Assert that alert is cancelled
    //      When Click on "Show prompt box" button
    //      And Send "Hello selenium!" to the alert
    //      Then Assert that "Hello selenium!" is sent


    @Test
    void alertTest() {

        //     https://testpages.herokuapp.com/styled/windows-test.html adresine git
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        //     Alerts In A New Window From JavaScript" üzerine tıkla
        driver.findElement(By.cssSelector("#goalerts")).click(); //id unique. css kısayol ile alındı
        waitForSecond(2);

        //     Yeni pencereye geç
        switchToWindow(1);
        waitForSecond(2);

       /*
       String firstWindowHandle = driver.getWindowHandle();
        Set<String> allWinowHandles = driver.getWindowHandles();
        for (String w : allWinowHandles) {
            if (!w.equals(firstWindowHandle)){
                driver.switchTo().window(w);
            }
        }

        */
        //     “Show alert box” düğmesine tıkla
        driver.findElement(By.id("alertexamples")).click();
        waitForSecond(2);

        //      Uyarıyı kabul et
        driver.switchTo().alert().accept();
        waitForSecond(4);

        //     “Show confirm box” düğmesine tıklayın //     Uyarıyı iptal et
        driver.findElement(By.id("confirmexample")).click();
        driver.switchTo().alert().dismiss();
        waitForSecond(2);

        //     Ardından uyarının iptal edildiğini doğrulayın
        String dissmisResult =driver.findElement(By.id("confirmreturn")).getText();
        Assertions.assertTrue(dissmisResult.equals("false"));

        //     “Show prompt box” düğmesine tıkla,
        driver.findElement(By.id("promptexample")).click();
        waitForSecond(2);

        //     Uyarıya “Hello selenium!” metnini gönderin
        driver.switchTo().alert().sendKeys("Hello selenium!");
        driver.switchTo().alert().accept();
        waitForSecond(2);

        //     “Hello selenium!” metninin gönderildiğini doğrulayın
        String promptResult =driver.findElement(By.id("promptexplanation")).getText();
        Assertions.assertTrue(promptResult.contains("OK"));

    }
}
