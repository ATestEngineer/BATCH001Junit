package day14_screenshot_extentreport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_ScreenShot extends TestBase {

    /*
    Bir sayfanin ekran görüntüsünü almak istersek;
    1) ekran gorunutusunu kaydetmek istedigimiz dosya yolunu belirleriz
    2) TakeScreenShot tipinde bir object declare edip driveri bu objectye assign edeceğiz
        ==> TakeScreenShot ts = driver;
    3) Files classinda write() methodunu kullanarak icine parametre olarak aldigimiz ekran goruntusunu
    nereye kaydedeceğimizi beliritir, getScreenShotAs() methodu ile almis oldugumuz ekran görüntüsün bu
    path e kaydederiz
     */


    //src\test\java\screenshots

    @Test
    void test01() throws IOException {
        //TechproEducation sayfasina gidelim https://techproeducation.com
        driver.get("https://techproeducation.com");

        //Ekran görüntüsünü alalim
        String path = "src\\test\\java\\screenshots\\techpro.png"; //"techpro adında, png formatında kaydet" anlamını taşır

        TakesScreenshot ts = (TakesScreenshot) driver; //burada type casting yapıldı. yani driverın tipini değiştirdik, dönüştürdük (fotoğraf çekebilmesi için :) )

        Files.write(Paths.get(path),ts.getScreenshotAs(OutputType.BYTES));   //"ekran görüntüsünü al, sana verdiğim dosya yoluna yaz"

    }


    //Google sayfasina gidelim https://google.com


    @Test
    void test02() throws IOException {
        driver.get("https://google.com");
        //Ekran görüntüsünü alalim
        String path = "src\\test\\java\\screenshots\\google.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(path) , ts.getScreenshotAs(OutputType.BYTES));

    }
}
