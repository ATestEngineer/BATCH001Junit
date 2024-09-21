package day03_junit;

import org.junit.jupiter.api.*;

public class C02_BeforeAfter {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll notasyonuna sahip olan bir method, tüm test methodlarından önce 1 kez çalıştırılır.");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach notasyonuna sahip olan bir method, her bir test methodundan önce 1 kez çalıştırılır.");
    }


    @Test
    void test01() {
        System.out.println("test01 çalıştı");
    }

    @Test
    void test02() {
        System.out.println("test02 çalıştı");
    }

    @Test @Disabled
    void test03() {
        System.out.println("test03 çalıştı");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach notasyonuna sahip olan bir method, her bir test methodundan sonra 1 kez çalıştırılır.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll notasyonuna sahip olan bir method, tüm test methodlarından sonra 1 kez çalıştırılır.");
    }




















}
