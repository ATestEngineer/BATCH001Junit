package day12_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUpload extends TestBase {

    //Go to https://the-internet.herokuapp.com/upload
    //press the chooseFile button
    //Select the file you want to upload
    //Press the Upload button
    //“File Uploaded!” Test whether your text is displayed

    @Test
    void fileUploadTest() {

        // https://the-internet.herokuapp.com/upload   adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
      WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
      String dynamicPath = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";


        //Yuklemek istediginiz dosyayi secelim.
        chooseFileButton.sendKeys(dynamicPath);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("File Uploaded!", actualText);

    }
}
