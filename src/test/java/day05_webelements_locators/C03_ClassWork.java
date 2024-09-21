package day05_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork {

    //Go to https://testcenter.techproeducation.com/index.php
    //Test whether the "Back to TechProEducation.com" button is enabled for user access
    // Test whether the "Applications lists" title is visible by locating it with the tagname
    // close the page

    //https://testcenter.techproeducation.com/index.php adresine gidin
    // "Back to TechProEducation.com" butonunun kullanici erisimi icin etkin olup olmadigini test edin
    // "Applications lists" basligini tagname ile locate ederek görünür olup olmadigini test ediniz
    //sayfayi kapatalim


    @Test
    void test01() {

        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://testcenter.techproeducation.com/index.php adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php");

        // "Back to TechProEducation.com" butonunun kullanici erisimi icin etkin olup olmadigini test edin
        WebElement backButton = driver.findElement(By.partialLinkText("Back to TechProEducation.com"));
        Assertions.assertTrue(backButton.isEnabled());

        // "Applications lists" basligini tagname ile locate ederek görünür olup olmadigini test ediniz
        WebElement header = driver.findElement(By.tagName("h1"));
        Assertions.assertTrue(header.isDisplayed());

        // sayfayi kapatalim
        driver.close();


    }
}
