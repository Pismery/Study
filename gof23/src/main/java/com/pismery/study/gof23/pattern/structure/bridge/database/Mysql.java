package com.pismery.study.gof23.pattern.structure.bridge.database;

import com.pismery.study.gof23.pattern.structure.bridge.filetype.FileType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mysql extends DataBase {

    public Mysql(FileType fileType) {
        super(fileType);
    }

    @Override
    public void exportData() {
        log.debug("get Object Data from Mysql");
        Object data = new Object();
        fileType.transfor(data);
    }
}
