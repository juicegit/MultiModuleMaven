package org.sonatype.mavenbook.web;

import junit.framework.TestCase;
import jxl.*;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import org.sonatype.mavenbook.weather.model.Condition;
import org.sonatype.mavenbook.weather.model.Weather;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;
import java.util.regex.Pattern;

/**
 * User: chq-justinh
 * Date: 5/3/11
 * Time: 4:49 PM
 * <p/>
 * Class Description
 */
public class ExcelHistoryViewTest extends TestCase {

    public void testBuildExcelDocument() throws Exception {
        ExcelHistoryView view = new ExcelHistoryView();
        final HashMap model = new HashMap();
        List<Weather> weathers = new ArrayList<Weather>();
        final Weather weather = new Weather();
        weather.setDate(new Date());
        weather.setCondition(new Condition());
        weather.getCondition().setTemp("75.2");
        weathers.add(weather);
        model.put("weathers", weathers);
        view.buildExcelDocument(model, new MockWritableWorkbook(), new MockHttpServletRequest(), new MockHttpServletResponse());

    }

    private static class MockWritableWorkbook extends WritableWorkbook {
        @Override
        public WritableSheet[] getSheets() {
            return new WritableSheet[0];  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public String[] getSheetNames() {
            return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public WritableSheet getSheet(int i) throws IndexOutOfBoundsException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public WritableSheet getSheet(String s) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public WritableCell getWritableCell(String s) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public int getNumberOfSheets() {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void close() throws IOException, WriteException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public WritableSheet createSheet(String s, int i) {
            return new WritableSheet() {
                public void addCell(WritableCell writableCell) throws WriteException, RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setName(String s) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setHidden(boolean b) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setProtected(boolean b) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setColumnView(int i, int i1) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setColumnView(int i, int i1, CellFormat cellFormat) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setColumnView(int i, CellView cellView) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setRowView(int i, int i1) throws RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setRowView(int i, boolean b) throws RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setRowView(int i, int i1, boolean b) throws RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setRowView(int i, CellView cellView) throws RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public WritableCell getWritableCell(int i, int i1) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public WritableCell getWritableCell(String s) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public WritableHyperlink[] getWritableHyperlinks() {
                    return new WritableHyperlink[0];  //To change body of implemented methods use File | Settings | File Templates.
                }

                public void insertRow(int i) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void insertColumn(int i) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void removeColumn(int i) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void removeRow(int i) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public Range mergeCells(int i, int i1, int i2, int i3) throws WriteException, RowsExceededException {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setRowGroup(int i, int i1, boolean b) throws WriteException, RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void unsetRowGroup(int i, int i1) throws WriteException, RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setColumnGroup(int i, int i1, boolean b) throws WriteException, RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void unsetColumnGroup(int i, int i1) throws WriteException, RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void unmergeCells(Range range) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void addHyperlink(WritableHyperlink writableHyperlink) throws WriteException, RowsExceededException {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void removeHyperlink(WritableHyperlink writableHyperlink) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void removeHyperlink(WritableHyperlink writableHyperlink, boolean b) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setHeader(String s, String s1, String s2) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setFooter(String s, String s1, String s2) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setPageSetup(PageOrientation pageOrientation) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setPageSetup(PageOrientation pageOrientation, double v, double v1) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void setPageSetup(PageOrientation pageOrientation, PaperSize paperSize, double v, double v1) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void addRowPageBreak(int i) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void addColumnPageBreak(int i) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public void addImage(WritableImage writableImage) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public int getNumberOfImages() {
                    return 0;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public WritableImage getImage(int i) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public void removeImage(WritableImage writableImage) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                public Cell getCell(int i, int i1) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Cell getCell(String s) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public int getRows() {
                    return 0;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public int getColumns() {
                    return 0;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Cell[] getRow(int i) {
                    return new Cell[0];  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Cell[] getColumn(int i) {
                    return new Cell[0];  //To change body of implemented methods use File | Settings | File Templates.
                }

                public String getName() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public boolean isHidden() {
                    return false;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public boolean isProtected() {
                    return false;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Cell findCell(String s) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Cell findCell(String s, int i, int i1, int i2, int i3, boolean b) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Cell findCell(Pattern pattern, int i, int i1, int i2, int i3, boolean b) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public LabelCell findLabelCell(String s) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Hyperlink[] getHyperlinks() {
                    return new Hyperlink[0];  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Range[] getMergedCells() {
                    return new Range[0];  //To change body of implemented methods use File | Settings | File Templates.
                }

                public SheetSettings getSettings() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public CellFormat getColumnFormat(int i) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public int getColumnWidth(int i) {
                    return 0;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public CellView getColumnView(int i) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public int getRowHeight(int i) {
                    return 0;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public CellView getRowView(int i) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public Image getDrawing(int i) {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                public int[] getRowPageBreaks() {
                    return new int[0];  //To change body of implemented methods use File | Settings | File Templates.
                }

                public int[] getColumnPageBreaks() {
                    return new int[0];  //To change body of implemented methods use File | Settings | File Templates.
                }
            };  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public WritableSheet importSheet(String s, int i, Sheet sheet) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void copySheet(int i, String s, int i1) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void copySheet(String s, String s1, int i) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void removeSheet(int i) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public WritableSheet moveSheet(int i, int i1) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void write() throws IOException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setProtected(boolean b) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setColourRGB(Colour colour, int i, int i1, int i2) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public WritableCell findCellByName(String s) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Range[] findByName(String s) {
            return new Range[0];  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public String[] getRangeNames() {
            return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void removeRangeName(String s) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void addNameArea(String s, WritableSheet writableSheet, int i, int i1, int i2, int i3) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setOutputFile(File file) throws IOException {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
