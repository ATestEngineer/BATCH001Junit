package day02_drivermethods_implicitlywait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ImplicitlyWait {
    public static void main(String[] args) {
        //Go to TechProEducation page
        //test that the page title contains "TechPro Education"
        //go to facebook page
        //test that the page url contains "facebook"
        //go back to techpro page
        //Test that you are back
        //close the page

        //techpro sayfasina gidiniz
        //sayfa basliginin "TechPro Education" icerdigini test ediniz
        //facebook sayfasina gidiniz
        //sayfa url'inin "facebook" icerdigini test ediniz
        //techpro sayfasina geri donunuz
        //geri dondugunuzu test ediniz
        //sayfayi kapatiniz

        //1
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //boş bır browser acıyordu.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //sayfadaki tüm elementlerin yüklenmesini max. 15 sn süreyle bekle dedik.

        //techpro sayfasina gidiniz
        driver.get("https://www.techproeducation.com/");

        //sayfa basliginin "TechPro Education" icerdigini test ediniz
        String expectedData = "TechPro Education"; // Benim gereksinimim, BEKLENEN DATAM "TechPro Education"
        String actualData = driver.getTitle(); // actual data, her zaman DRİVERDAN GELİR.

        if (actualData.contains(expectedData)){ //actualdata, sen içeriyor musun expected datayı?
            System.out.println("TEST PASSED"); //eger ki içeriyorsan test geçsin
        } else { // aksi takdirde
            System.out.println("TEST FAILED"); // içermiyorsan test kalsın
        }

        //facebook sayfasina gidiniz
        driver.get("https://www.facebook.com");

        //sayfa url'inin "facebook" icerdigini test ediniz
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //techpro sayfasina geri donunuz
        driver.navigate().back();

        //geri dondugunuzu test ediniz
        /*
        1. her sayfanın title ı genelde kendıne özgü oldugu için title uzerınden test edebilirz.
        2. url ile test edebilirz.
         */

        //1.yol Title: TechPro Education IT Programs
        if (driver.getTitle().equals("TechPro Education IT Progra")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        //sayfayi kapatiniz
        driver.close();


    }

}
