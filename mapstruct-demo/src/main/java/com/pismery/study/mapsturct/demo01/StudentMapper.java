package com.pismery.study.mapsturct.demo01;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * @author 盒子
 * @since 2022/1/24
 */
@Mapper
// @Mapper(builder = @Builder(disableBuilder = true))
// @Mapper(componentModel = "spring")
public abstract class StudentMapper {
    public static final StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "age", target = "studentAge")
    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "gender", target = "sex", qualifiedByName = "convertGender")
    public abstract StudentDTO toStudentDTO(StudentDO studentDO);

    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "createDate", expression = "java(new java.util.Date())")
    public abstract StudentDO toStudentDO(StudentDTO studentDTO);

    @Named("convertGender")
    protected  String convertGender(Gender gender) {
        return gender.getName();
    }

    @BeforeMapping
    protected void flushEntity(StudentDO studentDO) {
        System.out.println("flush");
    }

    @AfterMapping
    protected  void afterMapping(StudentDO studentDO, @MappingTarget StudentDTO.StudentDTOBuilder builder) {
        builder.name(studentDO.getLastName() + " " + studentDO.getFirstName());
    }

    // @AfterMapping
    // protected  void afterMapping(StudentDO studentDO, @MappingTarget StudentDTO studentDTO) {
    //     studentDTO.setName(studentDO.getLastName() + " " + studentDO.getFirstName());
    // }


}
