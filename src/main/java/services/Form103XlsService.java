package services;

import entities.Form103XlsSheet;
import model.Form103Model;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Form103XlsService {

    public static void main(String[] args) {
        Form103Model form103Model = new Form103Model();
        generateForm103XlsFile(form103Model.getSheet());
    }

    public static void generateForm103XlsFile(Form103XlsSheet form103XlsSheet){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Form103");

        Row rowDirection = sheet.createRow(0);
        rowDirection.createCell(0).setCellValue("Направление");
        rowDirection.createCell(1).setCellValue(form103XlsSheet.getForm103XlsCellHeaderDescription().getDirection());


        Row rowTypeRegisterMail = sheet.createRow(1);
        rowTypeRegisterMail.createCell(0).setCellValue("Вид РПО");

        Row rowCategoryRegisterMail = sheet.createRow(2);
        rowCategoryRegisterMail.createCell(0).setCellValue("Категория РПО");

        Row rowSender = sheet.createRow(3);
        rowSender.createCell(0).setCellValue("Отправитель");
        rowSender.createCell(2).setCellValue("Сотовый номер №1 отпр");


        Row rowAppointmentsRegion= sheet.createRow(4);
        rowAppointmentsRegion.createCell(0).setCellValue("Регион назначения");
        rowAppointmentsRegion.createCell(2).setCellValue("Сотовый номер №2 отпр.");

        Row rowIndexOPSPlace = sheet.createRow(5);
        rowIndexOPSPlace.createCell(0).setCellValue("Индекс места ОПС приема");
        rowIndexOPSPlace.createCell(2).setCellValue("e-mail отпр.");

        Row rowAllRegisteredMail = sheet.createRow(6);
        rowAllRegisteredMail.createCell(0).setCellValue("Всего РПО");

        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File("form103.xls"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(out);
            out.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
