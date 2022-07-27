package com.pismery.mapstruct.map;

import com.pismery.mapstruct.dto.CarDTO;
import com.pismery.mapstruct.dto.PersonDTO;
import com.pismery.mapstruct.po.Car;
import com.pismery.mapstruct.po.Person;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    @Mapping(source = "createDate", target = "createDate", dateFormat = "yyyy-MM-dd")
    CarDTO carToCarDTO(Car car);

    @AfterMapping
    default void convertNameToUpperCase(Person person, @MappingTarget PersonDTO personDTO) {
        personDTO.setName(person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName());
    }
}
