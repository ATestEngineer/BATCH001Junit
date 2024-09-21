package day12_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    void test01() {

       //Files.exists(Paths.get(""));

        System.out.println(System.getProperty("user.dir")); //bu komut, üzerinde çalışılan dizini verir (current working directory)


        //C:\IntelliJ IDEA\Selenium  >> Niyazi
        //C:\Users\cagri\IdeaProjects\QA001Selenium >> Esra

        System.out.println(System.getProperty("user.home"));  //bu komut size, home directory'i verir. yani herkeste değişen kısım.

        /*
        Bilgisayarimizda bulunan  herhangi bir dosyanin varligini test edebilmemiz icin ;
        öncelikle varligini test etmek istedigimiz dosyanin yolunu almaliyiz
        Sonra ise Files.exists(Paths.get("")); methodu ile test gerceklestireceğiz

        Ortak çalışmalarda her kullanıcının bilgisayarının ana yolu farklıdır,
        ama üzerinde çalışılan projedeki dosya yolu aynıdır.

        Bunun için herkeste farklı olan kısmı System.getProperty("user.home") kodu ile alıp
        herkeste aynı olan kısım ile birleştirerek dynamic path elde edeceğiz
         */

        //         C:\Users\artis             \OneDrive\Masaüstü\Batch001.txt   >> dosya yolumuz

        String ortakYol = "\\OneDrive\\Masaüstü\\Batch001.txt";

        String dynamicPath = System.getProperty("user.home") + ortakYol;

        Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));

        /*
        Files.exists(Paths.get(dynamicPath) methodunu kullanarak belirtmis oldugumuz path'in
        dosya sistemimizde var olup olmadigini kontrol ettik
         */


    }
}
