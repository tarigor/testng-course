package parameterization;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;


public class TestParameterizationExcel {

    @DataProvider(name = "testData")
//    public static Object[][] getData() throws IOException {
//        XSSFWorkbook excelBook = new XSSFWorkbook(new FileInputStream("e:\\userTest.xlsx"));
//        XSSFSheet excelSheet = excelBook.getSheet("Sheet1");
//        Object[][] dataFromExcel = new Object[excelSheet.getLastRowNum()][excelSheet.getRow(0).getLastCellNum()];
//        for (int i = 0; i < excelSheet.getLastRowNum(); i++) {
//            for (int j = 0; j < excelSheet.getRow(0).getLastCellNum(); j++) {
//                dataFromExcel[i][j] = excelSheet.getRow(i + 1).getCell(j).getStringCellValue();
//                System.out.print(dataFromExcel[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("row 0: " + dataFromExcel[0][0]);
//        return dataFromExcel;
//    }
    public static Object[][] getData(Method method) throws IOException {

        String filePath = "";
        if (method.getName().equals("userTest")) {
            filePath = "e:\\userTest.xlsx";
        } else if (method.getName().equals("loginTest")) {
            filePath = "e:\\loginTest.xlsx";
        }

        XSSFWorkbook excelBook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet excelSheet = excelBook.getSheet("Sheet1");
        Object[][] dataFromExcel = new Object[excelSheet.getLastRowNum()][1];
        Hashtable<String, String> table = null;
        for (int i = 0; i < excelSheet.getLastRowNum(); i++) {
            table = new Hashtable<String, String>();
            for (int j = 0; j < excelSheet.getRow(0).getLastCellNum(); j++) {
                table.put(excelSheet.getRow(0).getCell(j).getStringCellValue(), excelSheet.getRow(i + 1).getCell(j).toString());
                dataFromExcel[i][0] = table;
            }
        }
        return dataFromExcel;
    }

    @Test(dataProvider = "getData")
//    public void test(String user, String password, String is_correct) {
//        System.out.println(user + "-----" + password + "-----" + is_correct);
//    }
    public void test(Hashtable<String, String> data) {
        System.out.println(data.get("user") + "---" + data.get("password") + "---" + data.get("is_correct") + "---" + data.get("age") + "---" + data.get("gender") + "---");
    }
}
