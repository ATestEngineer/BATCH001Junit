package day16_excel_jsexecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcelTest extends TestBase {

    //Go to https://www.bluerentalcars.com/
    //Press the Login button
    //Log in with a username and password you got from the Excel file
    //Verify that you are logged in


    @Test
    void test01() throws IOException {

        //https://www.bluerentalcars.com/ sayfasına gidelim
        driver.get("https://www.bluerentalcars.com/");

        //Login butonuna basalım
        driver.findElement(By.xpath(" //a[. =' Login']")).click();

        //Excel dosyasından aldığımız bir kullanıcı adı ve password ile login olalim
        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        String userEmail = workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String userPassword = workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement emailBox = driver.findElement(By.id("formBasicEmail"));
        WebElement passwordBox = driver.findElement(By.id("formBasicPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        emailBox.sendKeys(userEmail);
        passwordBox.sendKeys(userPassword);
        loginButton.click();

        //Login olduğumuzu doğrulayalım
        WebElement loginVerify = driver.findElement(By.id("dropdown-basic-button"));
        Assertions.assertEquals("ayhan can", loginVerify.getText());

    }
}
