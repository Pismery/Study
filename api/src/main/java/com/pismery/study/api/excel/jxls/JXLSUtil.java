package com.pismery.study.api.excel.jxls;

import org.jxls.common.Context;
import org.jxls.template.SimpleExporter;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.util.*;

public class JXLSUtil {

    public static final String TEMPLATE_PATH = System.getProperty("user.dir") + "/src/main/resources/template/";
    public static final String REPORT_PATH = System.getProperty("user.dir") + "/src/main/resources/report/";

//    public static final String TEMPLATE_PATH = JXLSUtil.class.getClassLoader().getResource("template").getPath();
//    public static final String REPORT_PATH = JXLSUtil.class.getClassLoader().getResource("report").getPath();


    public static void generateTableExcel(List<Employee> data) throws IOException {
        List<String> headers = Arrays.asList("Name", "BirthDate", "Payment", "Bonus");
        String objectProps = "name,birthDate,payment,bonus";
        try (InputStream is = new FileInputStream(new File(TEMPLATE_PATH, "simple_exporter_template.xlsx"))) {
            try (OutputStream os = new FileOutputStream(new File(REPORT_PATH,"simple_exporter_report.xlsx"))) {
                SimpleExporter simpleExporter = new SimpleExporter();
                simpleExporter.registerGridTemplate(is);
                simpleExporter.gridExport(headers, data, objectProps, os);
            }
        }
    }

    public static void generateMultiSheetExcel(Map<String,Object> model,String templateName,String reportName) throws IOException{
        try (InputStream is = new FileInputStream(new File(TEMPLATE_PATH, templateName))) {
            File reportPath = new File(REPORT_PATH);
            if (!reportPath.exists())
                reportPath.mkdir();

            try (OutputStream os = new FileOutputStream(new File(REPORT_PATH, reportName))) {
                Context ctx = new Context();
                model.forEach(ctx::putVar);
                JxlsHelper.getInstance().setUseFastFormulaProcessor(false).processTemplate(is, os, ctx);
            }
        }

    }

    public static void generateExcel(Map<String, Object> model, String templateName, String reportName) throws IOException {
        try (InputStream is = new FileInputStream(new File(TEMPLATE_PATH, templateName))) {
            File reportPath = new File(REPORT_PATH);
            if (!reportPath.exists())
                reportPath.mkdir();

            try (OutputStream os = new FileOutputStream(new File(REPORT_PATH, reportName))) {
                Context ctx = new Context();
                model.forEach(ctx::putVar);

//                JxlsHelper instance = JxlsHelper.getInstance();
//                Transformer transformer = instance.createTransformer(is, os);
//                instance.processTemplate(ctx,transformer);

                JxlsHelper.getInstance().processTemplate(is, os, ctx);
            }
        }
    }

}
