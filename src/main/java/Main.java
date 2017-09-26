import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {



    public static void main(String[] args) throws IOException {
        ProductModel model = new ProductModel();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Form103");
        Row rowHeading = sheet.createRow(0);
        rowHeading.createCell(0).setCellValue("Id");
        rowHeading.createCell(1).setCellValue("Name");
        rowHeading.createCell(2).setCellValue("Create Date");
        rowHeading.createCell(3).setCellValue("Price");
        rowHeading.createCell(4).setCellValue("Quality");
        rowHeading.createCell(5).setCellValue("Sub Total");

        for (int i = 0; i < 6; i++) {
            CellStyle styleRowHeading = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontName(HSSFFont.FONT_ARIAL);
            font.setBold(true);
            font.setFontHeightInPoints((short) 11);
            styleRowHeading.setFont(font);
            styleRowHeading.setVerticalAlignment(CellStyle.ALIGN_CENTER);
            rowHeading.getCell(i).setCellStyle(styleRowHeading);
        }


        int r = 1;
        for (Product p : model.findAll()) {
            Row row = sheet.createRow(r);
            Cell cellId = row.createCell(0);
            cellId.setCellValue(p.getId());

            Cell cellName = row.createCell(1);
            cellName.setCellValue(p.getName());

            Cell cellCreateDate = row.createCell(2);
            cellCreateDate.setCellValue(p.getCreateDate());
            CellStyle styleCreateDate = workbook.createCellStyle();
            HSSFDataFormat dataFormat = workbook.createDataFormat();
            styleCreateDate.setDataFormat(dataFormat.getFormat("m/d/yy"));
            cellCreateDate.setCellStyle(styleCreateDate);

            Cell cellPrice = row.createCell(3);
            cellPrice.setCellValue(p.getPrice());
            CellStyle stylePrice = workbook.createCellStyle();
            HSSFDataFormat cf = workbook.createDataFormat();
            stylePrice.setDataFormat(cf.getFormat("$#,##0.00"));
            cellPrice.setCellStyle(stylePrice);

            Cell cellQuality = row.createCell(4);
            cellQuality.setCellValue(p.getQuantity());

            r++;
        }

        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }

        Row rowTotal = sheet.createRow(model.findAll().size() + 1);
        Cell cellTextTotal = rowTotal.createCell(0);
        cellTextTotal.setCellValue("Total");
        CellRangeAddress region = CellRangeAddress.valueOf("A7:E7");
        sheet.addMergedRegion(region);
        CellStyle cellStyle = workbook.createCellStyle();
        Font fontTextTotal = workbook.createFont();
        fontTextTotal.setBold(true);
        fontTextTotal.setFontHeightInPoints((short)11);
        fontTextTotal.setColor(HSSFColor.RED.index);
        cellStyle.setVerticalAlignment(CellStyle.ALIGN_RIGHT);
        cellTextTotal.setCellStyle(cellStyle);

        Cell cellTotalValue = rowTotal.createCell(5);
        cellTotalValue.setCellFormula("sum(D2:D5)");
        HSSFDataFormat dfTotalValue = workbook.createDataFormat();
        CellStyle styleTotalValue = workbook.createCellStyle();
        styleTotalValue.setDataFormat(dfTotalValue.getFormat("$#,##0.00"));
        cellTotalValue.setCellStyle(styleTotalValue);

        FileOutputStream out = new FileOutputStream(new File("form103.xls"));
        workbook.write(out);
        out.close();
        workbook.close();

    }


}

