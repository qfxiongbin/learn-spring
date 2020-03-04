package org.brian.think.in.spring.ioc.container.overview.dependency.domain;
import org.brian.think.in.spring.ioc.container.overview.dependency.annotation.Super;

@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                '}';
    }
}
