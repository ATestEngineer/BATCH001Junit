package day02_drivermethods_implicitlywait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethods {

    public static void main(String[] args) throws InterruptedException {
        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        //Sayfanin olculerini yazdirin
        //Sayfayi simge durumuna getirin
        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        //Sayfanin olculerini maximize durumunda yazdirin
        //Sayfayi fullscreen yapin
        //Sayfanin olculerini fullscreen durumunda yazdirin
        //Sayfayi kapatin

        //1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");

        //Sayfanin olculerini yazdirin
        System.out.println("Sayfanın ölçüleri = " + driver.manage().window().getSize());

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //Sayfanin olculerini maximize durumunda yazdirin
        System.out.println("Sayfanın ölçüleri = " + driver.manage().window().getSize());

        //Sayfayi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        //Sayfanin olculerini fullscreen durumunda yazdirin
        System.out.println("Sayfanın ölçüleri = " + driver.manage().window().getSize());

        //Oturumu kapatin
        Thread.sleep(3000);
        driver.quit();

    }
}
