package com.pismery.mapstruct.po;

import com.pismery.mapstruct.constant.CarType;

import java.util.Date;

public class Car {

    private String name;
    private CarType carType;
    private Integer numberOfSeats;

    private Date createDate;

    private Person creator;


    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Person getCreator() {
        return creator;
    }
    public void setCreator(Person creator) {
        this.creator = creator;
    }
    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CarType getCarType() {
        return carType;
    }
    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
