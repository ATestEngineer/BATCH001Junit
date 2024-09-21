package day09_iframe_windowhandles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    //Go to https://the-internet.herokuapp.com/iframe
    //Verify that the bold text contains the word "Editor"
    //Test that the text inside the textbox is 'Your content goes here.'
    //Verify that the text on the page is "Elemental Selenium".

    //https://the-internet.herokuapp.com/iframe sayfasına gidiniz




    @Test
    void test01() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertTrue(actualText.contains("Editor"));

        //Textboxun icindeki metnin 'Your content goes here.' Oldugunu test edin
        driver.switchTo().frame("mce_0_ifr"); //id attribute name'in value değerini kullanarak geçiş yaptık.
        String actualTextBox = driver.findElement(By.xpath("//p[.='Your content goes here.']")).getText();
        String expectedTextBox = "Your content goes here.";
        Assertions.assertEquals(expectedTextBox,actualTextBox);

        //Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        String actualElementalSeleniumText = driver.findElement(By.partialLinkText("Elemental Selenium")).getText();
        Assertions.assertEquals("Elemental Selenium", actualElementalSeleniumText);

    }

    //homework
    //https://html.com/tags/iframe   sayfasina gidiniz
    // sayfada bulunan youtube videosunu baslatiniz

}
