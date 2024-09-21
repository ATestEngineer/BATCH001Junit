package day16_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {


    @Test
    void test01() throws IOException {

        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis); // şu anda javada excel dosyasına çift tıklayarak excel dosyasını açtınız

       Sheet sheet = workbook.getSheet("customer_info");
       Row row = sheet.getRow(0);

       //Üçüncü sütunu oluştur
        Cell cell3 = row.createCell(2);

        //Üçüncü cell'in value'sunu STATUS olarak ayarlayalım
        cell3.setCellValue("STATUS");

        //İkinci satırın üçüncü hücresini oluşturacağız ve bu hücrenin değerini "valid" olarak ayarla
        sheet.getRow(1).createCell(2).setCellValue("valid");

        //Üçüncü satırın üçüncü hücresini oluşturacağız ve bu hücrenin değerini "valid" olarak ayarla
        sheet.getRow(2).createCell(2).setCellValue("valid");

        //Dördüncü satırın üçüncü hücresini oluşturacağız ve bu hücrenin değerini "invalid" olarak ayarla
        sheet.getRow(3).createCell(2).setCellValue("invalid");


        FileOutputStream fos = new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");
        workbook.write(fos); //akışımızı (kodlarımızı) excele (workbook) yaz.

        fis.close();
        fos.close();

    }

    /* HOMEWORK!!
      Bir "Name" sütunu oluşturup isimlerini excel doyasına yazınız:
      ("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam")
  */
}
