package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDownMenu {


    /*DROPDOWN

    Dropdown u automate etmek icin;
    1- Dropdown menuyu ilk olarak locate ederiz.
    2- Select objecti olusturulur
    3- Select objecti uzerinden cesitli methodlar sayesinde dropdown seceneklerine erisim saglariz
        SYNTAX
        Select options = new Select(Webelement dropdown);
        a- selectByVisibleText() -> dropdown menudeki gorunur Text ile ulasmak icin kullanilir
        b- selectByIndex() -> Index ile ulasmak icin kullanilir. (index 0 dan baslar)
        c- selectByValue() -> value attribute deegeri ile ulasmak icin kullanilir

    4- getOptions() -> Locate ettigimiz dropdown menudeki tum secenekleri bize verir
    5- getFirstSelectedOption() -> Dropdown menudeki secili olan secenegi bize verir
     */

    // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    // 3 farklı test methodu oluşturalım
    //     1.Method:
    //         a. Yil,ay,gün dropdown menu'leri locate ediniz
    //         b. Select objesi olustur
    //         c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    //     2.Method:
    //         a. Tüm eyalet isimlerini yazdıralım
    //     3.Method:
    //         a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim


    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }


    @Test
    void test01() {        //     1.Method:

        //         a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));


        //         b. Select objesi olustur
        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);


        //         c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        selectYear.selectByIndex(0); //index 0dan baslar. 0 yazdigimzda 1. element secilir.
        selectMonth.selectByValue("4"); //<option value="4">May</option> =>buradaki value ya gore secilir
        selectDay.selectByVisibleText("15"); // ekranda gorulen Text e göre secilir
    }

    @Test
    void test02() {    //           2.Method

        //         a. Tüm eyalet isimlerini yazdıralım
        WebElement states = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(states);

        //Birinci yol
        List<WebElement> statesList = select.getOptions();

        for (WebElement w: statesList){
            System.out.println(w.getText());
        }

        //Ikinci yol LAMBDA
        statesList.forEach(t-> System.out.println(t.getText()));
    }


    @Test
    void test02a() {
        List<WebElement> statesList = driver.findElements(By.xpath("//select[@id='state']/option"));
        statesList.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    void test03() {
        //     1.Method:

        //         a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        year.sendKeys("2021");
        month.sendKeys("May");
        day.sendKeys("19");

        

    }

    @Test
    void test04() {
        //     3.Method:
        //         a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

        WebElement states = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(states);
        String actualOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Select a State";
        Assertions.assertEquals(expectedOption, actualOption);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}


