package practices.practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04 extends TestBase {

    // 1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
    // 2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
    // 3) Sayfaya giriş yapıldığını doğrula
    // 4) Admin butonunun görüdüğünü doğrula,
    // 5) Sayfadan çıkış yap
    // 6) Sayfadan çıkış yapıldığını doğrula

    @Test
    void test01() {
        // 1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // 2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
        WebElement usernameTextBox = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement loginButton = driver
                .findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));

        usernameTextBox.sendKeys("Admin");
        passwordTextBox.sendKeys("admin123");
        loginButton.click();
        waitForSecond(2);

        // 3) Sayfaya giriş yapıldığını doğrula
        WebElement dashboardText = driver
                .findElement(By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"));

        Assertions.assertTrue(dashboardText.isDisplayed());

        // 4) Admin butonunun görüdüğünü doğrula
        WebElement adminButton = driver
                .findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-main-menu-item--name"));
        Assertions.assertTrue(adminButton.isDisplayed());

        // 5) Sayfadan çıkıç yap
        WebElement logoutIcon = driver.findElement(By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon"));
        logoutIcon.click();

        WebElement logoutButton = driver.findElement(By.partialLinkText("Logout"));
        logoutButton.click();

        // 6) Sayfadan Çıkış Yapıldığını Doğrula
        Assertions.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
    }
}
