package day01_firstdriversetting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C02_Driver {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();

        Thread.sleep(3000);
        chromeDriver.get("https://google.com");

        Thread.sleep(3000);
        chromeDriver.quit();

        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://google.com");
        //edgeDriver.quit();

    }
}
