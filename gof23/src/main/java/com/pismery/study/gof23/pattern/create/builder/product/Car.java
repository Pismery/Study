package com.pismery.study.gof23.pattern.create.builder.product;

import lombok.Data;

@Data
public class Car {
    private Tyre tyre;
    private Enginee enginee;
    private Footbrake footbrake;

    public void run() {
        enginee.start();
        tyre.rolling();
        footbrake.brake();
    }

}
