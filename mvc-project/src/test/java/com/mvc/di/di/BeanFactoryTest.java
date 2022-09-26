package com.mvc.di.di;

import com.mvc.di.UserController;
import com.mvc.di.annotation.Controller;
import com.mvc.di.annotation.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BeanFactoryTest {

    private Reflections reflections;
    private BeanFactory beanFactory;

    @BeforeEach
    @SuppressWarnings("all")
    public void setUp() {
        reflections = new Reflections("com.mvc.di");
        Set<Class<?>> preInstantiatedClazz = getTypesAnnotatedWith(Controller.class, Service.class);
        beanFactory = new BeanFactory(preInstantiatedClazz);
    }

    @SafeVarargs
    private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations) {
        return Arrays.stream(annotations)
                .flatMap(annotation -> reflections.getTypesAnnotatedWith(annotation).stream())
                .collect(Collectors.toSet());
    }

    @Test
    public void diTest() {
        UserController userController = beanFactory.getBean(UserController.class);
        assertNotNull(userController.getUserService());
    }

}
