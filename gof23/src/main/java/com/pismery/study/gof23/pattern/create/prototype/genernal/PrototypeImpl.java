package com.pismery.study.gof23.pattern.create.prototype.genernal;

import com.pismery.study.gof23.pattern.create.prototype.Address;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PrototypeImpl implements Prototype {

    private String name;
    private Integer age;
    private Address address;


    @Override
    public Prototype copy() {
        PrototypeImpl result = new PrototypeImpl();
        result.setAddress(this.address);
        result.setAge(this.age);
        result.setName(this.name);

        return result;
    }

    @Override
    public String toString() {
        return "PrototypeImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
