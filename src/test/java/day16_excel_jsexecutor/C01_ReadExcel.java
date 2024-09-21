package day16_excel_jsexecutor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {


    @Test
    void test01() throws IOException {

        String path = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);


        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell = workbook.getSheet("Sheet1").getRow(0).getCell(1);
        System.out.println("Cell = " + cell);

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String actualCell = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("actualCell = " + actualCell);
        Assertions.assertEquals("France", actualCell);


        //Örnek 3: Kullanılan satır sayısın bulun ( getPhysicalNumberOfRows() methodu, sadece dolu satır sayısını bulur)
        System.out.println("Satır sayısı= " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());


        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        // satır 5 ise, bu method index mantığıyla çalışarak bize 4 sayısını döndürür
        System.out.println("Son satır indexi = " + workbook.getSheet("Sheet1").getLastRowNum());


        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}


        Map<String, String> countryCapital = new LinkedHashMap<>();
        for (int i = 0; i <= workbook.getSheet("Sheet1").getLastRowNum(); i++) {

            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            countryCapital.put(country,capital); //country'i key'e ekle, capital'i de value'ya ekle dedik.
        }

        System.out.println("countryCapital = " + countryCapital);

    }
}
