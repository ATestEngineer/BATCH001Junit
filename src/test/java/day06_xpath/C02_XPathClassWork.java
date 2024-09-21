package day06_xpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPathClassWork {

    //Go to https://the-internet.herokuapp.com/add_remove_elements/
    //Press the Add Element button
    //Test that the delete button is visible
    //press the delete key
    //Test that the “Add/Remove Elements” text is visible
    //close the page

    @Test
    void name() throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.xpath("//*[. = 'Add Element']")).click();
        Thread.sleep(3000);

        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[text() = 'Delete' ]"));
        Assertions.assertTrue(deleteButton.isDisplayed());

        //Delete tusuna basin
        Thread.sleep(3000);
        deleteButton.click();

        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
       WebElement addRemoveElements = driver.findElement(By.xpath("//h3"));
       Assertions.assertTrue(addRemoveElements.isDisplayed());
       Thread.sleep(3000);

       //sayfayı kapatınız
        driver.close();
    }

}
