package day17_jsexecutor_log4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Log4j extends TestBase {

    @Test
    void test01() {

        Logger logger = LogManager.getLogger(C03_Log4j.class);

        driver.get("https://amazon.com");
        logger.info("Amazon web sayfasına gidildi");


        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("arama kutusu locate edildi");

        searchBox.sendKeys("laptop");
        logger.info("arama kutusunda laptop aratıldı");


        logger.info("sayfa kapatılır");
        driver.quit();

    }








}
