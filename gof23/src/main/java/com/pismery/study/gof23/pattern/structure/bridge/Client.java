package com.pismery.study.gof23.pattern.structure.bridge;

import com.pismery.study.gof23.pattern.structure.bridge.database.DataBase;
import com.pismery.study.gof23.pattern.structure.bridge.database.Mysql;
import com.pismery.study.gof23.pattern.structure.bridge.database.SqlServer;
import com.pismery.study.gof23.pattern.structure.bridge.filetype.ExcelFile;
import com.pismery.study.gof23.pattern.structure.bridge.filetype.PDFFile;
import com.pismery.study.gof23.pattern.structure.bridge.filetype.XmlFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        tranforFromMysqltoExcel();
        tranforFromMysqltoPDF();
        tranforFromSqlServertoExcel();
        tranforFromSqlServertoXml();
    }

    private static void tranforFromMysqltoExcel() {
        DataBase dataBase = new Mysql(new ExcelFile());
        dataBase.exportData();
        log.debug("");
    }
    private static void tranforFromMysqltoPDF() {
        DataBase dataBase = new Mysql(new PDFFile());
        dataBase.exportData();
        log.debug("");
    }
    private static void tranforFromSqlServertoExcel() {
        DataBase dataBase = new SqlServer(new ExcelFile());
        dataBase.exportData();
        log.debug("");
    }
    private static void tranforFromSqlServertoXml() {
        DataBase dataBase = new SqlServer(new XmlFile());
        dataBase.exportData();
        log.debug("");
    }
}
