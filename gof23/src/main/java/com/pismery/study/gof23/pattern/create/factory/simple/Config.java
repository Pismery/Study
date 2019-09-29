package com.pismery.study.gof23.pattern.create.factory.simple;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "createCar.simplefactory")
public class Config {
    private String cartype;
}
