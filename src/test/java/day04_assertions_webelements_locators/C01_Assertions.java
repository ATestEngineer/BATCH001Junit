package day04_assertions_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {

    /*
    Junıt4 te Assertion ilke doğrulama yaoarken, assert.true - assert.equals gibi methodları çağırmak için "Assert" classı kullanılıyordu.
    Junıt5te ise  "Assertions" classsı kullanılıyor.
     */


    @Test
    void test01() {

        String expectedData = "Hello!";
        String actualData = "Hello!";
        Assertions.assertEquals(expectedData, actualData);
    }

    @Test
    void test02() {

        int number = 5;
        Assertions.assertTrue(number>0);
    }

    @Test
    void test03() {
        Assertions.assertFalse("selenium".contains("e"));
    }

    @Test
    void test04() {

        Assertions.assertNotEquals("selenium", "junit");
    }


    @Test
    void test05() {

        char[] expectedArray = {'a', 'b', 'c'};
        char[] actualArray = {'a', 'B', 'c'};

        Assertions.assertArrayEquals(expectedArray, actualArray);
        // İki arrayin birbirine eşit olabilmesi için, aynı indexte aynı değerler olmalı.

    }

    @Test
    void test06() {

        String str = null;
        Assertions.assertNull(str);
    }

    // Parantez içindeki değer null ise test geçer, değilse test kalır.


    @Test
    void test07() {
        String str = "Hello!";
        Assertions.assertNotNull(str);
    }


}
