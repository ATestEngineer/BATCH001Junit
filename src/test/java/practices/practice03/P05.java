package practices.practice03;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P05 extends TestBase {
    //        Go to amazon  https://www.amazon.com/
    //        Find the total number of cookies
    //        Print all the cookies
    //        Get the cookies by their name
    //        Add new cookie
    //        Delete all cookies

    @Test
    void cookiesTest() {

        // Amazon'a git https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        waitForSecond(3);

        // Toplam çerez sayısını bulun
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("Total Cookies = " + allCookies.size());

        System.out.println("------------------------------------------------");

        // Tüm çerezleri yazdır
        for (Cookie w : allCookies){
            System.out.println("Cookie = " + w);
            System.out.println("Cookie Name = " + w.getName());
            System.out.println("Cookie Value = " + w.getValue());
        }

        System.out.println("----------------------------------------------");

        // Çerezleri adlarına göre al
        System.out.println("Cookie Name'ine göre alındı = " + driver.manage().getCookieNamed("csm-sid"));

        System.out.println("---------------------------------------------------");

        // Yeni çerez ekle
        Cookie myFavCookie = new Cookie("My Cookie", "Üzümlü");
        driver.manage().addCookie(myFavCookie);
        waitForSecond(3);
        for (Cookie w : driver.manage().getCookies()){
            System.out.println(w);
        }

        System.out.println("----------------------------------");

        // Tüm çerezleri sil
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed(myFavCookie.toString());
        waitForSecond(3);

        System.out.println("Tüm çerezler silindikten sonra = " + driver.manage().getCookies().size() + "  çerez kaldı");

    }
}
