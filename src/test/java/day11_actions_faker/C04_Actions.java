package day11_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {

    //Go to https://jqueryui.com/droppable/
    //Drag me to my target webelement onto the Drop here webelement



    @Test
    void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
         driver.switchTo().frame(0);
       WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
       WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
       Actions actions = new Actions(driver);
       actions.dragAndDrop(drag,drop).perform();

    }

    @Test
    void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag) //verilen webelemente tıklar ve basılı tutar
                .moveToElement(drop) //drag web elementini drop web elementinin üzerine götürür
                .release() //basılı tutulan web elementi serbest bırakır
                .perform();

    }

    //istediğimiz yere bırakmak için;
    @Test
    void test03() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(180, 0).
                release().
                perform();
    }

    /* ÖDEV!!
    Drag web elementinin drop web elementinin üzerine bırakıldığını test ediniz
     */
}
