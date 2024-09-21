package day13_seleniumwaits_exceptions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class C05_NullPointerException {
     //kullanmak istediğiniz objenin değeri henüz NULL ise, başlatılmadıysa bu hata alınır. ve bu hata javadan gelir

    WebDriver driver;
    Faker faker;
    Actions action;
    String str;

    /*
    NullPointerException
    Eger bir object yada variable olusturup bu olusturdugumuz objeye assignment yapmadan kullanmak istersek
    bu hatayi aliriz,
    Cünkü javada degeri null olan bir object ile etkilesim yapilmasina izin vermez
     */

    @Test
    void test01() {

        driver = new ChromeDriver();
        driver.get("https://google.com");

    }

    @Test
    void test02() {
        faker = new Faker();
        System.out.println(faker.name().fullName());

    }

    @Test
    void test03() {
        action.build();
    }

    @Test
    void test04() {
        System.out.println(str.length());
    }
}
