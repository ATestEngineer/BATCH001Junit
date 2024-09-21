package day12_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class RobotClassWork extends TestBase {

    @Test
    void test01() {

        // https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");


        //Giriş yap
      WebElement nameBox = driver.findElement(By.name("username"));
      nameBox.sendKeys("Admin");

      WebElement passwordBox =  driver.findElement(By.name("password"));
      passwordBox.sendKeys("admin123");

      driver.findElement(By.xpath("//button[@type='submit']")).click();

        waitForSecond(3);

        // PIM butonuna tikla
        driver.findElement(By.xpath("//span[.='PIM']")).click();

        // Add Butona tıkla
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();

        // Resim ekle butona tıkla
      WebElement addPhoto = driver.findElement(By.cssSelector(".employee-image"));
      addPhoto.click();

      //"C:\Users\artis                  \Downloads\color-pencils-5699634_1280.jpg"
      //resmi yükle
        String dynamicPath = System.getProperty("user.home") + "\\Downloads\\color-pencils-5699634_1280.jpg";
        uploadFilePath(dynamicPath);


        //Resim Eklendiğini doğrula
        Assertions.assertTrue(addPhoto.getAttribute("src").contains("data:image/"));

    }
}
