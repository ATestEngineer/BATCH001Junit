package day09_iframe_windowhandles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    //https://testcenter.techproeducation.com/index.php?page=iframe
    //Test that the text 'An iframe with a thin black border:' on the home page contains 'black border'
    //Also test that the text 'Applications lists' is on the page
    //Test that there is an iframe text in the page

    //https://testcenter.techproeducation.com/index.php?page=iframe






    @Test
    void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edin.
        String actualText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        Assertions.assertTrue(actualText.contains("black border"));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edin
        driver.switchTo().frame(0);
        WebElement aplicationListWE = driver.findElement(By.tagName("h1"));
        Assertions.assertTrue(aplicationListWE.getText().contains("Applications lists"));

        //sayfada iframe yazısının olduğunu test edin
        driver.switchTo().defaultContent();
        WebElement iframeText = driver.findElement(By.xpath("//h3"));
        Assertions.assertTrue(iframeText.getText().contains("iframe"));

    }

    /*
    Bir HTML dokümanı içinde yerleştirilmiş olan başka bir HTML dokümanına "Inline Frame (iframe) denir.
    Sayfadaki bir webelementi locate ettiğimizde "NoSuchElement Exception" alıyorsak, locate'i kontrol ederiz.
    Yine de aynı hatayı almaya devam ediyorsak, ulaşmak istediğimiz web element iframe içinde olabilir.
    Dolayısıyla iframe içindeki bir web elemente ulaşmak için driverımızı iframe'e geçirmemiz gerekir.

    Bunu üç şekilde yapabiliriz:

    1)  driver.switchTo().frame( sayfadaki iframe'in index'ini verebiliriz  ) index 0'dan başlar
    2)  driver.switchTo().frame( <iframe> id / name attribute değeri  )
    3)  driver.switchTo().frame( iframe webelementi  )

    Tekrar ana sayfaya geçmek istersek "defaultContent()" methodu ile geçebiliriz.
    Eger iç içe iframelere geçiş yaptıysak ve bir üst frame'e tekrar driver'i taşımak istersek,
    "parentFrame()" methodu ile bir üst frame'e geçiş yapabiliriz.
     */



}
