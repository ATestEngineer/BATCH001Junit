package day09_iframe_windowhandles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C05_WindowHandle extends TestBase {

    // Go to https://the-internet.herokuapp.com/windows.
    //get the Handle value of the first page and print it
    //test that the text on the first page is “Opening a new window”.
    //test that the first page Title is “The Internet”.
    // Click the "Click Here" button.
    //test that the second page Title is “New Window”.
    // go back to the first page and test that the Title is “The Internet”.
    // go to the second page again.
    // go back to the first page.


    @Test
    void test01() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfanın Handle degerini alın yazdırın
       String ilksayfaninHandleDegeri = driver.getWindowHandle();

       //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
       String actualText = driver.findElement(By.xpath("//h3")).getText();
       Assertions.assertEquals("Opening a new window",actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assertions.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.partialLinkText("Click Here")).click();

        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.


        Set<String> windows = driver.getWindowHandles(); // driver, açık olan tüm sayfaların handle degerlerini al, getir.

        for ( String w : windows){


            if (!w.equals(ilksayfaninHandleDegeri)){


                driver.switchTo().window(w);
            }
        }

        Assertions.assertEquals("New Window", driver.getTitle());


        String ikincisayfaninhandledegeri = driver.getWindowHandle();

        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        driver.switchTo().window(ilksayfaninHandleDegeri);
        Assertions.assertEquals("The Internet" , driver.getTitle());
        waitForSecond(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikincisayfaninhandledegeri);
        waitForSecond(2);


        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilksayfaninHandleDegeri);

    }

    @Test
    void test02() {   //BEST PRACTICE

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertEquals("Opening a new window",actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        Assertions.assertEquals("The Internet",driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.partialLinkText("Click Here")).click();


        //  ikinci sayfa Title'ının “New Window” olduğunu test edin.
        switchToWindow(1);
        Assertions.assertEquals("New Window", driver.getTitle());


        //  ilk sayfaya dönün ve Title'ının “The Internet” olduğunu test edin.
        switchToWindow(0);
        Assertions.assertEquals("The Internet" , driver.getTitle());
        waitForSecond(2);

        //  ikinci sayfaya tekrar geçin.
       switchToWindow(1);
        waitForSecond(2);


        //  ilk sayfaya tekrar dönün.
       switchToWindow(0);

    }

}
