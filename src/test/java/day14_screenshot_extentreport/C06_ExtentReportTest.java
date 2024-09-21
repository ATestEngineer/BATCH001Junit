package day14_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C06_ExtentReportTest extends TestBase {


    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;

    @Test
    void test01() { //bu methodun içerisindeki kodlar sadece 1 kez yazılacak. Bizim için alt yapıyı (şablonu) oluşturacak

        //Bu objeyi raporları oluşturmak ve başlatmak için kullanacağız
        extentReports = new ExtentReports();

        /*
        Oncelikle olusturmak istedigimz html reportu project imizde nerede saklamak istiyorsak bir dosya yolu
        olusturmaliyiz, cunku bu path i kullanarak bir tane html report olusturacağız
        bunun icin ExtentHtmlReporter classindan object olusturmaliyiz
         */

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/"+date+"htmlReport.html";

        //html raporu oluşturmak için kullanacağız
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // extentReports ile extentHtmlReporter'ı birbirlerine ekledik. Bu raporun html formatında oluşturulmasını sağlar.
        extentReports.attachReporter(extentHtmlReporter);

        //buraya kadar boş bir html sayfası açıldı

        //HTML raporunun Title'ını ayarlar, browser sekmesinde görünür
        extentHtmlReporter.config().setDocumentTitle("Batch QA001 Test Report");

        //Raporun adını ayarlar, genel bir başlık sunar
        extentHtmlReporter.config().setReportName("My Extent Report");

        //HTML raporunda görmek isteyebileceğimiz bilgileri "key, value" şeklinde yazabiliriz
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Veli Can");

        extentTest=extentReports.createTest("Amazon Test", "Test Steps");


        //TechproEducation sayfasina gidelim https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");
        extentTest.info("Kullanıcı Techpro sayfasına gider");

        //TechproEducation ana sayfada oldugunuzu dogrulayin
        Assertions.assertEquals("https://www.techproeducation.com/" , driver.getCurrentUrl());
        extentTest.info("Kullanıcı anasayfada olduğunu doğrular");
        extentTest.pass("Ana sayfa url testi başarılı");

        //Ana Sayfada sosyal medya iconlarinin goruntulendigini dogrulayin
         WebElement icons = driver.findElement(By.className("toolbar-sl-share"));
         Assertions.assertTrue(icons.isDisplayed());
         extentTest.info("Kullanıcı sosyal medya ikonlarını kontrol eder");
         extentTest.pass("Iconlar görüntülendi");

         extentReports.flush();


    }
}
