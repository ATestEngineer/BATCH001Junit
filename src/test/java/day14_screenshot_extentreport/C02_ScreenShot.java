package day14_screenshot_extentreport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {


    @Test
    void test01() throws IOException {
        //facebook sayfasina gidelim https://facebook.com
        driver.get("https://facebook.com");

        //ekran görüntüsünü alalim

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\screenshots\\facebook"+date+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(path) , ts.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    void test02() {

        driver.get("https://facebook.com");
        screenShot();
    }
}
