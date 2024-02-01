package com.world2meet.superHeroesApi.application.validator;

import com.world2meet.superHeroesApi.domain.model.request.SuperHeroRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SuperHeroContainingNameValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SuperHeroRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "containedInName", "field.required", "El campo containedInName es necesario");
    }

}
