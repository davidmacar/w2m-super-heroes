package com.world2meet.superHerosApi.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Anotación para métodos
@Retention(RetentionPolicy.RUNTIME) // Anotación para tiempo de ejecución
public @interface LogExecutionTimePort {
}
