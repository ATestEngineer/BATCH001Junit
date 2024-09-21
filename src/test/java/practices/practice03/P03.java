package practices.practice03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P03 extends TestBase {

    //    Go to https://form.jotform.com/73302671092956
    //    Click on start
    //    Enter firstname and lastname
    //    Click on next
    //    Enter email
    //    Click on next
    //    Enter message
    //    Click on next
    //    Handle captcha
    //    Click on submit
    //    Assert that submission is received



    //  Gönderimin alındığını onaylayın

    @Test
    void test01() {

        //  Verilen adrese gidin https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");

        //  Start butonuna tıklayın
        driver.findElement(By.id("jfCard-welcome-start")).click();

        //  İsim ve soyisim girin
        Faker faker = new Faker();

        driver.findElement(By.id("first_1")).sendKeys(faker.name().firstName());
        waitForSecond(1);
        driver.findElement(By.id("last_1")).sendKeys(faker.name().lastName());

        //  Next butonuna tıklayın
        driver.findElement(By.xpath("//button[@data-testid='nextButton_0']")).click();

        //  Email adresi girin
        driver.findElement(By.id("input_2")).sendKeys(Faker.instance().internet().emailAddress());
        waitForSecond(2);

        //  Next butonuna tıklayın
        driver.findElement(By.xpath("//button[@data-testid='nextButton_1']")).click();

        //  Mesaj girin "Hello World! We are learning Selenium"
        driver.findElement(By.id("input_3")).sendKeys("Hello World! We are learning Selenium");
        waitForSecond(1);

        //  Next butonuna tıklayın
        driver.findElement(By.xpath("//button[@data-testid='nextButton_2']")).click();
        waitForSecond(5);

        //  Captcha handle edin
        driver.switchTo().frame("customFieldFrame_4");

        //ilk sayı
       int number1 = Integer.parseInt(driver.findElement(By.id("number")).getText());
       int number2 = Integer.parseInt(driver.findElement(By.id("number2")).getText());
       String function = driver.findElement(By.id("function")).getText();

       int result;
       if (function.equals("+")){
           result = number1+number2;
       } else if (function.equals("-")){
           result = number1-number2;
       } else if (function.equals("x")){
           result = number1*number2;
       } else {
           result = number1/number2;
       }

        System.out.println("result = " + result);

       //sonucu sonuç kutusuna gönder
        driver.findElement(By.name("equal")).sendKeys(result + "");

       //submit butonu iframe dışında kaldığı için driverı çıkardık
        driver.switchTo().defaultContent();

        //  Gönder butonuna tıklayın
        driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();

        //  Gönderimin alındığını onaylayın
       String succesMessage = driver.findElement(By.tagName("h1")).getText();
       waitForSecond(1);
       Assertions.assertTrue(succesMessage.contains("Thank You!"));
    }
}
