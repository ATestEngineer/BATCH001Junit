package day04_assertions_webelements_locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Locators {

    //Go to Amazon page
    //Locate the search box and print and search for "iPhone"
    //close the page

    //Amazon sayfasına gidiniz
    //Arama kutusunu locate ediniz ve "iphone" yazdırıp aratınız
    //Sayfayı kapatınız


    @Test
    void test01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        /* SEARCH BOX'IN HTML KODU:
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        aria-label="Search Amazon" spellcheck="false">
         */

        //Arama kutusunu locate ediniz
        //WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //"iphone" yazdık
        //searchBox.sendKeys("iphone"); //su anda sadece iphone yazdık, aratmadık henüz.

        /*
        Bir arama kutusuna locate edip text gönderirsek iki şekilde ENTER TUSUNA BASIP ARATABİLİRİZ, gönderebiliriz.
        1) submit() methodu
        2) Keys.ENTER
         */

        //1.yontem: İphone yazısını arattık.
        //searchBox.submit();

        //2.yontem:  "iphone" yazdırıp, aratınız
        //searchBox.sendKeys("iphone", Keys.ENTER);


        //Eger almis oldugumuz locate i sadece BIR kere kullanacaksak; sepete koymadan da yapabiliriz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //By.name attribute ü ile yapalım:
        driver.findElement(By.name("field-keywords")).sendKeys("iphone", Keys.ENTER);


        driver.close();

        


    }
}
