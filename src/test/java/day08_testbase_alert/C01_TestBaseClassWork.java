package day08_testbase_alert;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class C01_TestBaseClassWork extends TestBase {

    @Test
    void test01() {
        driver.get("https://www.amazon.com");

        waitForSecond(1);
    }

}
