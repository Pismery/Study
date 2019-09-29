package com.pismery.study.gof23.pattern.structure.bridge.filetype;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlFile implements FileType {
    @Override
    public void transfor(Object data) {
        log.debug("Tranfor data to Xml...");
    }
}
