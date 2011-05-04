package org.sonatype.mavenbook.web;

import jxl.write.Label;
import jxl.write.WritableSheet;
import org.sonatype.mavenbook.weather.model.Weather;
import org.springframework.web.servlet.view.document.AbstractJExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * User: chq-justinh
 * Date: 4/29/11
 * Time: 4:45 PM
 * <p/>
 * Class Description
 */
public class ExcelHistoryView extends AbstractJExcelView {
    @Override
    protected void buildExcelDocument(Map model, jxl.write.WritableWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Weather> weathers = (List<Weather>) model.get("weathers");
        //create a worksheet
        WritableSheet sheet = workbook.createSheet("Weather", 0);

        sheet.addCell(new Label(0, 0, "Date"));
        sheet.addCell(new Label(1, 0, "Temp"));

        int rowNum = 1;
        for (Weather weather : weathers) {
            //create the row data
            sheet.addCell(new Label(0, rowNum, weather.getDate().toString()));
            sheet.addCell(new Label(1, rowNum, weather.getCondition().getTemp()));
            rowNum++;
        }

    }
}
