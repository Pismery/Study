package com.pismery.study.gof23.pattern.structure.bridge.database;

import com.pismery.study.gof23.pattern.structure.bridge.filetype.FileType;

public abstract class DataBase {
    protected FileType fileType;

    public DataBase(FileType fileType) {
        this.fileType = fileType;
    }

    public abstract void exportData();
}
