package org.brian.think.in.spring.ioc.container.overview.dependency.domain;

import org.springframework.beans.factory.BeanNameAware;

public class User implements BeanNameAware {
    private String id;
    private String name;

    private transient String beanName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamel() {
        return name;
    }

    public void setNamel(String namel) {
        this.name = namel;
    }

    @Override
    public String toString() {
        return "User{" +
                "namel='" + name + '\'' +
                '}';
    }

    public void setBeanName(String s) {
        this.beanName = s;
    }
}
