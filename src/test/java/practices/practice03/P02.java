package practices.practice03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P02 extends TestBase {


    @Test
    void test01() {

        //         Verilen adrese git https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        //         Turuncu öğeleri aşağıdaki uygun kutulara sürükle
      WebElement bank = driver.findElement(By.id("credit2"));
      WebElement sales = driver.findElement(By.id("credit1"));

     WebElement firstAmount = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
     WebElement secondAmount = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));

      //Yukarıdaki öğeleri bırakmanız gereken yerleri bulun
        WebElement debitAccountBank = driver.findElement(By.id("bank"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));

        WebElement creditAccountSales = driver.findElement(By.id("loan"));
        WebElement creditAmount = driver.findElement(By.id("amt8"));

        //         Turuncu öğeleri aşağıdaki uygun kutulara sürükle

        Actions actions = new Actions(driver);

        actions.dragAndDrop(bank, debitAccountBank).perform();
        waitForSecond(2);

        actions.dragAndDrop(firstAmount, debitAmount).perform();
        waitForSecond(2);

        actions.dragAndDrop(sales, creditAccountSales).perform();
        waitForSecond(2);

        actions.dragAndDrop(secondAmount, creditAmount).perform();
        waitForSecond(2);


        /*
        actions.dragAndDrop(bank, debitAccountBank)
                .dragAndDrop(firstAmount, debitAmount)
                .dragAndDrop(sales, creditAccountSales)
                .dragAndDrop(secondAmount, creditAmount)
                .build().perform();

         */

        //         Sürüklenip bırakıldıklarını doğrula
        String perfectButtonText = driver.findElement(By.xpath("//a[.='Perfect!']")).getText();
        Assertions.assertTrue(perfectButtonText.contains("Perfect!"));


    }
}
