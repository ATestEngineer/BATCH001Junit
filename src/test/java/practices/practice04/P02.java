package practices.practice04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02 extends TestBase {

    @Test
    void test01() {

        Faker faker = new Faker();
        // kullanıcı verilen adrese gider https://www.trvlcar.com/
        driver.get("https://www.trvlcar.com/");

        // Adrese gittiğini doğrular
        Assertions.assertEquals("https://www.trvlcar.com/", driver.getCurrentUrl(), "HATA VAR!");
        Assertions.assertEquals("TrvlCar | Premium Car Rental", driver.getTitle(), "HATA VAR!");

        // Register butonuna tıklar
       WebElement registerButton = driver.findElement(By.xpath("//a[@href='/auth']"));
       registerButton.click();

        //Register kısmına geçiş yapar
        driver.findElement(By.xpath("//button[@data-rr-ui-event-key='register']")).click();

        //Tüm alanları doldurur
        String password = "Deneme#123";
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,
                faker.name().lastName(),Keys.TAB,
                faker.phoneNumber().phoneNumber(),Keys.TAB,
                faker.address().fullAddress(),Keys.TAB,
                faker.address().zipCode(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,
                password, Keys.TAB,
                password);

               //Register butonuna tıklar
               WebElement registerButton2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
               jsScrollToWebElement(registerButton2);
               waitForSecond(2);

               registerButton2.click();
               waitForSecond(3);

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'You are registered successfully')]"));
        waitForSecond(2);
        Assertions.assertTrue(successMessage.getText().contains("You are registered successfully"), "HATA VAR!!!");
    }
}
