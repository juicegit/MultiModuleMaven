package org.sonatype.mavenbook.web;

import org.springframework.web.servlet.view.document.AbstractJExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
