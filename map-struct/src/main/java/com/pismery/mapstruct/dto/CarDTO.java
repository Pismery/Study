package com.pismery.mapstruct.dto;

import com.pismery.mapstruct.constant.CarType;
import com.pismery.mapstruct.po.Person;

public class CarDTO {

    private String name;
    private CarType carType;
    private String createDate;

    private Integer seatCount;

    private PersonDTO creator;

    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public PersonDTO getCreator() {
        return creator;
    }
    public void setCreator(PersonDTO creator) {
        this.creator = creator;
    }
    public Integer getSeatCount() {
        return seatCount;
    }
    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
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

    @Override
    public String toString() {
        return "CarDTO{" +
                "name='" + name + '\'' +
                ", carType=" + carType +
                ", createDate='" + createDate + '\'' +
                ", seatCount=" + seatCount +
                ", creator=" + creator +
                '}';
    }
}
