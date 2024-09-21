package day14_screenshot_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C05_ExtentReport {

    /*
    ExtentReport kullanabilmek icin 3 class a ihtiyac vardir.
    1) ExtentReports classindan raporlamayi baslatmak icin bir object olusturmamiz gerekir
    2) ExtentHtmlReporter classindan raporlari html formatinda olusturmasi icin object olusturmamiz gerekir
    3) ExtentTest classindan test adimlarina bilgi ekleyebilmek icin bir object olusturmamiz gerekir
     */

    //Bunlardan biri bile olmazsa, rapor OLUŞMAZ!
    ExtentReports extentReports; //raporlamayı başlatacak
    ExtentHtmlReporter extentHtmlReporter; //raporlamayı html formatında oluşturacak
    ExtentTest extentTest; //test adımlarına bilgi ekleyecek

    @Test
    void extentReportTemplate() { //bu methodun içerisindeki kodlar sadece 1 kez yazılacak. Bizim için alt yapıyı (şablonu) oluşturacak

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

        /*======================================buraya kadar şablon tamamlandı=======================================================*/

        //Testin başarılı olduğunu belirtir ve rapora PASS ekler
        extentTest.pass("PASS");

        //Testle ilgili bilgilendirme notu ekler
        extentTest.info("BİLGİLENDİRME NOTU");

        //Testin başarısız olduğunu belirtir ve rapora FAIL ekler
        extentTest.fail("FAIL MESAJI");

        //Test ile ilgili uyarı mesajı verir
        extentTest.warning("UYARI MESAJI");

        //Testin atlandığını belirten mesaj ile rapora ekler
        extentTest.skip("ATLATMA MESAJI");

        //Tüm test verilerini kaydeder ve HTML raporu oluşturur. BUNU UNUTURSAK RAPOR OLUŞMAZ!!
        extentReports.flush();

    }
}
