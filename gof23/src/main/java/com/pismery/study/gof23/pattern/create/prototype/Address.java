package com.pismery.study.gof23.pattern.create.prototype;

import lombok.Data;

@Data
public class Address {

    private String country;
    private String province;

    public Address() {
    }

    public Address(String country, String province) {
        this.country = country;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
