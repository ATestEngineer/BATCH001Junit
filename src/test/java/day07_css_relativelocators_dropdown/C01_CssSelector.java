package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CssSelector {


    /*                 SYNTAX
    1)  tagName [  attributeName = 'attributeValue'   ]
    2)  Eger id ile css locate almak istersek         #idAttributeValue
    3)  Eger class ile css locate almak istersek .classAttributeValue

    XPath ile CssSelector arasindaki fark :
    1) Xpath ile bir webelement icin birden fazla sonuc verirse index ile bunu tek'e dusurebiliriz
        Fakat CssSelector ile index kullanamayiz
    2) Xpath ile bir webelementi sadece text i ile locate edebiliriz.
        Fakat CssSelector ile bunu yapamayiz
    3) CssSelector Xpath 'a gore daha hizli calisir  EN BÜYÜK AVANTAJ
     */

    //Go to https://the-internet.herokuapp.com/add_remove_elements/
    //Press the Add Element button
    //Test that the delete button is visible
    //press the delete key
    //Test that the “Add/Remove Elements” text is visible
    //close the page




    @Test
    void test01() throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();


        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually'")); // class unique olduğu için,   >>>   .added-manually diyerek, kısayolla da alabiliriz.
        Assertions.assertTrue(deleteButton.isDisplayed());
        Thread.sleep(3000);


        //Delete tusuna basin
        deleteButton.click();


        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
       WebElement addRemoveText = driver.findElement(By.cssSelector("h3"));
       Assertions.assertTrue(addRemoveText.isDisplayed());
       Thread.sleep(3000);


        //sayfayı kapatınız
        driver.quit();

    }
}
