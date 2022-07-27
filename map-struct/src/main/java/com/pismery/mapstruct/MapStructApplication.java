package com.pismery.mapstruct;

import com.pismery.mapstruct.constant.CarType;
import com.pismery.mapstruct.constant.Gender;
import com.pismery.mapstruct.dto.CarDTO;
import com.pismery.mapstruct.map.CarMapper;
import com.pismery.mapstruct.po.Car;
import com.pismery.mapstruct.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class                                  MapStructApplication {

    @Autowired
    private CarMapper carMapper;

    public static void main(String[] args) {
        //SpringApplication.run(MapStructApplication.class, args);

        Car car = new Car();
        car.setName("Pismery Car");
        car.setNumberOfSeats(4);
        car.setCarType(CarType.AO_DI);
        car.setCreateDate(new Date());

        Person creator = new Person();
        creator.setFirstName("L");
        creator.setMiddleName("J");
        creator.setLastName("H");
        creator.setGender(Gender.MAN);

        car.setCreator(creator);

        CarDTO carDTO = CarMapper.INSTANCE.carToCarDTO(car);

        System.out.println(carDTO);

    }

}
