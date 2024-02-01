package com.world2meet.superHeroesApi.application.validator;

import com.world2meet.superHeroesApi.domain.model.SuperHeroDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SuperHeroDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SuperHeroDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "superHeroName", "field.required", "The field superHeroName is required");
    }
}
