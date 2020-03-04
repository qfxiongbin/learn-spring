package org.brian.think.in.spring.ioc.container.overview.dependency.lookup;

import org.brian.think.in.spring.ioc.container.overview.dependency.annotation.Super;
import org.brian.think.in.spring.ioc.container.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyLookUpDemo {

    public static void main (String args[]) {
        //配置xml文件
        //启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");
        //按照Bean的名称查找
        lookUpInRealTime(beanFactory);
        //延时查找
        lookUpInLazy(beanFactory);
        //按类型查找
        lookUpByType(beanFactory);
        //按类型查找Bean的集合
        lookUpCollectionByType(beanFactory);
        //通过注解查找
        lookUpAnnotationByType(beanFactory);
    }

    private static void lookUpAnnotationByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查到所有标注 @Super 集合对象："+users);
        }
    }

    private static void lookUpCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查到所有User 集合对象："+users);
        }
    }

    private static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("按类型查找："+user);
    }

    private static void lookUpInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找："+user);

    }

    private static void lookUpInRealTime(BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找："+user);
    }
}
