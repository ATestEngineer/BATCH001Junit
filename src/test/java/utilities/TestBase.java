package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {

    protected WebDriver driver;

    //default hali private oldugu için, protected yaptık. private kalsaydı başka packagelardan kullanamayacaktık
    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;

    public void createExtentReport(String testName){

        //Bu objeyi raporları oluşturmak ve başlatmak için kullanacağız
        extentReports = new ExtentReports();

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

            extentTest=extentReports.createTest(testName, "Test Steps");
    }



    @BeforeEach
    void setUp() {  //kurtulduk!!!
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }

    //HARD WAIT
    public void waitForSecond(int second) {
        try {
            Thread.sleep(second * 1000); //saniyeyi dinamik aldık.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //DropDown Menu

    //selectVisibleText
    public void selectVisible(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //selectIndex
    public void selectIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void getFirstSelectedOption(WebElement ddm){
        Select select = new Select(ddm);
        select.getFirstSelectedOption();
    }


    //index ile window handle
    public void switchToWindow(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //File Upload Robot Class
    public void uploadFilePath(String dosyaYolu) {
        try {
            waitForSecond(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere sistem panosuna kopyalamaktır.
            Robot robot = new Robot();
            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini simüle eder.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            // CTRL ve V tuşlarından elini kaldirir
            robot.delay(3000);
            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.delay(3000);
            // Sonraki işlemler için ek 3 saniye bekler.
        } catch (Exception ignored) {
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }


    }


    //TAM EKRAN SCREENSHOT
    public void screenShot(){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\screenshots\\screenShot"+date+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(path) , ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WEB ELEMENT SCREENSHOT
    public void screenShotOfWebElement(WebElement webElement){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\screenshots\\webElementSS"+date+".png";
        try {
            Files.write(Paths.get(path), webElement.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //TAM EKRAN SCREENSHOT'I HTML EXTENT RAPORA EKLEME:
    public void addscreenShotToReport(){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\screenshots\\screenShot"+date+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(path) , ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\"+path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WEB ELEMENT SCREENSHOT'I HTML EXTENT REPORT'A EKLEME:
    public void addScreenShotOfWebElementToReport(WebElement webElement){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src\\test\\java\\screenshots\\webElementSS"+date+".png";
        try {
            Files.write(Paths.get(path), webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\"+path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // JS EXECUTOR CLICK METHOD
    public void jsClick(WebElement webElement){
        try {
          webElement.click();

        } catch (Exception e) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", webElement);

        }
    }

    // JS EXECUTOR İLE WEB ELEMENTE SCROLL
    public void jsScrollToWebElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", webElement );
    }


    //JS EXECUTOR İLE SCROLLEND
    public void jsScrollEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS EXECUTOR İLE SCROLLHOME
    public void jsScrollHome(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS EXECUTOR İLE SENDKEYS
    public void jsSendKeys(WebElement element, String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + value + "'",element);
    }



















}
