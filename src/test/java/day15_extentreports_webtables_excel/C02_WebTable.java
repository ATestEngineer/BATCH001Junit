package day15_extentreports_webtables_excel;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {

    @Test
    void test01() {
        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
       WebElement table1 = driver.findElement(By.xpath("//table[1]"));
       System.out.println(table1.getText());

       System.out.println("===========================");


        //Task 2 : 3. Row’(satır) datalarını print edin
        WebElement thirdRow = driver.findElement(By.xpath("//table[1]/tbody/tr[3]"));
        System.out.println(thirdRow.getText());

        System.out.println("===========================");


        //Task 3 : Son row daki dataları print edin
        WebElement lastRow = driver.findElement(By.xpath("//table[1]/tbody/tr[last()]"));
        System.out.println(lastRow.getText());

        System.out.println("===========================");


        //Task 4 : 5. Column(sütun) datalarini print edin
        List<WebElement> fifthColumn = driver.findElements(By.xpath("//table[1]/tbody/tr/td[5]"));

        //1.yol
        for (WebElement w : fifthColumn){
            System.out.println(w.getText());
        }

        //2.yol lambda
        //fifthColumn.forEach(t-> System.out.println(t.getText()));


        //Task 5 : Iki parametreli bir Java metot oluşturalım:
        // printData  Parameter 1 = row numarası
        // Parameter 2 = column numarası
        //  örnek: printData(2,3); = 2nd satır, 3rd sütundaki datayı print etsin

        printData(2,3);
        printData(2,2);
        printData(1,1);

    }

    private void printData(int satir, int sutun) {
        WebElement webElement = driver.findElement(By.xpath("//table[1]/tbody/tr["+satir+"]/td["+sutun+"]"));
        System.out.println(webElement.getText());
    }
}
