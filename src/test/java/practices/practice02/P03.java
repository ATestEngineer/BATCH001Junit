package practices.practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P03 extends TestBase {

    // belirtilen url e gidin : https://demo.guru99.com/test/radio.html


    @Test
    void test01() {
        driver.get("https://demo.guru99.com/test/radio.html");

        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.id("vfb-6-2"));

        waitForSecond(3);

        // checkbox1 ve checkbox3 seçili değilse seçin
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }

        waitForSecond(2);

        if (!checkBox3.isSelected()) {
            checkBox3.click();
        }

        waitForSecond(2);

        // checkbox1 ve checkbox3 seçili olduğunu test edin
       Assertions.assertTrue(checkBox1.isSelected());
       Assertions.assertTrue(checkBox3.isSelected());

        // checkbox2 elementinin seçili olmadığını test edin
        //negatif senaryo
        //Assertions.assertFalse(checkBox2.isSelected());

        Assertions.assertTrue(!checkBox2.isSelected());

    }
}
